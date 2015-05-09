package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.getNavigationalHelper().openMainPage();
    
    //save old state
    List<ContactData> oldContactList = app.getContactHelper().getContacts();
    
    //actions
    app.getNavigationalHelper().gotoAddNewPage();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    //save new state
    List<ContactData> newContactList = app.getContactHelper().getContacts();
    
    //compare states
    oldContactList.add(contact);
    Collections.sort(oldContactList);
    Collections.sort(newContactList);
    assertEquals(newContactList, oldContactList);
  }

  
  @Test(dataProvider = "randomInvalidContactGenerator") //invalid input, new contact should not be created
  public void testContactCreationWithInvalidData(ContactData contact) throws Exception {
    app.getNavigationalHelper().openMainPage();
    
    List<ContactData> oldContactList = app.getContactHelper().getContacts();
    
    app.getNavigationalHelper().gotoAddNewPage();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    List<ContactData> newContactList = app.getContactHelper().getContacts();
    
    Collections.sort(oldContactList);
    Collections.sort(newContactList);
    assertEquals(newContactList, oldContactList);
  }  
} 
