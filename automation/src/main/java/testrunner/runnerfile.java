package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.*;

@CucumberOptions(
		features = "/automation/src/main/resources/Feature/firt.feature"
		,glue = {"Stepdefenation"}
		,tags = {"@googletest"}
		,monochrome = true ,dryRun = false
		)
public class runnerfile {

}
