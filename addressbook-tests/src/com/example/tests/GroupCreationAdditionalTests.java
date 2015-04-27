package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationAdditionalTests extends TestBase {

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationalHelper().openMainPage();
    app.getNavigationalHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "Header", "Footer"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.getNavigationalHelper().openMainPage();
    app.getNavigationalHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("New Group", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    }
}
