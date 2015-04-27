package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeGroup(){
		app.getNavigationalHelper().openMainPage();
	    app.getNavigationalHelper().gotoGroupsPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().returnToGroupsPage();
	}
	
	@Test
	public void deleteGroups(){
		app.getNavigationalHelper().openMainPage();
	    app.getNavigationalHelper().gotoGroupsPage();
		app.getGroupHelper().deleteGroups(2);
		app.getGroupHelper().returnToGroupsPage();
	}
}
