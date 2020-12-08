package com.testrunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Sprint2features"
		,glue={"com.orange_ssprint.hrm"}
		)
public class Test_runner_orange {

}
