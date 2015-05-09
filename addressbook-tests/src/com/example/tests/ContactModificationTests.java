package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomContactModificationGenerator")
	public void modifyContactName(ContactData contact) {
		app.getNavigationalHelper().openMainPage();
		
		List<ContactData> oldContactList = app.getContactHelper().getContacts();
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactList.size()-1);
		
		app.getContactHelper().selectContactForModification(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
		oldContactList.remove(index);
		oldContactList.add(contact);
	    Collections.sort(oldContactList);
	    Collections.sort(newContactList);
	    assertEquals(newContactList, oldContactList);
	}
	
	@Test // contact modification using Details icon
	public void modifyContactDetailsName() {
		app.getNavigationalHelper().openMainPage();
		
		List<ContactData> oldContactList = app.getContactHelper().getContacts();
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactList.size()-1);
		
		app.getContactHelper().selectContactDetailForModification(index);
		app.getContactHelper().initContactDetailsModification();
		ContactData contact = new ContactData();
		contact.lastname = "Bond";
		contact.firstname = "James";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
		oldContactList.remove(index);
		oldContactList.add(contact);
	    Collections.sort(oldContactList);
	    Collections.sort(newContactList);
	    assertEquals(newContactList, oldContactList);
	}
}
