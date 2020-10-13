package com.qa.pojo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class pojoputAPIcall 
{
  pojoTemplate pojopuobject=new pojoTemplate("Roman", "Rien","male","02-02-1984","paka@gmail.com",
			"+9876543210","https://www.naveenautomationlabs.com","lakkasandra,Dairy Circle, Bangalore","active");
  
  @Test
  public void postcalltest() throws JsonProcessingException
  {
	  ObjectMapper obj=new ObjectMapper();
	  String jsonvalues=obj.writeValueAsString(pojopuobject);
	  System.out.println("Jsonvalues"+jsonvalues);
	  
	  RestAssured.baseURI="https://gorest.co.in";
	  String id= RestAssured.given().log().all().
			  header("Content-Type","application/json").
			  header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k")
	  .body(jsonvalues).when().log().all().post("/public-api/users").then().log().all()
	  .assertThat().extract().path("result.id");
	  System.out.println("newly created id:::"+id);
	  System.out.println(".................Post call completed.................\n\n");
	  
	  System.out.println(".................Get call Begins.................\n\n");
	  RestAssured.given().log().all().header("Content-Type","application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k")
	  .when().log().all().get("/public-api/users/"+id).then().log().all();
	  System.out.println(".................Get call Ends.................\n\n");
	  
	  
	  System.out.println(".................Put call Start.................\n\n");
	  pojopuobject.setfirst_name("Diggaja");
	  pojopuobject.setemail("kudos@saka.com");
	  ObjectMapper objput=new ObjectMapper();
	  String putjson=objput.writeValueAsString(pojopuobject);
	  RestAssured.given().log().all().header("Content-Type","application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k")
	  .body(putjson).when().log().all().put("/public-api/users/"+id).then().log().all().assertThat().
	  statusCode(200).and().contentType(ContentType.JSON).and().body("result.first_name",equalTo(pojopuobject.getfirst_name()));
	  System.out.println(".................Put call Ends.................\n\n");
	  
	  System.out.println(".................Get call Begins.................\n\n");
	  RestAssured.given().log().all().header("Content-Type","application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k")
	  .when().log().all().get("/public-api/users/"+id).then().log().all();
	  System.out.println(".................Get call Ends.................\n\n");
	  
	  
  }
}
