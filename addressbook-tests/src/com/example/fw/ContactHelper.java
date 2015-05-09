package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

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
		click(By.xpath("//tr["+(i+2)+"]/td/a/img[@alt='Edit']"));
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
		click(By.xpath("//tr["+(i+2)+"]/td/a/img[@alt='Details']"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']")); 
		// can't locate by element's name, it doubles on the page
	}
	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements (By.name("selected[]"));
		for (int i = 0; i < checkboxes.size(); i++) {
		String lastname = driver.findElement(By.xpath("//tr[" + (i + 2) + "]/td[2]")).getText();
		String firstname = driver.findElement(By.xpath("//tr[" + (i + 2) + "]/td[3]")).getText();
		contacts.add(new ContactData().hasLastname(lastname).hasFirstname(firstname));
		}
	return contacts;
	}
	
}
