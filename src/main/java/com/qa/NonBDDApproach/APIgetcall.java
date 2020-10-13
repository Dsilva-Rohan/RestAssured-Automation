package com.qa.NonBDDApproach;

import java.util.HashMap;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APIgetcall 
{
  @Test(priority=1)
  public void GetAPICall()
  {
	  RestAssured.baseURI="https://gorest.co.in";
	  RequestSpecification req=RestAssured.given().log().all().header("Content-Type", "application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k");
	  Response res=req.get("/public-api/users");
	 ResponseBody k= res.getBody();
	
	  int code=res.getStatusCode();
	  System.out.println(k.prettyPrint());
	  System.out.println("Status code:::::"+code);
  }
  
  @Test(priority=2)
  public void GetAPICallquery()
  {
	  RestAssured.baseURI="https://gorest.co.in";
	  RequestSpecification req=RestAssured.given().log().all().header("Content-Type", "application/json").header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k")
	  .queryParam("first_name", "christopher")
	  .queryParam("gender","male");
	  Response res=req.get("/public-api/users");
	  ResponseBody k=res.getBody();
	  int code=res.getStatusCode();
	  System.out.println(res.prettyPrint());
	  System.out.println("Status code:::::"+code);
  }
  @Test(priority=3)
  public void GetAPICallqueryother()
  {
	  RestAssured.baseURI="https://gorest.co.in";
	  RequestSpecification req=RestAssured.given().log().all();
	  req.header("Content-Type", "application/json");
	  req.header("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k");
	  req.queryParam("first_name", "christopher");
	  req.queryParam("gender","male");
	  Response res=req.get("/public-api/users");
	  res.getBody();
	  int code=res.getStatusCode();
	  System.out.println(res.prettyPrint());
	  System.out.println("Status code:::::"+code);
  }
  
  @Test(priority=3)
  public void Hashmaptest()
  {
	  RestAssured.baseURI="https://gorest.co.in";
	 
	  HashMap<String, String> maps=new HashMap<String,String>();
	  maps.put("Content-Type", "application/json");
	  maps.put("Authorization", "Bearer m7a0oZMli0h0K48h5xecpJxOddIAqzZizl8k");
	  RequestSpecification req=RestAssured.given().log().all();
	  req.headers(maps);
	  HashMap<String, String> querymap=new HashMap<String,String>();
	  querymap.put("first_name","Roman");
	  querymap.put("gender","male");
	  req.queryParams(querymap);
	  Response res=req.get("/public-api/users");
	
	  int code=res.getStatusCode();
	  System.out.println(res.prettyPrint());
	  System.out.println("Status code:::::"+code);
  }
  
}
