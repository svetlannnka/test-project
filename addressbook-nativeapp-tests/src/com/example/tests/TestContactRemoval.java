package com.example.tests;


import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactRemoval extends TestBase{
        
        @Test
        public void shouldCreateContactWithValidData(){
                app.getContactHelper().deleteContact();
        }

}