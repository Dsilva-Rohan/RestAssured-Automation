package com.qa.pojo;

public class pojoTemplate
{ 
	private String first_name;
	private String last_name;
	private String gender;
	private String email;
	private String status;
	private String phone;
	private String dob;
	private String website;
	private String address;
	
	
	
	public pojoTemplate(String first_name, String last_name, String gender, String dob, String email, String phone, String website, String address, String status)
	{
		this.first_name=first_name;
		this.last_name=last_name;
		this.gender=gender;
		this.dob=dob;
		this.email=email;
		this.phone=phone;
		this.website=website;
		this.address=address;
		this.status=status;
		
	}
	 public String getfirst_name()
	 {
		return  first_name;
	 }
	 
	 public String getlast_name()
	 {
		return  last_name;
	 }
	 public String getgender()
	 {
		return  gender;
	 }
	 
	 public String getdob()
	 {
		return  dob;
	 }
	 
	 public String getemail()
	 {
		return  email;
	 }
	 public String getphone()
	 {
		return  phone;
	 }
	 public String getwebsite()
	 {
		return  website;
	 }
	 public String getaddress()
	 {
		return  address;
	 }
	 
	 public String getstatus()
	 {
		return  status;
	 }
	 
	 public void setfirst_name(String first_name)
	 {
		 this.first_name=first_name;
	 }
	 
	 public void setlast_name(String last_name)
	 {
		 this.last_name=last_name;
	 }
	 
	 public void setgender(String gender)
	 {
		 this.gender=gender;
	 }
	 
	 public void setdob(String dob)
	 {
		this.dob=dob;
	 }
	 
	 public void setemail(String email)
	 {
		 this.email=email;
	 }
	 
	 public void setphone(String phone)
	 {
		 this.phone=phone;
	 }
	 
	 
	 public void setwebsite(String website)
	 {
		 this.website=website;
	 }
	 
	 
	 public void setaddress(String address)
	 {
		 this.address=address;
	 }
	 
	 public void setstatus(String status)
	 {
		this.status=status;
	 }
	 
	 
}
