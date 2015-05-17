package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.tests.TestBase;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;
	}
	
	private void rebuildCache() {
		cachedGroups = new SortedListOf<GroupData>();	
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), (title.length() - ")".length()));
			cachedGroups.add(new GroupData().withName(name));
		}	
	}

	public GroupHelper createGroup(GroupData group) {
			manager.navigateTo().groupsPage();
	    	initGroupCreation();
	    	fillGroupForm(group);
	    	submitGroupCreation();
	    	returnToGroupsPage();
	    	rebuildCache();
	    	return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
    	rebuildCache();
		return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
    	rebuildCache();
		return this;
	}
	
	public GroupHelper deleteGroups(int index) {
		// index is sum of groups to be deleted
		for (int i = 1; i <= index; i++){
			selectGroupByIndex(i);
		}
		submitGroupDeletion();
		return this;
	}

//-----------------------------------------------------------------------------------------------------------------------------------
	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.getName());
	    type(By.name("group_header"), group.getHeader());
	    type(By.name("group_footer"), group.getFooter());
	    return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+ (index+1) +"]"));
	}
	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}
	
}
