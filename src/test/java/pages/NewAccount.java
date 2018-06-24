package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccount {
	WebDriver driver;
	public static String accID="";
	public NewAccount(WebDriver driver) {
		this.driver = driver;
	}

	public NewAccount navigateToNewAccount() {
		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		return new NewAccount(driver);
	}

	public String getNewAccountTitle() {
		return driver.findElement(By.xpath("//*[contains(text(),'Add new account form')]")).getText();
	}

	public NewAccount createNewAccount(String iniDeposit) {
		driver.findElement(By.name("cusid")).sendKeys(NewCustomer.cusID);
		driver.findElement(By.name("inideposit")).sendKeys(iniDeposit);
		driver.findElement(By.name("button2")).click();
		accID = driver.findElement(By.xpath("//*[@id=\"account\"]//tr[4]/td[2]")).getText().toString();
		return new NewAccount(driver);
	}

	public String registeredNewAccount() {
		return driver.findElement(By.xpath("//*[contains(text(),'Account Generated Successfully!!!')]")).getText();
	}
}
