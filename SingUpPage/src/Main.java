import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Farhan\\Desktop\\selenium\\SingUpPage\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://signup.skuvault.com/");

		// maximize the browser window
		driver.manage().window().maximize();

		// Get URL of webpage
		String url = driver.getCurrentUrl();
		System.out.println(url);

		// Get Title of Web Page
		String title = driver.getTitle();
		if (title.contains("SkuVault"))
			System.out.println("SKuVault is present in title Verified");

		// Check Visibility of web element SKuVault
		if (driver.findElement(By.xpath("//img[@title='SkuVault']")).isDisplayed()) {
			System.out.println("   SKuVault   is  Display ");
		} else {
			System.out.println("SKuVault   is  not Display  ");
		}

		// Check if Text is present Signup for New Account
		if (driver.findElements(By.xpath("//h2[contains(text(),'Signup for a New Account')]")).size() != 0) {
			System.out.println("Signup for a New Account is Present");
		} else {
			System.out.println("Signup for a New Account  is Absent");
		}

		// Name
		driver.findElement(By.name("FirstName")).sendKeys("Farhan ");

		// Last Name
		driver.findElement(By.name("LastName")).sendKeys("Khan");

		// Title

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[2]/div[1]/input[1]"))
				.sendKeys("Automation ");

		// Email address and Confirm email
		driver.findElement(By.name("UserEmail")).sendKeys("abc@lycos.com");
		driver.findElement(By.name("ConfirmEmail")).sendKeys("abc@lycos.com");

		// User password in wrong format
		driver.findElement(By.name("UserPassword")).sendKeys("Ali Ahmed");
		WebElement redTag = driver.findElement(By.xpath("//span[@class='label-text-red wrap']"));
		String actualResult = redTag.getText();
		String expectedResult = "User Password requires 1 number!";
		if (actualResult.equals(expectedResult)) {
			System.out.println("Password is not compatible with the Rules Please enter correct format ");
		}

		// User password and confirm password in a correct format .
		driver.findElement(By.name("UserPassword")).clear();
		driver.findElement(By.name("UserPassword")).sendKeys("Farhan123");

		driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("Farhan123");

		// Company Name
		driver.findElement(By.name("CompanyName")).sendKeys("Google");

		// ----------------------------------------------------
		// Starting user count

		// -----------------------------------

		// DBA
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/fieldset[2]/div[2]/div[1]/div[1]/input[1]"))
				.sendKeys("J Farhan Khan ");

		// Billing Cycle
		WebElement billingCycle = driver.findElement(By.xpath("//fieldset//div[2]//div[2]//div[1]//select[1]"));
		Select sel = new Select(billingCycle);
		sel.selectByIndex(1);

		// Company Contact Phone
		driver.findElement(By.name("CompanyPhone")).sendKeys("6619581");

		// Launch Package
		WebElement launch = driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/fieldset[2]/div[3]/div[2]/div[1]/select[1]"));
		Select sel2 = new Select(launch);
		sel2.selectByIndex(4);

		// Company website

		driver.findElement(By.xpath("//input[@name='CompanyUrl']")).sendKeys("www.amazon.com");

		// Click on check box

		driver.findElement(By.xpath("//label[@class='checkbox-inline small-text']//input[@type='checkbox']")).click();

		// Click on Link Navigate to next page then come back by using windows handles
		driver.findElement(By.linkText("Click here to view our pricing information")).click();
		String mainWindow = driver.getWindowHandle();
		// It returns no. of windows opened by WebDriver and will return Set of Strings
		Set<String> set = driver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// Compare whether the main windows is not equal to child window. If not equal,
			// we will close.
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(mainWindow).getTitle());
			}
			
			
			
			 // Credit Card Accepted
			 
			
			
			
			//Street Address
			
			driver.findElement(By.xpath("//input[@name='BillingStreet']")).sendKeys("Hill Side Avenue");
			
			//City
		
			driver.findElement(By.xpath("//input[@name='BillingCity']")).sendKeys("Tel Aviv ");
			
			
			//State
			driver.findElement(By.xpath("  //input[@name='BillingState']")).sendKeys("NYC ");
			
			// Post Code
			
			
			driver.findElement(By.xpath(" //input[@name='BillingPostal'] ")).sendKeys("74800");
			
			
			// Card No
			
			driver.findElement(By.xpath("//input[@name='CardNumber']")).sendKeys("254789999");
			
			// Card Code
			driver.findElement(By.xpath("//input[@name='CardCode']")).sendKeys("99999999");
			
			
			// Expiration Month
			
			
			WebElement exp = driver.findElement(
					By.xpath("//select[@name='CardMonth']"));
			Select sel5 = new Select(exp);
			sel5.selectByIndex(4);

			
			// Expiration Year
			
			WebElement year = driver.findElement(
					By.xpath(" //select[@name='CardYear'] "));
			Select sel7 = new Select(year);
			sel7.selectByIndex(4);

						
			// starting user count

			

			
			// Country
			WebElement country = driver.findElement(By.xpath("//select[@name='BillingCountry']"));
			Select sel1 = new Select(country);
			sel1.selectByIndex(1);

		}
	}
}
