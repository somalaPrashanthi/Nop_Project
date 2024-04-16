package NOPP;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Nopproject {
	public class NopProject {
		WebDriver driver;
		ExtentReports report;
		ExtentTest test;
		WebDriverWait wait;
		
		@BeforeTest
		public void startup() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.nopcommerce.com/register");
			report= new ExtentReports("C:\\Users\\Prashanthi\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\Nop_Project\\src\\test\\resources\\Reports\\report12.html");
			test=report.startTest("Nopcommerce");
			wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
			
		}
		@Test
		public void Setup() throws InterruptedException {
			///Step 1 - Register by entering necessary credentials
			WebElement radio = driver.findElement(By.id("gender-female"));
			radio.click();
			System.out.println(radio.isSelected());
			driver.findElement(By.id("FirstName")).sendKeys("Prashanthi");
			driver.findElement(By.id("LastName")).sendKeys("Somala");
			WebElement dropdown = driver.findElement(By.name("DateOfBirthDay"));
			Select s = new Select(dropdown);
			s.selectByValue("9");
			WebElement dropdown1 = driver.findElement(By.name("DateOfBirthMonth"));
			Select s1 = new Select(dropdown1);
			s1.selectByVisibleText("November");
			WebElement dropdown2 = driver.findElement(By.name("DateOfBirthYear"));
			Select s2 = new Select(dropdown2);
			s2.selectByValue("1992");
			driver.findElement(By.id("Email")).sendKeys("Prashanthi@gmail.com");
			driver.findElement(By.id("Company")).sendKeys("Moolya ED");
			driver.findElement(By.id("Password")).sendKeys("prash@123");
			driver.findElement(By.id("ConfirmPassword")).sendKeys("prash@123");
			WebElement Registerbutton = driver.findElement(By.xpath("//button[text()='Register']"));
			Registerbutton.click();
			test.log(LogStatus.PASS,"Registeration form is completed successfully");
	
		
		//Step 2 - Click on books
			WebElement Books = driver.findElement(By.partialLinkText("Books"));
			Books.click();
			test.log(LogStatus.PASS,"Books button is clicked successfully");
		
		 //Step 3 - Add below item to the cart - “Add to cart
			 driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
			test.log(LogStatus.PASS,"Item is added successfully to add to cart");
			
		//Step 4 - Click on Shopping cart
			WebElement shoppingcart = driver.findElement(By.xpath("(//a[@href='/cart'])[1]"));
			shoppingcart.click();
			test.log(LogStatus.PASS,"Clicked on shopping cart successfully");
			
		//Step 5 - Click on checkbox agreeing terms and conditions and click on checkout
			WebElement checkbox = driver.findElement(By.id("termsofservice"));
			checkbox.click();
			WebElement Checkout = driver.findElement(By.xpath("(//button[text()=' Checkout '])[1]"));
			Checkout.click();
			test.log(LogStatus.PASS,"Successfully clicked on checkbox and checkout");
			
		 //Step 6 - Check out as Guest
			WebElement Checkoutasguest = driver.findElement(By.xpath("(//button[text()='Checkout as Guest'])"));
			Checkoutasguest.click();
			test.log(LogStatus.PASS,"Check out as Guest is successfully Done");
			
		 //Step 7 - Enter required Billing details
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_FirstName")));
			firstNameInput.sendKeys("Prashanthi");
			driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Somala");
			driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Prashanthi@gmail.com");
			driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Moolya ED");
			WebElement dropdown3 = driver.findElement(By.name("BillingNewAddress.CountryId"));
			Select s3 = new Select(dropdown3);
			s3.selectByVisibleText("India");
			driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Bangalore");
			driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("BTM Layout");
			driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("Second Stage");
			driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("560095");
			driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9632587456");
			driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("9874563214");
			WebElement Continue = driver.findElement(By.name("save"));
			Continue.click();
			test.log(LogStatus.PASS,"Entering requied Billing details is successfully completed");
		
			//Step 8 - Continue with Shipping method
			WebElement Continue1 = driver.findElement(By.xpath("(//button[text()='Continue'])[3]"));
			wait.until(ExpectedConditions.elementToBeClickable(Continue1));
			Continue1.click();
			test.log(LogStatus.PASS,"Continue with Shipping method is completed successfully");
			
			//Step 9 - Choose Check/Money Order and continue
			WebElement Continue2 = driver.findElement(By.xpath("(//button[text()='Continue'])[4]"));
			wait.until(ExpectedConditions.elementToBeClickable(Continue2));
			Continue2.click();
			test.log(LogStatus.PASS,"Choose Check/Money Order and continue is completed successfully");
			
			//Step 10 - Continue with below address
			WebElement Continue3 = driver.findElement(By.xpath("(//button[text()='Continue'])[5]"));
			wait.until(ExpectedConditions.elementToBeClickable(Continue3));
			Continue3.click();
			test.log(LogStatus.PASS,"Continue with below address is completed successfully");
			
			//Step 11 - Ensure to confirm the order
			WebElement confirmtheorder = driver.findElement(By.xpath("(//button[text()='Confirm'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(confirmtheorder));
			confirmtheorder.click();
			test.log(LogStatus.PASS,"Confirm the order is successfully done");
			
			//Step 12 - Display the message “Your order has been successfully processed” message in your console

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement successMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Your order has been successfully processed!']")));
			System.out.println(successMessage.getText());
			test.log(LogStatus.PASS,"Messge is displayed successfully");
		}
			@AfterTest
			public void endup(){
			driver.quit();
			report.endTest(test);
			report.flush();
		}
	}
}