# guruBank

Write a suite of three automated browser tests for demo banking app at: http://demo.guru99.com/v4/

## Exercise Description: 
* Use Selenium 2.0 (WebDriver)
* Tests must implement the page object pattern
* Write code in Java language.

## Create tests for: 
1. Verify new customer can be created.
2. Verify to create new account based on the customer just created above.
3. Verify deposit function work fine with the account just created.

## Installation
Platforms: MacOS 10.12.6
Using Eclipse to develop. You can download here: http://www.eclipse.org/downloads/

Download the Maven: http://maven.apache.org/download.cgi. for example apache-maven-3.5.4-bin.zip. Extracts it,
```sh
tar -xvf apache-maven-3.5.4-bin.tar.gz
export M2_HOME=/Users/admin/apache-maven-3.5.4
export PATH=$PATH:/Users/admin/Downloads/apache-maven-3.5.4/bin
$ mvn -version
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-18T01:33:14+07:00)
Maven home: /Users/admin/Downloads/apache-maven-3.5.4
Java version: 1.8.0_171, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre
Default locale: en_VN, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.6", arch: "x86_64", family: "mac"
```

## Sample Test

```js
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

```

## Running Test
Run by maven

```sh
$ mvn test
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------------< guru-bank:bank >---------------------------
[INFO] Building bank 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ bank ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ bank ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ bank ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ bank ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12:test (default-test) @ bank ---
[INFO] Surefire report directory: /Users/admin/Downloads/guru-bank/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------

Results :

Tests run: 0, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.128 s
[INFO] Finished at: 2018-06-24T19:16:13+07:00
[INFO] ------------------------------------------------------------------------

```
To execute by TestNG:
```sh
[RemoteTestNG] detected TestNG version 6.14.2
Starting ChromeDriver 2.38.552518 (183d19265345f54ce39cbb94cf81ba5f15905011) on port 13147
Only local connections are allowed.
PASSED: testHomePageAppearCorrect
PASSED: testCreateNewCustomer
PASSED: testCreateNewAccount
PASSED: testCreateNewDeposit

===============================================
    Default test
    Tests run: 4, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 4, Failures: 0, Skips: 0
===============================================
```
