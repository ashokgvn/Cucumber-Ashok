@tag
Feature: 
As as Admin user i want to test supplier and customer modules
@suppliers
Scenario Outline:
Validate supplier creation with multiple data
Given Launch Browser
When Launch Application Url
And Wait for username with "id" and "username"
And Enter username with "id" and "username" and "admin"
And Enter password with "name" and "password" and "master"
And Click Login button with "xpath" and "//button[@id='btnsubmit']"
And wait for Logout link with "xpath" and "(//a[starts-with(text(),' Logout')])[2]"
Then verify page title with "Dashboard « Stock Accounting"
When Wait for supplier link with "xpath" and "(//*[text()='Suppliers'])[2]"
When Click Supplier link with "xpath" and "(//*[text()='Suppliers'])[2]"
When Wait for Add Icon button with "xpath" and "(//span[@data-caption='Add'])[1]"
When Click Add icon button with "xpath" and "(//span[@data-caption='Add'])[1]"
When wait for Supplier number with "name" and "x_Supplier_Number"
When Capture Supplier number with "name" and "x_Supplier_Number"
When Enter in "<SupplierName>" with "id" and "x_Supplier_Name" 
When Enter in "<address>" with "xpath" and "//*[@id='x_Address']" 
When Enter in "<city>" with "xpath" and "//*[@id='x_City']" 
When Enter in "<country>" with "xpath" and "//*[@id='x_Country']" 
When Enter in "<cperson>" with "xpath" and "//*[@id='x_Contact_Person']" 
When Enter in "<pnumber>" with "xpath" and "//*[@id='x_Phone_Number']" 
When Enter in "<mail>" with "xpath" and "//*[@id='x__Email']" 
When Enter in "<mnumber>" with "xpath" and "//*[@id='x_Mobile_Number']" 
When Enter in "<note>" with "xpath" and "//*[@id='x_Notes']" 
When Click Add button with "id" and "btnAction"
When Wait for confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
When Click confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
When Wait for alert ok button with "xpath" and "(//button[contains(text(),'OK')])[6]"
When Click alert ok button with "xpath" and "(//button[contains(text(),'OK')])[6]"
Then verify supplier number
When Close app Browser
Examples:
|SupplierName|address|city|country|cperson|pnumber|mail|mnumber|note|
|First supplier|Srnagar|Hydearabd|India|ranga|4569874569|test@gmail.com|9876543212|iam new supplier|
|second supplier|Srnagar|Hydearabd|India|ranga|4569874569|test@gmail.com|9876543212|iam new supplier|
@Customers
Scenario Outline:
Validate Customer Add with multiple data
Given Launch Browser
When Launch Application Url
And Wait for username with "id" and "username"
And Enter username with "id" and "username" and "admin"
And Enter password with "name" and "password" and "master"
And Click Login button with "xpath" and "//button[@id='btnsubmit']"
And wait for Logout link with "xpath" and "(//a[starts-with(text(),' Logout')])[2]"
Then verify page title with "Dashboard « Stock Accounting"
When Wait for Customer link with "xpath" and "(//*[text()='Customers'])[2]"
When Click Customer link with "xpath" and "(//*[text()='Customers'])[2]"
When Wait for Add Icon button with "xpath" and "(//span[@data-caption='Add'])[1]"
When Click Add icon button with "xpath" and "(//span[@data-caption='Add'])[1]"
When wait for Customer number with "name" and "x_Customer_Number"
When Capture Customer number with "name" and "x_Customer_Number"
When Enter in "<CustomerName>" with "id" and "x_Customer_Name" 
When Enter in "<address>" with "xpath" and "//*[@id='x_Address']" 
When Enter in "<city>" with "xpath" and "//*[@id='x_City']" 
When Enter in "<country>" with "xpath" and "//*[@id='x_Country']" 
When Enter in "<cperson>" with "xpath" and "//*[@id='x_Contact_Person']" 
When Enter in "<pnumber>" with "xpath" and "//*[@id='x_Phone_Number']" 
When Enter in "<mail>" with "xpath" and "//*[@id='x__Email']" 
When Enter in "<mnumber>" with "xpath" and "//*[@id='x_Mobile_Number']" 
When Enter in "<note>" with "xpath" and "//*[@id='x_Notes']" 
When Click Add button with "id" and "btnAction"
When Wait for confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
When Click confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
When Wait for alert ok button with "xpath" and "(//button[contains(text(),'OK')])[6]"
When Click alert ok button with "xpath" and "(//button[contains(text(),'OK')])[6]"
Then verify customer number
When Close app Browser
Examples:
|CustomerName|address|city|country|cperson|pnumber|mail|mnumber|note|
|First Customer|Srnagar|Hydearabd|India|ranga|4569874569|test@gmail.com|9876543212|iam new customer|
|second Customer|Srnagar|Hydearabd|India|ranga|4569874569|test@gmail.com|9876543212|iam new customer|



