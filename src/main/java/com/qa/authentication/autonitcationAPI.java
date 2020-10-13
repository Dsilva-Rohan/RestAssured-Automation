package com.qa.authentication;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

/**
 * 
 * @author rohan
 *
 */

public class autonitcationAPI
{
  
  /*How to handle basic authenitcation (username and password) */
  @Test
  public void basicauthonitcation()
  {
	 given().log().all().auth().preemptive().basic("admin", "admin").when().log().all().
	 get("https://the-internet.herokuapp.com/basic_auth")
	 .then().log().all().assertThat().statusCode(200);
  }
  
 /* How to perform auth2.0 authentication  in restAssured */
  @Test
  public void Oauth2authentication()
  {
	 given().log().all().auth().oauth2("Bearer _JHOKRWYvx6B4-cBnxqNkht5bRMa6ZnMwfvgq").when().log().all()
	 .get("https://gorest.co.in/public-api/users").
	 then().log().all().assertThat().statusCode(200);  
  }
  
  /* How to perform auth2.0 authentication  in restAssured without2.0autho keyword*/
  @Test
  public void Oauth2authenticationdirect()
  {
	 given().contentType("application/json").header("Authorization","Bearer_mXXE9NKef2APhw0P7nojDf-fzB6qOMqaVk8a").log().all().when().log().all()
	 .get("https://gorest.co.in/public-api/users").
	 then().log().all().assertThat().statusCode(200).and().header("server", "nginx");  
  }
  
 
  @Test
  public void Oathparameter()
  {
	  RestAssured.baseURI="https://gorest.co.in";
	  
	  RestAssured.given().log().all().contentType("application/json").header("Autherization", "Bearer _Bearer_mXXE9NKef2APhw0P7nojDf-fzB6qOMqaVk8a")
	  .queryParam("name", "john")
	  .queryParam("gender", "female")
	  .when().log().all().get("/public-api/users").then().log().all().assertThat().statusCode(200).and().header("server", "nginx");
  }
  
  
  
}
