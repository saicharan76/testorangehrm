package com.testrunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="Sprint2features"
		,glue={"com.orange_ssprint.hrm"}
		,plugin={"json:target/cucumber.json"}
		,tags={"@unsuccesful_login1,@unsuccesful_login2,@unsuccesful_login3,@unsuccesful_login4,@succesful_login"
				+ ",@Configuration_field,@Custom_fields,@Employee_details,@Add_Employee,@Reports,@Myinfo,@Employee_login,@Logout"}
				 
				
		)
public class TestRunnerwithOrange extends AbstractTestNGCucumberTests {

}
