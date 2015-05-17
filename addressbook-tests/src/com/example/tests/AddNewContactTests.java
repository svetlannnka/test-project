package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;

public class AddNewContactTests extends TestBase{

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    //save old state
	  SortedListOf<ContactData> oldContactList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().createContact(contact);
    
    //save new state
    SortedListOf<ContactData> newContactList = app.getContactHelper().getContacts();
    
    //compare states
	assertThat(newContactList, equalTo(oldContactList.withAdded(contact)));
  }

  
  @Test(dataProvider = "randomInvalidContactGenerator") //invalid input, new contact should not be created
  public void testContactCreationWithInvalidData(ContactData contact) throws Exception {
    app.navigateTo().mainPage();
    
    SortedListOf<ContactData> oldContactList = app.getContactHelper().getContacts();
    
    app.navigateTo().gotoAddNewPage();
	app.getContactHelper()
		.fillContactForm(contact, CREATION);
	app.getContactHelper().submitContactCreation()
    	.returnToHomePage();
    
    
	SortedListOf<ContactData> newContactList = app.getContactHelper().getContacts();
    
	assertThat(newContactList, equalTo(oldContactList));
  } 
} 
