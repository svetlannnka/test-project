package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationalHelper().openMainPage();
		
		//save old state
	    List<ContactData> oldContactList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldContactList.size()-1);
	    
		app.getContactHelper().selectContactForModification(index);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
		
		//save new state
	    List<ContactData> newContactList = app.getContactHelper().getContacts();
	    
		//compare states
		oldContactList.remove(index);
	    Collections.sort(oldContactList);
	    Collections.sort(newContactList);
	    assertEquals(newContactList, oldContactList);
	}
	
	/*@Test
	public void deleteSomeContact() {//deleting many contacts
		for (int i = 1; i<=10; i++) { 
		app.getNavigationalHelper().openMainPage();
		app.getContactHelper().selectContactForModification(12);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}
	}*/
}

