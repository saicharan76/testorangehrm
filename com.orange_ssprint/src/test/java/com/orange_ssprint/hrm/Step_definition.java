package com.orange_ssprint.hrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.Login_page;
import com.pages.pim_module;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step_definition {
	WebDriver driver=null;
	Login_page olg;
	pim_module opm;
	
	@Given("^User is on OrangeHRM login page$")
	public void user_is_on_OrangeHRM_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		olg = new Login_page(driver);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		System.out.println("User is on OrangeHRM login page");
	    
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
		olg.enterUsername(arg1);
		olg.enterPassword(arg2);
		Thread.sleep(1000);
		System.out.println("User enters {string} and {string}");	    
	   
	}

	@When("^User clicks on login$")
	public void user_clicks_on_login() throws Throwable {
		olg.clickLogin();
		System.out.println("User clicks on login");
	   
	}

	@Then("^User should be able to see alert message as Invalid Credentials$")
	public void user_should_be_able_to_see_alert_message_as_Invalid_Credentials() throws Throwable {
		String title=driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
		if(title.contentEquals("Invalid credentials")) System.out.println("******Title Matched");
		else System.out.println("*****Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		System.out.println("User should be able to see alert message as Invalid Credentials");
		driver.close();
	   
	}

	@When("^User leaves username blank$")
	public void user_leaves_username_blank() throws Throwable {
		olg.enterUsername("");
		olg.enterPassword("admin123");  
		System.out.println("User leaves username blank");
	    
	}

	@When("^Clicks the button$")
	public void clicks_the_button() throws Throwable {
		olg.clickLogin();
	    System.out.println("Clicks the button");
	   
	}

	@Then("^User should be able to see username alert message$")
	public void user_should_be_able_to_see_username_alert_message() throws Throwable {
		String title=driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
		if(title.contentEquals("Username cannot be empty")) System.out.println("******Title Matched");
		else System.out.println("*****Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		System.out.println("User should be able to see username alert message");
		driver.close();
	    
	}

	@When("^User leaves password blank$")
	public void user_leaves_password_blank() throws Throwable {
		olg.enterUsername("Admin");
		olg.enterPassword("");
	    System.out.println("User leaves password blank");

	    
	}

	@When("^Clicks the login button$")
	public void clicks_the_login_button() throws Throwable {
		olg.clickLogin();
	    System.out.println("Clicks the login button");

	    
	}

	@Then("^User should be able to see password alert message$")
	public void user_should_be_able_to_see_password_alert_message() throws Throwable {
		String title=driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
		if(title.contentEquals("Password cannot be empty")) System.out.println("******Title Matched");
		else System.out.println("*****Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		System.out.println("User should be able to see password alert message");
	    driver.close();

	   	}

	@When("^User leaves username and password fields blank$")
	public void user_leaves_username_and_password_fields_blank() throws Throwable {
		olg.enterUsername("");
		olg.enterPassword("");
	    System.out.println("User leaves username and password fields blank");

	    
	}

	@Then("^User should be able to see alert message$")
	public void user_should_be_able_to_see_alert_message() throws Throwable {
		String title=driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
		if(title.contentEquals("Username cannot be empty")) System.out.println("******Title Matched");
		else System.out.println("*****Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		System.out.println("User should be able to see alert message");
		driver.close();

	    
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		olg.enterUsername("Admin");
		olg.enterPassword("admin123");
	    System.out.println("User enters username and password");

	    
	}

	@Then("^User is navigated to Dashboard page$")
	public void user_is_navigated_to_Dashboard_page() throws Throwable {
		System.out.println("User is navigated to Dashboard page");
	    driver.close();

	   
	}

	@Given("^User is on Dashboard page$")
	public void user_is_on_Dashboard_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		olg = new Login_page(driver);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		olg.enterUsername("Admin");
		olg.enterPassword("admin123");
		olg.clickLogin();
		opm = new pim_module(driver);
		opm.checkDashboardIsDisplayed();


	    
	}

	@When("^User is navigated to PIM Module$")
	public void user_is_navigated_to_PIM_Module() throws Throwable {
		/*WebElement pim1 = pimPg.clickPimModule();
		Actions act = new Actions(driver);
		act.moveToElement(pim1).doubleClick().perform();*/
	opm.clickPimModule();

	    
	}

	@When("^User clicks on Optional feilds module in Configuration Module$")
	public void user_clicks_on_Optional_feilds_module_in_Configuration_Module() throws Throwable {
		/*WebElement configuration = pimPg.clickconfiguration();
		Actions act1 = new Actions(driver);
		act1.moveToElement(configuration).doubleClick().build().perform();
		WebElement optional = pimPg.clickoptional();
		Actions act2 = new Actions(driver);
		act2.moveToElement(optional).doubleClick().build().perform();*/
		opm.clickconfiguration();
		opm.clickoptional();

	   
	}

	@Then("^User can view the Configure PIM Module$")
	public void user_can_view_the_Configure_PIM_Module() throws Throwable {
		/*String title=driver.findElement(By.xpath("//*[@id=content']/div/div[1]/h1")).getText();
		if(title.contentEquals("Configure PIM")) System.out.println("Title Matched");
		else System.out.println("Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		System.out.println("User can view the Configure PIM Module");
		//driver.close();*/
		System.out.println("User can view the Configure PIM Module");
		driver.close();

	   
	}

	@When("^User clicks on Custom feilds module in Configuration Module$")
	public void user_clicks_on_Custom_feilds_module_in_Configuration_Module() throws Throwable {
		/*WebElement configuration = pimPg.clickconfiguration();
		Actions act1 = new Actions(driver);
		act1.moveToElement(configuration).doubleClick().perform();*/
		opm.clickconfiguration();
		opm.clickcustom();

	    
	}

	@Then("^User can view the Defined Custom Fields$")
	public void user_can_view_the_Defined_Custom_Fields() throws Throwable {
		String title=driver.findElement(By.xpath("//*[@id='customFieldListPane']/div[1]/h1")).getText();
		if(title.contentEquals("Defined Custom Fields")) System.out.println("Title Matched");
		else System.out.println("Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		System.out.println("User can view the Defined Custom Fields");
		driver.close();

	    
	}

	@Then("^User can view details of all employees$")
	public void user_can_view_details_of_all_employees() throws Throwable {
		System.out.println("User can view details of all employees");
		Thread.sleep(1000);
		driver.close();

	    
	}

	@Then("^User clicks Add Employee in PIM Module$")
	public void user_clicks_Add_Employee_in_PIM_Module() throws Throwable {
		opm.clickaddEmployee();

	    
	}

	@Then("^User should be able to add details of new employee$")
	public void user_should_be_able_to_add_details_of_new_employee() throws Throwable {
		opm.enterfirstname("sai");
		opm.entermiddlename("charan");
		opm.enterlastname("atti");
		opm.clickCheckBox();
		opm.enterUserName("saicharan");
		opm.enterPassWord("9490996893");
		opm.enterConfirmPassword("9490996893");
		opm.clickSave();
		Thread.sleep(1000);
		driver.close();

	    
	}

	@Then("^User clicks on Reports in PIM Module$")
	public void user_clicks_on_Reports_in_PIM_Module() throws Throwable {
		opm.clickReports();
		opm.enterReportsName("PIM Sample Report");
		Thread.sleep(3000);

	   
	}

	@Then("^User searches for Employee reports$")
	public void user_searches_for_Employee_reports() throws Throwable {
		opm.clickSearch();
		Thread.sleep(2000);
		driver.close();

	    
	}

	@When("^User clicks on My Info Module$")
	public void user_clicks_on_My_Info_Module() throws Throwable {
		opm.clickMyInfo();

	   
	}

	@Then("^User Should be able view his personal details$")
	public void user_Should_be_able_view_his_personal_details() throws Throwable {
		System.out.println("User Should be able view his personal details");
		driver.close();

	    
	}

	@Given("^User is on OrangeHRM login page to enter data of employee$")
	public void user_is_on_OrangeHRM_login_page_to_enter_data_of_employee() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		olg = new Login_page(driver);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		System.out.println("User is on OrangeHRM login page");

	   
	}

	@When("^User enters username and password of the employee$")
	public void user_enters_username_and_password_of_the_employee() throws Throwable {
		olg.enterUsername("saicharan");
		olg.enterPassword("9490996893");
	   
	}

	@Then("^User clicks on login and is navigated to Dashboard page$")
	public void user_clicks_on_login_and_is_navigated_to_Dashboard_page() throws Throwable {
		olg.clickLogin();

	    
	}

	@Then("^User clicks on My Info Module and can view his personal details only$")
	public void user_clicks_on_My_Info_Module_and_can_view_his_personal_details_only() throws Throwable {
		opm = new  pim_module(driver);
		opm.clickMyInfo();
		Thread.sleep(1000);
		driver.close();

	    
	}

	@When("^User should clicks on Logout in Welcome Menu$")
	public void user_should_clicks_on_Logout_in_Welcome_Menu() throws Throwable {
		opm.clickWelcomeMenu();
		opm.clickLogout();

	    
	}

	@Then("^User should be able to see OrangeHRM Login Page$")
	public void user_should_be_able_to_see_OrangeHRM_Login_Page() throws Throwable {
		System.out.println("User should be able to see OrangeHRM Login Page");
		driver.close();


	    
	}
}
