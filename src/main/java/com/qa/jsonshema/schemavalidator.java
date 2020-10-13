package com.qa.jsonshema;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class schemavalidator
{
  @Test(priority=1)
  public void jsonvalidatorforgetcall()
  {
	  //File files=new File("D:\\eclipse\\RestAussured_Automation\\DataFile\\com\\qa\\datafiles\\getschema.json");
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  given().log().all().header("Content-Type", "application/json").when().log().all().get("/booking").then().log().all().assertThat().
	  body(matchesJsonSchemaInClasspath("getschema.json"));
  }
  
  @Test(priority=2)
  public void Jsonschemavalidatorforpostcall()
  {
	  File files=new File("D:\\eclipse\\RestAussured_Automation\\DataFile\\com\\qa\\datafiles\\postschemabody.json");
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  given().log().all().header("Content-Type", "application/json").body(files).when().log().all().post("/booking").
	  then().log().all().assertThat().
	  body(matchesJsonSchemaInClasspath("postschemazdata.json"));
  }
}
