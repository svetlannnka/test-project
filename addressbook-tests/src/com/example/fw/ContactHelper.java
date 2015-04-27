package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
	    type(By.name("lastname"), contact.lastname);
	    type(By.name("address"), contact.mainaddress);
	    type(By.name("home"), contact.homephone);
	    type(By.name("mobile"), contact.mobile);
	    type(By.name("work"), contact.workphone);
	    type(By.name("email"), contact.email1);
 	    type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	   	type(By.name("byear"), contact.byear);	   	
	   	selectByText(By.name("new_group"), contact.groupname);
	    type(By.name("address2"), contact.secaddress);
	    type(By.name("phone2"), contact.secphone);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void selectContactForModification(int i) {
		click(By.xpath("//tr["+(i+1)+"]/td/a/img[@alt='Edit']"));
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']")); 
		// can't locate by element's 'update' name, it doubles on the page
	}

	public void initContactDetailsModification() {
		// contact modification using Details icon
		click(By.name("modifiy"));
	}

	public void selectContactDetailForModification(int i) {
		click(By.xpath("//tr["+(i+1)+"]/td/a/img[@alt='Details']"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']")); 
		// can't locate by element's name, it doubles on the page
	}

	
}
