package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomer {
	WebDriver driver;
	public static String cusID="";
	public NewCustomer(WebDriver driver) {
		this.driver = driver;
	}

	public NewCustomer navigateToNewCustomer() {
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		return new NewCustomer(driver); 
	}

	public String getNewCustomerTitle(){
		return	driver.findElement(By.xpath("//*[contains(text(),'Add New Customer')]")).getText();
	}

	public NewCustomer createNewCustomer(String name, String DOB, String address, String city, String state, String pin,
			String phone, String email, String password) {
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//*[@value='f']")).click();
		driver.findElement(By.name("dob")).sendKeys(DOB);
		driver.findElement(By.name("addr")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("pinno")).sendKeys(pin);
		driver.findElement(By.name("telephoneno")).sendKeys(phone);
		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@value='Submit']")).click();
		cusID = driver.findElement(By.xpath("//*[@id=\"customer\"]//tr[4]/td[2]")).getText().toString();
		return new NewCustomer(driver);
	}
	
	public String registeredNewCustomer() {
		return driver.findElement(By.xpath("//*[contains(text(),'Customer Registered Successfully!!!')]")).getText();
	}
}
