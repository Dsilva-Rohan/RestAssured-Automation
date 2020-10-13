package com.qa.rest.getAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class getBBDapproch 
{
  @Test(priority=1)
  public void getAPIMethod()
  {
	  given().when().get("http://ergast.com/api/f1/2017/cicuites.json")
	  .then().assertThat().body("MRData.CircuitTable.Circuites.circuiteId", hasSize(20))
	  .and().body("MRData.CircuitTable",equalTo("test"));
	  
  }
  
  /* With Log Data */
  @Test(priority=2)
  public void getAPIMethodlog()
  {
	  given().log().all().when().log().all().get("http://ergast.com/api/f1/2017/cicuites.json")
	  .then().log().all().assertThat().body("MRData.CircuitTable.Circuites.circuiteId", hasSize(20));
	  
  }
  
  /* How to get response and status code */
  @Test(priority=3)
  public void getAPIResponse()
  {
	  Response response=given().when().get("https://turnertrackerqa.clearhub.tv");
	  int statuscode=response.getStatusCode();
	  Assert.assertEquals(statuscode, 200);
	  
	  
  }
  
  /* How to get response and status code with log method*/
  @Test(priority=4)
  public void getAPIResponsewithlog()
  {
	  Response response=given().log().all().when().log().all().get("https://turnertrackerqa.clearhub.tv");
	  int statuscode=response.getStatusCode();
	  Assert.assertEquals(statuscode, 200);
	  System.out.println(response.prettyPrint());
	  String s= response.getContentType();
	  ResponseBody k=response.getBody();
  }
  
 /* How to write URI and URL and service URL */
  @Test(priority=5)
  public void restcallbaseURI()
  {
	  RestAssured.baseURI="http://ergast.com/";
	 given().when().get("api/f1/2017/cicuites.json").
	 then().assertThat().statusCode(200).and()
	 .contentType(ContentType.JSON).and().header("Content-Lenght", equalTo(123));
	  
  }
  
  /* How to write URI and URL and service URL */
  @Test(priority=6)
  public void bodyvalidation()
  {
	  given().log().all().
	  when().log().all().
	  get("http://md5.jsontest.com?text=test").then().log().all().
	  assertThat().body("md5",equalTo("dssdfgfdg"));
	  
  }
  
  /* How to get status code */
  @Test(priority=7)
  public void satuscode()
  {
	  given().log().all().
	  when().log().all().
	  get("http://md5.jsontest.com?text=test").then().log().all().
	  assertThat().statusCode(200);
	  
  }
  
  /* How to add query parameter code */
  @Test(priority=8)
  public void qyeryparameter()
  {
	  given().log().all().param("text", "test").log().all().
	  when().log().all().
	  get("http://md5.jsontest.com").then().log().all().
	  assertThat().statusCode(200);
	  
  }
  
  /* how to use queryparameter for multiple parametar */
  @Test(priority=9)
  public void multiplequeryparameter()
  {
	  given().param("Gender","male").param("user", "Christopher").log().all().when().log().all().get("http://chris.jsontest.com")
	  .then().log().all().assertThat().statusCode(200);
	  
	  
  }
   
  /* How to use path parameter */
  @Test(priority=10)
  public void Queryparameter()
  {
	  given().log().all().pathParam("test", "rohan")
	  .log().all().when().get("http://daphney.jsontest.com/{test}")
	  .then().log().all().assertThat().statusCode(200);
  }
  
  @DataProvider(name="multipledata")
  public Object[][] sumbitdata()
  {
	  Object data[][]= {{"2000",20},{"2001",30},{"2002",40}};
	  return data;
  }
  
  @Test(dataProvider="multipledata",priority=11)
  public void dataadding(String s1, int s2)
  {
	  given().log().all().pathParam("parameter",s1).when().log().all().get("http://ergast.com/api/f1/{parameter}/cicuites.json")
	  .then().log().all().assertThat().body("MRData.CircuitTable.Circuites.circuiteId", hasSize(s2));
  }
}
