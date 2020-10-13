package com.qa.authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class otherauthsAPI
{
	@Test
	  public void basicauthonitcation()
	  {
		 given().log().all().auth().preemptive().basic("admin", "admin").when().log().all().
		 get("https://the-internet.herokuapp.com/basic_auth")
		 .then().log().all().assertThat().statusCode(200);
	  }
	

	@Test
	  public void onlybasicauthonitcation()
	  {
		 given().log().all().auth().basic("admin", "admin").when().log().all().
		 get("https://the-internet.herokuapp.com/basic_auth")
		 .then().log().all().assertThat().statusCode(200);
	  }
	
	@Test
	  public void digestauthonitcation()
	  {
		 given().auth().digest("admin", "admin").when().log().all().
		 get("https://the-internet.herokuapp.com/basic_auth")
		 .then().log().all().assertThat().statusCode(200);
	  }
	
	@Test
	  public void formbasedauthentication()
	  {
		FormAuthConfig config=new FormAuthConfig("https://the-internet.herokuapp.com/authontication.cfm","username", "password");
		RestAssured.baseURI="https://the-internet.herokuapp.com";
		RestAssured.given().auth().form("admin", "admin",config).when().get("/authontication.cfm")
		.then().assertThat().statusCode(200);
	  }


}

