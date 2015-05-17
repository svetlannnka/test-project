package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String mainaddress;
	private String homephone;
	private String mobile;
	private String workphone;
	private String email1;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String groupname;
	private String secaddress;
	private String secphone;

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

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", "+ "lastname=" + lastname
				+ /*", homephone=" + homephone + */"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		/*result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((homephone == null) ? 0 : homephone.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());*/
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ContactData other) {
		//return this.lastname.compareTo(other.lastname);
		
		int lnameCompare = this.lastname.compareTo(other.lastname);  //no need to use LowerCase method for contacts
		int fnameCompare = this.firstname.compareTo(other.firstname);
		if (lnameCompare != 0) { 
			return lnameCompare;
		} else {
		 return fnameCompare;
		}
	}
	
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public ContactData withMainAddress(String mainaddress) {
		this.mainaddress = mainaddress;
		return this;
	}
	public ContactData withHomePhone(String homephone) {
		this.homephone = homephone;
		return this;
	}

	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public ContactData withWorkPhone(String workphone) {
		this.workphone = workphone;
		return this;
	}

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactData withGroupname(String groupname) {
		this.groupname = groupname;
		return this;
	}

	public ContactData withSecaddress(String secaddress) {
		this.secaddress = secaddress;
		return this;
	}

	public ContactData withSecphone(String secphone) {
		this.secphone = secphone;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMainaddress() {
		return mainaddress;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getGroupname() {
		return groupname;
	}

	public String getSecaddress() {
		return secaddress;
	}

	public String getSecphone() {
		return secphone;
	}

	public ContactData setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	


}