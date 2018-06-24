package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Deposit {
	WebDriver driver;
	public Deposit(WebDriver driver) {
		this.driver = driver;
	}

	public Deposit navigateToDeposit() {
		driver.findElement(By.xpath("//a[contains(text(),'Deposit')]")).click();
		return new Deposit(driver);
	}

	public String getDepositTitle() {
		return driver.findElement(By.xpath("//*[contains(text(),'Amount Deposit Form')]")).getText();
	}

	public Deposit createDeposit(String ammount, String desc) {
		driver.findElement(By.name("accountno")).sendKeys(NewAccount.accID);
		driver.findElement(By.name("ammount")).sendKeys(ammount);
		driver.findElement(By.name("desc")).sendKeys(desc);
		driver.findElement(By.name("AccSubmit")).click();
		return new Deposit(driver);
	}

	public String registeredDeposit() {
		return driver.findElement(By.xpath("//*[contains(text(),'Transaction details of Deposit for Account')]")).getText();
	}
}
