package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{


  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	app.getNavigationalHelper().openMainPage();
    app.getNavigationalHelper().gotoGroupsPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();

    //compare states
    //assertEquals(newList.size(), oldList.size()+1);  size comparison
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
