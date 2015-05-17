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
	private String name;
	private String footer;
	private String header;

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
		for (int i = 0; i<3; i++){
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
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
	public Iterator<Object[]> randomInvalidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i<3; i++){
			ContactData contact = new ContactData()
				.withFirstname(generateRandomInvalidString())
				.withLastname(generateRandomString())
				.withMainAddress("address1")
				.withHomePhone("495 1234567")
				.withMobile("905 1234567")
				.withWorkPhone("499 1234567")
				.withEmail1(generateRandomString() + "@gmail.com")
				.withEmail2(generateRandomString() + "@mail.ru")
				.withBday("1")
				.withBmonth("February")
				.withByear("" + (Math.random()*100+1910))
				.withGroupname("[none]")
				.withSecaddress(generateRandomInvalidString())
				.withSecphone(generateRandomNumber());
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i<3; i++){
			ContactData contact = new ContactData()
				.withFirstname(generateRandomString())
				.withLastname(generateRandomString())
				.withMainAddress("address1")
				.withHomePhone("495 1234567")
				.withMobile("905 1234567")
				.withWorkPhone("499 1234567")
				.withEmail1(generateRandomString() + "@gmail.com")
				.withEmail2(generateRandomString() + "@mail.ru")
				.withBday("1")
				.withBmonth("February")
				.withByear("" + (Math.random()*100+1910))
				.withGroupname("[none]")
				.withSecaddress(generateRandomString())
				.withSecphone(generateRandomNumber());
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
}
