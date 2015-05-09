package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i<5; i++){
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[]{group});
		}
		return list.iterator();	
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0){
			return "";
		} else{
			return "test" + rnd.nextInt();
		}
	}
	
	public String generateRandomNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(5)==0) {
			return "";
		} else {
			return "" + rnd.nextInt();
		}
	}
	
	public String generateRandomInvalidString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "'";
		} else{
			return "'"+"NegativeTest" + rnd.nextInt();
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i<2; i++){
			ContactData contact = new ContactData();
			contact.firstname = generateRandomString();
		    contact.lastname=generateRandomString();
		    contact.mainaddress ="address 1";
		    contact.homephone = "495 1234567";
			contact.mobile = "905 1234567";
			contact.workphone = "499 1234567";
			contact.email1 = "email1@gmail.com";
			contact.email2 = "email2@mail.ru";
			contact.bday = "1";
			contact.bmonth = "February";
			contact.byear = ""+ (Math.random()*100+1910);
			contact.groupname = "[none]";
			contact.secaddress = generateRandomString();
			contact.secphone = generateRandomNumber();
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomInvalidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i<2; i++){
			ContactData contact = new ContactData();
			contact.firstname =generateRandomInvalidString();
		    contact.lastname=generateRandomString();
		    contact.mainaddress ="address 1";
		    contact.homephone = "495 1234567";
			contact.mobile = "905 1234567";
			contact.workphone = "499 1234567";
			contact.email1 = "email1@gmail.com";
			contact.email2 = "email2@mail.ru";
			contact.bday = "1";
			contact.bmonth = "February";
			contact.byear = ""+ (Math.random()*100+1920);
			contact.groupname = "[none]";
			contact.secaddress = generateRandomInvalidString();
			contact.secphone = generateRandomNumber();
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	@DataProvider //different Data Provider for account Modification tests, without groupname input
	public Iterator<Object[]> randomContactModificationGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i<2; i++){
			ContactData contact = new ContactData();
			contact.firstname =generateRandomString();
		    contact.lastname=generateRandomString();
		    contact.mainaddress ="address 1";
		    contact.homephone = "495 1234567";
			contact.mobile = "905 1234567";
			contact.workphone = "499 1234567";
			contact.email1 = "email1@gmail.com";
			contact.email2 = "email2@mail.ru";
			contact.bday = "1";
			contact.bmonth = "February";
			contact.byear = ""+ (Math.random()*100+1920);
			contact.secaddress = generateRandomString();
			contact.secphone = generateRandomNumber();
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
}
