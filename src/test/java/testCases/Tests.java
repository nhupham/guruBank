package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.Deposit;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccount;
import pages.NewCustomer;

public class Tests {

	WebDriver driver;
	LoginPage objLogin;
	HomePage objHomePage;
	NewCustomer objNewCustomer;
	NewAccount objNewAccount;
	Deposit objDeposit;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/");
	}

	/**
	 * This test case will login in http://demo.guru99.com/V4/ Verify login page
	 * title as guru99 bank Login to application Verify the home page using
	 * Dashboard message
	 */
	@Test(priority = 0)
	public void testHomePageAppearCorrect() {
		// Create Login Page object
		objLogin = new LoginPage(driver);
		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		AssertJUnit.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		// login to application
		objLogin.loginValidUser("mgr123", "mgr!23");
		// go the next page
		objHomePage = new HomePage(driver);
		// Verify home page
		AssertJUnit.assertTrue(objHomePage.getHomePageDashboardUserName().contains("Manger Id : mgr123"));
	}

	/**
	 * This test case will verify for create new customer successfully customer
	 * title as Add New Customer
	 */
	@Test(priority = 1)
	public void testCreateNewCustomer() {
		// Create new customer Page object
		objNewCustomer = new NewCustomer(driver).navigateToNewCustomer();
		// Verify add new customer page title
		String newCustomerPageTitle = objNewCustomer.getNewCustomerTitle();
		AssertJUnit.assertTrue(newCustomerPageTitle.contains("Add New Customer"));
		// create new customer
		long millis = System.currentTimeMillis();
		objNewCustomer.createNewCustomer("nhuptt", "03/08/1989", "120 Cong hoa", "HCMC", "test", "333000", "09827272",
				"nhuptt_" + Long.toString(millis) + "@gmail.com", "123456");
		// Verify register customer page
		AssertJUnit.assertTrue(
				objNewCustomer.registeredNewCustomer().toString().contains("Customer Registered Successfully!!!"));
	}

	/**
	 * This test case will verify for create new account customer title as Add new
	 * account form Verify create new account successfully
	 */
	@Test(priority = 2)
	public void testCreateNewAccount() {
		// Create new account Page object
		objNewAccount = new NewAccount(driver).navigateToNewAccount();
		// Verify add new Account page title
		String newAccountPageTitle = objNewAccount.getNewAccountTitle();
		AssertJUnit.assertTrue(newAccountPageTitle.contains("Add new account form"));
		// create new account
		objNewAccount.createNewAccount("546738");
		// Verify register account page
		AssertJUnit.assertTrue(objNewAccount.registeredNewAccount().contains("Account Generated Successfully!!!"));
	}

	/**
	 * This test case will verify for create new deposit customer title as Amount
	 * Deposit Form Verify create new deposit successfully
	 */
	@Test(priority = 3)
	public void testCreateNewDeposit() {
		// Create new deposit Page object
		objDeposit = new Deposit(driver).navigateToDeposit();
		// Verify add new deposit page title
		String newDepositPageTitle = objDeposit.getDepositTitle();
		AssertJUnit.assertTrue(newDepositPageTitle.contains("Amount Deposit Form"));
		// create new deposit
		objDeposit.createDeposit("1000", "testing");
		// Verify register deposit page
		AssertJUnit.assertTrue(objDeposit.registeredDeposit().contains("Transaction details of Deposit for Account"));
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
