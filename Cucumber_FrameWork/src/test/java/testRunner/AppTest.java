package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,features = {"FeatureFiles"},monochrome = true,glue={"stepDefination"}, 
plugin = {"pretty", "html:target/html-reports/ErpReport.html",
		"json:target/json-reports/report.json",
		"junit:target/xml-reports/report.xml"},tags = "@Customers,@suppliers")
public class AppTest extends AbstractTestNGCucumberTests {

}
