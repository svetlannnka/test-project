package com.example.tests;

import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    gotoAddNewPage();
    ContactData contact = new ContactData();
    contact.firstname="first name";
    contact.lastname="last name";
    contact.mainaddress ="address 1";
    contact.homephone = "495 1234567";
	contact.mobile = "905 1234567";
	contact.workphone = "499 1234567";
	contact.email1 = "email1@gmail.com";
	contact.email2 = "email2@mail.ru";
	contact.bday = "1";
	contact.bmonth = "February";
	contact.byear = "1960";
	contact.groupname = "Group 1";
	contact.secaddress = "address 2";
	contact.secphone = "516 1234567";
	fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    gotoAddNewPage();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", "");
	fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }
}