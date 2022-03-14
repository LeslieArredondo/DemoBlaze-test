package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class class1 {

	public String baseUrl= "https://www.demoblaze.com/index.html";
	String driverPath= "src/test/resources/drivers/chromedriver";
	public WebDriver driver;
	
	@BeforeTest
	private void startTesting() {
		System.out.println("This is a Before Test");
	}
	
	@BeforeMethod
	private void startDriver() {
		System.out.println("Browser to be launch!");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		System.out.println("Browser launched and maximized");
	
	}
	@Test
	public void sampleTestMethod() throws InterruptedException {
		
		Actions action = new Actions(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.get("https://www.demoblaze.com/index.html");
		
		String name= "Leslie";
		String country = "Mexico";
		String city = "Monterrey";
		String creditCard = "12345";
		String month = "July";
		String year = "2022";
		
		WebElement samsungGalaxys6Element = driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']"));
		action.moveToElement(samsungGalaxys6Element).click().perform();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/prod.html?idp_=1");
		
		WebElement addtoCartElement = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
		action.moveToElement(addtoCartElement).click().perform();
		
		//Boton de ok (no me dejo inspeccionarlo)
	//	WebElement okElement = driver.findElement(By.xpath(""));
	//	action.moveToElement(okElement).click().perform()
		
		
		WebElement carturButton = driver.findElement(By.cssSelector("#cartur"));
		action.moveToElement(carturButton).click().perform();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/cart.html");
		
		WebElement placeOrderElement = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-success']"));
		action.moveToElement(placeOrderElement).click().perform();
		
		
		WebElement nameBox = driver.findElement(By.cssSelector("#name"));
		action.moveToElement(nameBox).click().perform();
		action.moveToElement(nameBox).sendKeys(name);

		WebElement countryBox = driver.findElement(By.cssSelector("#country"));
		action.moveToElement(countryBox).click().perform();
		action.moveToElement(countryBox).sendKeys(country);
		
		WebElement cityBox = driver.findElement(By.cssSelector("#city"));
		action.moveToElement(cityBox).click().perform();
		action.moveToElement(cityBox).sendKeys(city);
		
		WebElement creditCardBox = driver.findElement(By.cssSelector("#card"));
		action.moveToElement(creditCardBox).click().perform();
		action.moveToElement(creditCardBox).sendKeys(creditCard);
		
		WebElement monthBox = driver.findElement(By.cssSelector("#month"));
		action.moveToElement(monthBox).click().perform();
		action.moveToElement(monthBox).sendKeys(month);
		
		WebElement yearBox = driver.findElement(By.cssSelector("#year"));
		action.moveToElement(yearBox).click().perform();
		action.moveToElement(yearBox).sendKeys(year);
		
		WebElement purchaseButton = driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']"));
		action.moveToElement(purchaseButton).click().perform();
		
		WebElement okButton = driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary' and @tabindex='1']"));
		action.moveToElement(okButton).click().perform();
		
		
		
		driver.quit();
	}
		@AfterMethod
		public void terminateBrowser() {
			driver.close();
			System.out.println("Browser closed!");
	}
		
		
		
		
		
		
		
		
		
		
}
