package testrunner;

import org.testng.annotations.Test;

import Stepdefenation.Login;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/automation/src/main/resources/Feature/first.feature"
		,glue = {"Stepdefenation"}
		,tags = {"@googletest"}
		,monochrome = true ,dryRun = false
		)

public class TestRunner {
	
  
	  
  }
  


