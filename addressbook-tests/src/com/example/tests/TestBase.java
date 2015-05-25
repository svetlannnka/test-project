package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.generateRandomString;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.generateRandomNumber;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
		//app = new ApplicationManager();
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(3)).iterator();	
	}

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
			for (GroupData group: groups) {
				list.add(new Object[]{group});
			}
		return list;
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
			return wrapContactsForDataProvider(generateRandomContacts(3)).iterator();	
		}

		public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
			List<Object[]> list = new ArrayList<Object[]>();
				for (ContactData contact: contacts) {
					list.add(new Object[]{contact});
				}
			return list;
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
	
	public String generateRandomInvalidString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "'";
		} else{
			return "'"+"NegativeTest" + rnd.nextInt();
		}
	}
	
}
