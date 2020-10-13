package com.qa.pojo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class deleteAPIcall
{
  
	pojoTemplate deleteobject=new pojoTemplate("Christopher", "Rohan","male","02-02-1986","kkllloo@yahoo.com",
			"+9845281948","https://www.naveenautomation.com","123,new Jercy","active");
	
	@Test()
	public void deleteAPIcalltest() throws JsonProcessingException
	{
		ObjectMapper objectjson=new ObjectMapper();
		String jsonvalues=objectjson.writeValueAsString(deleteobject);
		
		System.out.println("***********************Post Call Begins*********************************");
		
		RestAssured.baseURI="https://gorest.co.in";
		String idvalue=RestAssured.given().log().all().header("Content-Type","application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k")
		.body(jsonvalues).when().log().all().post("/public-api/users").then().log().all().assertThat().extract().path("result.id");
		
		System.out.println("***********************Post Call Ends*********************************");
		
		System.out.println("***********************Get Call Begins*********************************");		
		RestAssured.given().log().all().header("Content-Type","application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k").when().log().all()
	   .get("/public-api/users/"+idvalue).then().log().all().assertThat().
	    statusCode(200).body("result.id", equalTo(idvalue));
		System.out.println("***********************Get Call Ends*********************************");	
		
		System.out.println("***********************Delete Call Begins*********************************");
		
		RestAssured.given().log().all().header("Content-Type","application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k").
		when().log().all().delete("/public-api/users/"+idvalue).then().log().all().assertThat().statusCode(200);
		
		System.out.println("***********************Delete Call Ends*********************************");
		
		System.out.println("***********************Get Call Begins*********************************");		
		RestAssured.given().log().all().header("Content-Type","application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k").when().log().all().
	   get("/public-api/users/"+idvalue).then().log().all().assertThat().
	    statusCode(200).body("_meta.code", equalTo(404)).and().body("_meta.rateLimit.limit", equalTo(60));
		System.out.println("***********************Get Call Ends*********************************");	
		
		
		
		
	}

}
