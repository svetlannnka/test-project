package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.fw.ContactHelper.CREATION;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;


public class AddNewContactTests extends TestBase{
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();	
	}

	@Test(dataProvider = "contactsFromFile")
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
