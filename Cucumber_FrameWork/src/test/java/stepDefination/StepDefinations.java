package stepDefination;

import org.openqa.selenium.WebDriver;

import commonFunctions.FunctionLibrary;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
	WebDriver driver;
	@Given("Launch Browser")
	public void launch_Browser() throws Throwable {
	    driver = FunctionLibrary.startBrowser();
	}

	@When("Launch Application Url")
	public void launch_Application_Url() {
	    FunctionLibrary.openUrl();
	}

	@When("Wait for username with {string} and {string}")
	public void wait_for_username_with_and(String LType, String LValue) {
	    FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Enter username with {string} and {string} and {string}")
	public void enter_username_with_and_and(String LType, String LValue, String TestData) {
	   FunctionLibrary.typeAction(LType, LValue, TestData);
	}

	@When("Enter password with {string} and {string} and {string}")
	public void enter_password_with_and_and(String LType, String LValue, String TestData) {
		FunctionLibrary.typeAction(LType, LValue, TestData);
	}

	@When("Click Login button with {string} and {string}")
	public void click_Login_button_with_and(String LType, String LValue) {
	    FunctionLibrary.clickAction(LType, LValue);
	}

	@When("wait for Logout link with {string} and {string}")
	public void wait_for_Logout_link_with_and(String LType, String LValue) {
		FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@Then("verify page title with {string}")
	public void verify_page_title_with(String TestData) {
	    FunctionLibrary.validateTitle(TestData);
	}

	@When("Wait for supplier link with {string} and {string}")
	public void wait_for_supplier_link_with_and(String LType, String LValue) {
		FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Click Supplier link with {string} and {string}")
	public void click_Supplier_link_with_and(String LType, String LValue) {
		FunctionLibrary.clickAction(LType, LValue);
	}

	@When("Wait for Add Icon button with {string} and {string}")
	public void wait_for_Add_Icon_button_with_and(String LType, String LValue) {
		FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Click Add icon button with {string} and {string}")
	public void click_Add_icon_button_with_and(String LType, String LValue) {
		FunctionLibrary.clickAction(LType, LValue);
	}

	@When("wait for Supplier number with {string} and {string}")
	public void wait_for_Supplier_number_with_and(String LType, String LValue) {
		FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Capture Supplier number with {string} and {string}")
	public void capture_Supplier_number_with_and(String LType, String LValue) throws Throwable {
	    FunctionLibrary.captureSupplier(LType, LValue);
	}

	@When("Enter in {string} with {string} and {string}")
	public void enter_in_with_and(String TestData, String Ltype, String Lvalue) {
	   FunctionLibrary.typeAction(Ltype, Lvalue, TestData);
	}

	@When("Click Add button with {string} and {string}")
	public void click_Add_button_with_and(String LType, String LValue) {
		FunctionLibrary.clickAction(LType, LValue);
	}

	@When("Wait for confirm ok button with {string} and {string}")
	public void wait_for_confirm_ok_button_with_and(String LType, String LValue) {
		FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Click confirm ok button with {string} and {string}")
	public void click_confirm_ok_button_with_and(String LType, String LValue) {
		FunctionLibrary.clickAction(LType, LValue);
	}

	@When("Wait for alert ok button with {string} and {string}")
	public void wait_for_alert_ok_button_with_and(String LType, String LValue) {
		FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Click alert ok button with {string} and {string}")
	public void click_alert_ok_button_with_and(String LType, String LValue) {
		FunctionLibrary.clickAction(LType, LValue);
	}

	@Then("verify supplier number")
	public void verify_supplier_number() throws Throwable {
	    FunctionLibrary.supplierTable();
	}

	@When("Close app Browser")
	public void close_app_Browser() {
	    FunctionLibrary.closeBrowser();
	}
	@When("Wait for Customer link with {string} and {string}")
	public void wait_for_Customer_link_with_and(String LType, String LValue) {
	    FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Click Customer link with {string} and {string}")
	public void click_Customer_link_with_and(String LType, String LValue) {
	   FunctionLibrary.clickAction(LType, LValue);
	}

	@When("wait for Customer number with {string} and {string}")
	public void wait_for_Customer_number_with_and(String LType, String LValue) {
	    FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Capture Customer number with {string} and {string}")
	public void capture_Customer_number_with_and(String LType, String LValue) throws Throwable {
	    FunctionLibrary.captureCustomer(LType, LValue);
	}

	@Then("verify customer number")
	public void verify_customer_number() throws Throwable {
	   FunctionLibrary.customerTable();
	}
	@When("Wait for Stock items link with {string} and {string}")
	public void wait_for_Stock_items_link_with_and(String LType, String LValue) {
		FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("Click Stock items link with {string} and {string}")
	public void click_Stock_items_link_with_and(String LType, String LValue) {
		FunctionLibrary.clickAction(LType, LValue);
	}

	@When("wait for Category listbox with {string} and {string}")
	public void wait_for_Category_listbox_with_and(String LType, String LValue) {
		FunctionLibrary.waitForElement(LType, LValue, "20");
	}

	@When("capture in StockNumber with {string} and {string}")
	public void capture_in_StockNumber_with_and(String LType, String LValue) throws Throwable {
		FunctionLibrary.captureStock(LType, LValue);
	}
	@When("Select item in {string} with {string} and {string}")
	public void select_item_in_with_and(String TestData, String Ltype, String Lvalue) {
	    FunctionLibrary.dropDownAction(Ltype, Lvalue, TestData);
	}

}
