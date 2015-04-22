package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationAdditionalTests extends TestBase {

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "Header", "Footer"));
    submitGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("New Group", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
    }
}
