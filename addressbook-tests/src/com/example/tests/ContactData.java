package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
	public ContactData hasLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public ContactData hasFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
}