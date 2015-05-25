package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if(! onMainPage()) {
			click(By.linkText("home"));
		}
	}
	public void groupsPage() {
		if (! onGroupsPage()) {
			click(By.linkText("groups"));
		}
	}

	public void gotoAddNewPage() {
		if(! onAddNewPage()) {
			click(By.linkText("add new"));
		}
	}

	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size() > 0;
	}

	private boolean onGroupsPage() {
		return driver.getCurrentUrl().contains("/group.php") && driver.findElements(By.name("new")).size() > 0;
	}
	
	private boolean onAddNewPage() {
		return driver.getCurrentUrl().contains("/edit.php") && driver.findElements(By.xpath("//input[@value='Enter']")).size() > 0;
	}
}
