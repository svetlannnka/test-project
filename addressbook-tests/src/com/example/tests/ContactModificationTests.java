package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static com.example.fw.ContactHelper.MODIFICATION;
import java.util.Random;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContactName(ContactData contact) {
		SortedListOf<ContactData> oldContactList = app.getContactHelper().getContacts();
	
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactList.size()-1);
		
	    app.getContactHelper().modifyContact(index, contact);
		
	    SortedListOf<ContactData> newContactList = app.getContactHelper().getContacts();
	    
	    assertThat(newContactList, equalTo(oldContactList.without(index).withAdded(contact)));
	}
	
	@Test(dataProvider = "randomValidContactGenerator") // contact modification using Details icon
	public void modifyContactDetailsName(ContactData contact) {
		SortedListOf<ContactData> oldContactList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactList.size()-1);
		
	    app.getContactHelper().modifyContactDetails(index, contact);
		
	    SortedListOf<ContactData> newContactList = app.getContactHelper().getContacts();
	    
	    assertThat(newContactList, equalTo(oldContactList.without(index).withAdded(contact)));
	}
}
