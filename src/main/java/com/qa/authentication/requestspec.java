package com.qa.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class requestspec
{
 /* how to handle request specification interface and response interface*/
	@Test
	public void requestspecificationhandle()
	{
		RequestSpecification request= RestAssured.given().log().all().auth().oauth2("mXXE9NKef2APhw0P7nojDf-fzB6qOMqaVk8a");
		Response response=request.post("https://gorest.co.in/public-api/users");
		int i=response.getStatusCode();
		
		Assert.assertEquals(i, 200);
	}
	 
	/* how to use Formparameter and generate the token during run time from token generationapi and pass to next api */
	//generating Token
	@Test
	  public void accesstokenandformparameter()
	  {
		 SoftAssert asserts=new SoftAssert();
		RequestSpecification request= RestAssured.given().
		 formParam("client_id", "NovApi").
		 formParam("Client_Secret","mXXE9NKef2APhw0P7nojDf").
		 formParam("GrantType", "Authorisation Code").
		 contentType("application/json");
		 Response response=request.post("http://ergast.com/token");
		 response.getTime();
		 int i=response.getStatusCode();
		 System.out.println(response.getStatusCode());
		 asserts.assertEquals(i, 200);
		 String tokenid=response.jsonPath().getString("access_tokne");
		 System.out.println("Accesstoken"+tokenid);
		 
		  RequestSpecification request2= RestAssured.given().log().all().auth().oauth2(tokenid);
		  Response response2=request2.post("https://gorest.co.in/public-api/users");
		  int k=response2.getStatusCode();
		  asserts.assertEquals(k, 200);
		  asserts.assertAll();

	  }
	
	/* how to handle authontication1.0 */
	
	@Test
	public void auth1()
	{
		RestAssured.given().auth().oauth("mXXE9NKef2APhw0P7nojDf", 
				"mXXE9NKef2APhw0P7nojDf",
				"mXXE9NKef2APhw0P7nojDf", 
				"mXXE9NKef2APhw0P7nojDf").when().post("https://gorest.co.in/public-api/users").then().assertThat().statusCode(200);
	}
	
	public void auth2()
	{
		RequestSpecification req=RestAssured.given().auth().oauth("mXXE9NKef2APhw0P7nojDf", 
				"mXXE9NKef2APhw0P7nojDf",
				"mXXE9NKef2APhw0P7nojDf", 
				"mXXE9NKef2APhw0P7nojDf");
		Response res=req.post("https://gorest.co.in/public-api/users");
		System.out.println(res.getStatusCode());
		int i=(int) res.getTime();
		System.out.println("**************************************************"+i);
	}
	
	
}
