package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
		    ContactData contact = new ContactData()
		        .setFirstname(row.findElement(By.xpath(".//td[3]")).getText())
		        .setLastname(row.findElement(By.xpath(".//td[2]")).getText());
		    cachedContacts.add(contact);
		}
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().gotoAddNewPage();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		selectContactForModification(index+1);
		submitContactDeletion(); 
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		selectContactForModification(index+1);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContactDetails(int index, ContactData contact) {
		selectContactDetailForModification(index+1);
		initContactDetailsModification();
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
//--------------------------------------------------------------------------	
	public void fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
	    type(By.name("lastname"), contact.getLastname());
	    type(By.name("address"), contact.getMainaddress());
	    type(By.name("home"), contact.getHomephone());
	    type(By.name("mobile"), contact.getMobile());
	    type(By.name("work"), contact.getWorkphone());
	    type(By.name("email"), contact.getEmail1());
 	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	   	type(By.name("byear"), contact.getByear());	   	
	    if (formType == CREATION) {
	    	selectByText(By.name("new_group"), contact.getGroupname());
	    } 
	    /*else {
	    	if (driver.findElements(By.name("new_group")).size()!=0) {
	    		throw new Error ("Group selector exists in contact modification form");
	    	}}*/
	    type(By.name("address2"), contact.getSecaddress());
	    type(By.name("phone2"), contact.getSecphone());
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper selectContactForModification(int index) {
		click(By.xpath("//tr["+(index+1)+"]/td/a/img[@alt='Edit']"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']")); 
		// can't locate by element's 'update' name, it doubles on the page
		cachedContacts = null;
		return this;
	}

	public ContactHelper initContactDetailsModification() {
		// contact modification using Details icon
		click(By.name("modifiy"));
		return this;
	}

	public ContactHelper selectContactDetailForModification(int index) {
		click(By.xpath("//tr["+(index+1)+"]/td/a/img[@alt='Details']"));
		return this;
	}

	private void submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		// can't locate by element's name, it doubles on the page
		cachedContacts = null;
	}
	
	private List<WebElement> getContactRows() {
		return driver.findElements(By.xpath("//tr[@name='entry']"));
	}

}
