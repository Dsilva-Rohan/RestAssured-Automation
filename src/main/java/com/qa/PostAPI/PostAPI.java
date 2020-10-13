package com.qa.PostAPI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAPI
{
   @Test(priority=1)
	public void postapicall()
   {
	   RestAssured.baseURI="https://restful-booker.herokuapp.com";
	   given().log().all().header("Content-Type","application/json").
	   body("{\"username\":\"admin\",\"password\":\"password123\"}").
	   when().log().all().post("/auth").then().log().all().assertThat().statusCode(200);
	   
   }
   @Test(priority=2)
	public void postapicallwithresponse()
  {
	   SoftAssert asserting=new SoftAssert();
	   RestAssured.baseURI="https://restful-booker.herokuapp.com";
	   
	   RequestSpecification request=given().log().all().header("Content-Type","application/json").
	   body("{\"username\":\"admin\",\"password\":\"password123\"}");
	   
       Response res=request.post("/auth");
       int i=res.getStatusCode();
       System.out.println("Statuscode:::::"+i);
       String tokens=res.jsonPath().getString("token");
       System.out.println("Created token:::::"+tokens);
       asserting.assertEquals(i, 200);
  }
   
   @Test(priority=3, description="Picking the payload from File")
   public void postcallwithfile()
   {
 	   SoftAssert asserting=new SoftAssert();
 	   File files=new File("D:\\eclipse\\RestAussured_Automation\\DataFile\\com\\qa\\datafiles\\jsondata.json");
 	   RestAssured.baseURI="https://restful-booker.herokuapp.com";
 	   
 	   RequestSpecification request=given().log().all().header("Content-Type","application/json").body(files);
 	   
        Response res=request.post("/auth");
        int i=res.getStatusCode();
        System.out.println("Statuscode after file pick:::::"+i);
        String tokens=res.jsonPath().getString("token");
        System.out.println("Created token after file pick:::::"+tokens);
        asserting.assertEquals(i, 200);
        asserting.assertNotNull(tokens);
        asserting.assertAll();
   }
   
   @Test(priority=3, description="Using extract BDD method for reading the token")
   public void postcallwithfileandextractmethod()
   {
 	   SoftAssert asserting=new SoftAssert();
 	   File files=new File("D:\\eclipse\\RestAussured_Automation\\DataFile\\com\\qa\\datafiles\\jsondata.json");
 	   RestAssured.baseURI="https://restful-booker.herokuapp.com";
 	   
 	   RequestSpecification request=given().log().all().header("Content-Type","application/json").body(files);
 	   
       String tokenread= request.post("/auth").then().extract().path("token");
       Assert.assertNotNull(tokenread);
        
   }
   
   @Test(priority=4, description="bodyvalidation")
   public void postcallresponsebodyvalidation()
   {
 	   
 	   File book=new File("D:\\eclipse\\RestAussured_Automation\\DataFile\\com\\qa\\datafiles\\bookdata.json");
 	   RestAssured.baseURI="https://restful-booker.herokuapp.com";
 	   RequestSpecification request=given().log().all().header("Content-Type","application/json").body(book);
 	   request.post("/booking").then().log().all().assertThat().
 	   body("booking.depositpaid",equalTo(true));
 	
        
   }
}
