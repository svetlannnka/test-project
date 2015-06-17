package com.example.fw;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

    public void createContact(Contact contact) {
        initContactCreation();
        fillContactForm(contact);
        confirmContactCreation();
    }

    private void initContactCreation() {
        manager.getAutoItHelper()
        .winWaitAndActivate("AddressBook Portable", "", 5000)
        .click("Add").winWaitAndActivate("Add Contact", "", 5000);
    }

    private void fillContactForm(Contact contact) {
        manager.getAutoItHelper()
		.send("TDBEdit12", contact.firstname)
		.send("TDBEdit11", contact.lastname);
    }

    private void confirmContactCreation() {
        manager.getAutoItHelper()
        .click("Save")
        .winWaitAndActivate("AddressBook Portable", "", 5000);
    }

    public Contact getFirstContact() {
	manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.focus("TListView1")
		.send("{DOWN}{SPACE}")
		.click("Edit")
		.winWaitAndActivate("Update Contact", "", 5000);
	Contact contact = new Contact()
		.setFirstname(manager.getAutoItHelper().getText("TDBEdit12"))
		.setLastname(manager.getAutoItHelper().getText("TDBEdit11"));
	manager.getAutoItHelper()
		.click("Cancel")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
	return contact;
    }

    public void deleteContact() {
        manager.getAutoItHelper()
        .winWaitAndActivate("AddressBook Portable", "", 5000)
        .click("TListView1")
        .send("","{DOWN}{SPACE}")
        .click("Delete");
        manager.getAutoItHelper()
        .winWaitAndActivate("Confirm", "Delete checked Contact(s)?", 5000)
        .click("Yes");      
    }
}
