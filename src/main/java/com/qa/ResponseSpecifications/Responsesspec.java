package com.qa.ResponseSpecifications;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class Responsesspec 
{
	//How to handle multiple assert as single statement by using the responsespec builder and reposncespecification 
	ResponseSpecBuilder resp=new ResponseSpecBuilder();
	ResponseSpecification spec=resp.expectContentType(ContentType.JSON).
	expectStatusCode(200).expectHeader("Server","ngnix").build();
	
	ResponseSpecification speccode=resp.expectStatusCode(401).build();
	
	@Test()
	public void responsespecvalidation()
	{
		RestAssured.baseURI="https://gorest.co.in";
		given().header("Authorisation","Bearer _mXXE9NKef2APhw0P7nojDf-fzB6qOMqaVk8a").when()
		.get("/public-api/users")
		.then().assertThat().spec(spec);
	}
	
	//responsespec builder and reposncespecification usage
	@Test()
	public void unauthrisedstatuscodevalidation()
	{
		RestAssured.baseURI="https://gorest.co.in";
		given().header("Authorisation","Bearer _mXXE9NKef2APhw0P7nojDf-fzB6qOMqaVk8").
		when().get("/public-api/users").then().assertThat().spec(speccode);
		
	}

}
	