package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String mainaddress;
	public String homephone;
	public String mobile;
	public String workphone;
	public String email1;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String groupname;
	public String secaddress;
	public String secphone;

	public ContactData(){
	}
	
	public ContactData(String firstname, String lastname, String mainaddress,
			String homephone, String mobile, String workphone, String email1,
			String email2, String bday, String bmonth, String byear,
			String groupname, String secaddress, String secphone) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.mainaddress = mainaddress;
		this.homephone = homephone;
		this.mobile = mobile;
		this.workphone = workphone;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.groupname = groupname;
		this.secaddress = secaddress;
		this.secphone = secphone;
	}
}