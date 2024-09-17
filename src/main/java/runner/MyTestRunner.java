package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/FeaturesFiles/",
		glue={"stepdefinitions","hooks"},
		publish=true,
		monochrome = true,
		plugin={"pretty","html:target/CucumberReports/reports.html"},
	    tags="@login or @register or @search"
		)
public class MyTestRunner extends AbstractTestNGCucumberTests {

}
