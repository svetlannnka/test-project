package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;

public class TestBase {
    protected Logger log = Logger.getLogger("TEST");
    
    protected ApplicationManager app;

    @BeforeTest
	public void setUp() throws Exception {
	    String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = ApplicationManager.getInstance(properties);
		app = new ApplicationManager();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance(null).stop();
	}
}
