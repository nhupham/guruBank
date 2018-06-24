package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
    this.driver = driver;
//    if(!selenium.getTitle().equals("Guru99 Bank Manager HomePage")) {
//            throw new IllegalStateException("This is not sign in page, current page is: "
//                            +selenium.getTitle());
//    }
  }

  //Get the title of Login Page
	public String getLoginTitle(){
		return	driver.findElement(By.className("barone")).getText();
	}
	/**
	 * Login as valid user
	 *
	 * @param userName
	 * @param password
	 * @return HomePage object
	 */
	public LoginPage loginValidUser(String userName, String password) {
		driver.findElement(By.name("uid")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();

		return new LoginPage(driver);
	}
}
