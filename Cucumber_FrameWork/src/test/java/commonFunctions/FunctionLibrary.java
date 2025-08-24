package commonFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class FunctionLibrary {
	public static WebDriver driver;
	public static Properties conpro;
	//method for launching browser
	public static WebDriver startBrowser()throws Throwable
	{
		conpro =  new Properties();
		conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			try {
				throw new IllegalArgumentException("Browser value is Not matching");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}
		return driver;
	}
	//method for launching url
	public static void openUrl()
	{
		driver.get(conpro.getProperty("Url"));
	}
	//method for waiting for webelements
	public static void waitForElement(String LocatorName,String Locatorvalue,String TestData)
	{
		WebDriverWait myywait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(TestData)));
		if(LocatorName.equalsIgnoreCase("xpath"))
		{
			//wait until element is visible
			myywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locatorvalue)));
		}
		if(LocatorName.equalsIgnoreCase("name"))
		{
			//wait until element is visible
			myywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Locatorvalue)));
		}
		if(LocatorName.equalsIgnoreCase("id"))
		{
			//wait until element is visible
			myywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locatorvalue)));
		}
	}
	//method for any textbox
	public static void typeAction(String LocatorName,String LocatorValue,String TestData)
	{
		if(LocatorName.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(LocatorValue)).clear();
			driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);
		}
		if(LocatorName.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(LocatorValue)).clear();
			driver.findElement(By.id(LocatorValue)).sendKeys(TestData);
		}
		if(LocatorName.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(LocatorValue)).clear();
			driver.findElement(By.name(LocatorValue)).sendKeys(TestData);
		}
	}
	//method for webelments like buttons,checkboxes,radio buttons,links and image
	public static void clickAction(String LocatorName,String Locatorvalue)
	{
		if(LocatorName.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(Locatorvalue)).click();
		}
		if(LocatorName.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(Locatorvalue)).click();
		}
		if(LocatorName.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(Locatorvalue)).sendKeys(Keys.ENTER);
		}
	}
	//method for validating any page title
	public static void validateTitle(String Expected_Title)
	{
		String Actual_title = driver.getTitle();
		try {
			Assert.assertEquals(Actual_title, Expected_Title,"Title is Not Matching");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}
	//method for closing browser
	public static void closeBrowser()
	{
		driver.quit();
	}
	//method for any drop down or listbox
	public static void dropDownAction(String LocatorName,String Locatorvalue,String TestData)
	{
		if(LocatorName.equalsIgnoreCase("xpath"))
		{
			int value = Integer.parseInt(TestData);
			Select element = new Select(driver.findElement(By.xpath(Locatorvalue)));
			element.selectByIndex(value);

		}
		if(LocatorName.equalsIgnoreCase("name"))
		{
			int value = Integer.parseInt(TestData);
			Select element = new Select(driver.findElement(By.name(Locatorvalue)));
			element.selectByIndex(value);
		}
		if(LocatorName.equalsIgnoreCase("id"))
		{
			int value = Integer.parseInt(TestData);
			Select element = new Select(driver.findElement(By.id(Locatorvalue)));
			element.selectByIndex(value);
		}
	}
	//method to capture stock number into notepad
	public static void captureStock(String Locatorname,String LocatorValue)throws Throwable
	{
		String stokNum ="";
		if(Locatorname.equalsIgnoreCase("xpath"))
		{
			stokNum = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
		}
		if(Locatorname.equalsIgnoreCase("id"))
		{
			stokNum = driver.findElement(By.id(LocatorValue)).getAttribute("value");
		}
		if(Locatorname.equalsIgnoreCase("name"))
		{
			stokNum = driver.findElement(By.name(LocatorValue)).getAttribute("value");
		}
		//create not pad under CaptureData folder
		FileWriter fw = new FileWriter("./CaptureData/stocknumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(stokNum);
		bw.flush();
		bw.close();

	}
	//method to verify stock number in table
	public static void stockTable()throws Throwable
	{
		//read stock number from above notepad
		FileReader fr = new FileReader("./CaptureData/stocknumber.txt");
		BufferedReader br = new BufferedReader(fr);
		String Exp_Data = br.readLine();
		//if search textbox already displayed dont click search panel
		if(!driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).isDisplayed())
			//click search panel if not searchtextbox not displayed
			driver.findElement(By.xpath(conpro.getProperty("Objsearchpanel"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).clear();
		driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).sendKeys(Exp_Data);
		driver.findElement(By.xpath(conpro.getProperty("ObjsearchButton"))).click();
		Thread.sleep(4000);
		//capture stock number from stock table
		String Act_data = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[8]/div/span/span")).getText();
		Reporter.log(Act_data+"    "+Exp_Data,true);
		try {
			Assert.assertEquals(Act_data, Exp_Data,"Stock number Not found in table");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

	}
	//method for capture supplier number into notepad
	public static void captureSupplier(String LocatorName,String LocatorValue)throws Throwable
	{
		String suppliernum ="";
		if(LocatorName.equalsIgnoreCase("xpath"))
		{
			suppliernum = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");

		}
		if(LocatorName.equalsIgnoreCase("name"))
		{
			suppliernum = driver.findElement(By.name(LocatorValue)).getAttribute("value");

		}
		if(LocatorName.equalsIgnoreCase("id"))
		{
			suppliernum = driver.findElement(By.id(LocatorValue)).getAttribute("value");

		}
		FileWriter fw = new FileWriter("./CaptureData/suppliernumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(suppliernum);
		bw.flush();
		bw.close();

	}
	//method for verify supplier number in supplier table
	public static void supplierTable()throws Throwable
	{
		FileReader fr = new FileReader("./CaptureData/suppliernumber.txt");
		BufferedReader br = new BufferedReader(fr);
		String Exp_data =br.readLine();
		if(!driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).isDisplayed())
			driver.findElement(By.xpath(conpro.getProperty("Objsearchpanel"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).clear();
		driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).sendKeys(Exp_data);
		driver.findElement(By.xpath(conpro.getProperty("ObjsearchButton"))).click();
		Thread.sleep(2000);
		String Act_Data = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
		Reporter.log(Act_Data+"    "+Exp_data,true);
		try {
			Assert.assertEquals(Act_Data, Exp_data, "Supplier Number Not Found in table");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}
	//method for capture customer number into notepad
	public static void captureCustomer(String LocatorName,String LocatorValue)throws Throwable
	{
		String customernum ="";
		if(LocatorName.equalsIgnoreCase("xpath"))
		{
			customernum = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");

		}
		if(LocatorName.equalsIgnoreCase("name"))
		{
			customernum = driver.findElement(By.name(LocatorValue)).getAttribute("value");

		}
		if(LocatorName.equalsIgnoreCase("id"))
		{
			customernum = driver.findElement(By.id(LocatorValue)).getAttribute("value");

		}
		FileWriter fw = new FileWriter("./CaptureData/customernumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(customernum);
		bw.flush();
		bw.close();

	}
	//method for verify customer number in supplier table
	public static void customerTable()throws Throwable
	{
		FileReader fr = new FileReader("./CaptureData/customernumber.txt");
		BufferedReader br = new BufferedReader(fr);
		String Exp_data =br.readLine();
		if(!driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).isDisplayed())
			driver.findElement(By.xpath(conpro.getProperty("Objsearchpanel"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).clear();
		driver.findElement(By.xpath(conpro.getProperty("ObjSearchtextbox"))).sendKeys(Exp_data);
		driver.findElement(By.xpath(conpro.getProperty("ObjsearchButton"))).click();
		Thread.sleep(2000);
		String Act_Data = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")).getText();
		Reporter.log(Act_Data+"    "+Exp_data,true);
		try {
			Assert.assertEquals(Act_Data, Exp_data, "customer Number Not Found in table");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

	}
	//method for date format
	public static String generateDate()
	{
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYY_MM_dd");
		return df.format(date);
	}
	
	
}




















