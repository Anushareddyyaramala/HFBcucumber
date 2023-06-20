package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features=".//Features//amazon.feature",
		glue={"com.StepDefinitions","hooks"},
		monochrome=true,
		plugin= {"pretty","html:reports/cucumber2.html"})

public class RunnerClass extends AbstractTestNGCucumberTests{

}
