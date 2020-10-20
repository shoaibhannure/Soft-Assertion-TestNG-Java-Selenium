 package com.shoaib.assertions;
 
 /*
  * 
  * @Author:- Shoaib Hannure
  * 
  */

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionExample { 
//Hard Assertion: Hard Validation: if a hard assertion is getting failed--->immediately test case will be marked as failed and test case will be terminated
//Soft Assertion: Soft Validation: if a soft Assertion is getting failed-->test case will be marked as passed as well as next lines will be executed
//assert(): to mark test case as failed, if any assertion is getting failed
	
	SoftAssert softassert = new SoftAssert();
	@Test
	public void test1(){
		System.out.println("Open Browser");
		Assert.assertEquals(true, true);
		//Below Statement will not get executed if Assertion Fails
		//This is known as Hard Assertion
		
		System.out.println("Enter USername");
		System.out.println("Enter Password");
		System.out.println("Clcick on Sign In button");
		
		Assert.assertEquals(true, true);
		
		System.out.println("Validate Home Page");
		softassert.assertEquals(true, false, "home title is missing");//soft Assertion
		
		//If we use Soft Assertion then even if condition is failing it will execute below statements
		System.out.println("Go to deals Page");
		System.out.println("Create a deal");
		softassert.assertEquals(true, false, "not able to create a deal");//soft Assertion
		
		System.out.println("Go to Contacts Page");
		System.out.println("Create a Contact");
		softassert.assertEquals(true, false, "not able to create a contact");//soft Assertion
		
		softassert.assertAll();
	}
	
	@Test
	public void test2(){
		SoftAssert softAssert2 = new SoftAssert();
		System.out.println("LogOut");
		softAssert2.assertEquals(true, false);
		softAssert2.assertAll(); //If we dont write it then Test Case will be marked as Pass
	}
	
	@AfterClass
	public void tearDown(){
		softassert.assertAll();
	}

}
