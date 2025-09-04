package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(dryRun = false,features = {"FeatureFiles"},monochrome = true,
glue={"stepDefination"},
plugin = {"pretty", "html:target/html-reports/ErpReport.html",
		"json:target/json-reports/report.json"},tags = "@Customers not,@suppliers not,@StockItems") 
public class AppTest extends AbstractTestNGCucumberTests {

}
