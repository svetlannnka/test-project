package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}

		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}
	
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);	
		} else {
			System.out.println("Unknown format: " + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {	
		FileWriter writer = new FileWriter(file);
		for (ContactData contact: contacts) {
			writer.write(contact.getFirstname() + "," 
					+ contact.getLastname() + "," 
					+ contact.getMainaddress() +",!"
					+ contact.getHomephone() +",!"
					+ contact.getMobile() +",!"
					+ contact.getWorkphone() +",!"
					+ contact.getEmail1() +",!"
					+ contact.getEmail2() +",!"
					+ contact.getBday() +",!"
					+ contact.getBmonth() +",!"
					+ contact.getByear() +",!"
					+ contact.getGroupname() +",!"
					+ contact.getSecaddress() +",!"
					+ contact.getSecphone() +",!"
					+ "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file); 
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine(); 
		while (line != null) {
			String[] part = line.split(",");
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
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
		}

	public static List<ContactData> generateRandomContacts(int amount) {
			List<ContactData> list = new ArrayList<ContactData>();
			for (int i = 0; i < amount; i++){
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
					list.add(contact);
			}
			return list;
		}
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0){
			return "";
		} else{
			return "test" + rnd.nextInt();
		}
	}
		
	public static String generateRandomNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(5)==0) {
			return "";
		} else {
			return "" + rnd.nextInt();
		}
	}

}
