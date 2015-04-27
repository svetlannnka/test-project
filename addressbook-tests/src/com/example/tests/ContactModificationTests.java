package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifyContactFirstName() {
		app.getNavigationalHelper().openMainPage();
		app.getContactHelper().selectContactForModification(4);
		ContactData contact = new ContactData();
		contact.firstname = "New FirstName1";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
	
	@Test
	public void modifyContactLastName() {
		app.getNavigationalHelper().openMainPage();
		app.getContactHelper().selectContactForModification(1);
		ContactData contact = new ContactData();
		contact.lastname = "New LastName1";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
	
	@Test // contact modification using Details icon
	public void modifyContactDetailsFirstName() {
		app.getNavigationalHelper().openMainPage();
		app.getContactHelper().selectContactDetailForModification(2);
		app.getContactHelper().initContactDetailsModification();
		ContactData contact = new ContactData();
		contact.firstname = "New FirstName1";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
}
