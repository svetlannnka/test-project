package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContact() {	
		//save old state
		SortedListOf<ContactData> oldContactList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldContactList.size()-1);
	    
		app.getContactHelper().deleteContact(index);
		
		//save new state
		SortedListOf<ContactData> newContactList = app.getContactHelper().getContacts();
	    
		//compare states
		assertThat(newContactList, equalTo(oldContactList.without(index)));
	}
	
}

