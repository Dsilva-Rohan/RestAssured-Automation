package com.qa.pojo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;


public class pojopostcall
{
	pojoTemplate pojoobject=new pojoTemplate("Christopher", "Rohan","male","02-02-1986","koko1k@yahoo.com",
			"+9845281948","https://www.naveenautomation.com","123,new Jercy","active");
	
	@Test
	public void pojojsonserialisation() throws JsonProcessingException
	{
		
		ObjectMapper map=new ObjectMapper();
		String jsondata=map.writeValueAsString(pojoobject);
		System.out.println(jsondata);
		RestAssured.baseURI="https://gorest.co.in";
		RestAssured.given().log().all().header("Content-Type","application/json").headers("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k")
		.body(jsondata).when().log().all().post("/public-api/users").then().log().all().assertThat().statusCode(200).and()
		.body("result.email", equalTo(pojoobject.getemail()))
		.body("result.first_name", equalTo(pojoobject.getfirst_name()))
		.body("result.last_name", equalTo(pojoobject.getlast_name()));
	}
}
