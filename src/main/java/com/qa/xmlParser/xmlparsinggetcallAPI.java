package com.qa.xmlParser;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class xmlparsinggetcallAPI
{
	@Test
	public void WithoutxmlparsingGETCall()
  {
	 RestAssured.baseURI="https://gorest.co.in";
	 Response res=RestAssured.given().log().all().header("Accept","application/xml").
			 header("Authorization","Bearer qfmVaH7RHcJ5DXrKf1RsZCrRS9n0hQ8UIxuu")
	 .when().log().all().get("/public-api/users");
	 
	 System.out.println(res.getStatusCode());
	 System.out.println(res.prettyPrint());
	 Assert.assertEquals(res.getStatusCode(), 200);
	 XmlPath data= res.xmlPath();
	  String xmlvalue=data.get("response._meta.rateLimit.limit");
	  System.out.println("Datavalues for limit::::"+xmlvalue);
	 Assert.assertEquals(xmlvalue, "60");
	 
  }
	
	@Test
	public void WithxmlparsingGETCall()
  {
	 RestAssured.baseURI="https://gorest.co.in";
	 Response res=RestAssured.given().log().all().header("Accept","application/xml").
			 header("Authorization","Bearer qfmVaH7RHcJ5DXrKf1RsZCrRS9n0hQ8UIxuu")
	 .when().log().all().get("/public-api/users");
	 
	 System.out.println(res.getStatusCode());
	 String results=res.prettyPrint();
	 XmlParser parsing=new XmlParser(results);
	 String limitvalue=parsing.getTextContent("//response//_meta//rateLimit//limit");
	 System.out.println("Datavalues for limit::::"+limitvalue);
	 Assert.assertEquals(limitvalue, "60");
	 
	
  }
	
}
