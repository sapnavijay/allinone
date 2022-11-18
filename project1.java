package amazon;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class project1
{
	public static void main(String[] args) throws InterruptedException
	{
		registration();
		login();
		add_to_cart();
		order();
		
	}
	public static void registration() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./Softwaredrivers/geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("https://www.amazon.com");
		d.navigate().refresh();
		Thread.sleep(5000);
	
		/*Actions act=new Actions(d);
		WebElement signin = d.findElement(By.xpath("//span[.='Hello, sign in']"));
		act.moveToElement(signin).perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[.='Start here.']")).click();*/
		//by using actions class(mouse hower)
		
		
		d.findElement(By.xpath("//span[.='Hello, sign in']")).click();
		Thread.sleep(5000);
		d.findElement(By.id("createAccountSubmit")).click();
		Thread.sleep(5000);
		//by using only click action
		d.findElement(By.xpath("//input[@placeholder='First and last name']")).sendKeys("sapna");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("8880513755");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//span[@data-action='show-countries']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[.='India +91']")).click();
		Thread.sleep(2000);
		d.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(2000);
		d.findElement(By.name("passwordCheck")).sendKeys("123456");
		Thread.sleep(2000);
		d.findElement(By.id("continue")).click();
		Thread.sleep(5000);
		//WebElement f1 = d.findElement(By.xpath("//iframe[@id='cvf-aamation-challenge-iframe']"));
		d.switchTo().frame("cvf-aamation-challenge-iframe");
		Thread.sleep(2000);
		
		//WebElement f2 = d.findElement(By.xpath("//iframe[@id='aacb-arkose-frame']"));
		d.switchTo().frame("aacb-arkose-frame");
		Thread.sleep(2000);
		
		WebElement f3 = d.findElement(By.xpath("//iframe[@title='Verification challenge']"));
		d.switchTo().frame(f3);
		Thread.sleep(2000);
		
		//WebElement f4 = d.findElement(By.xpath("//iframe[@id='fc-iframe-wrap']"));
		d.switchTo().frame("fc-iframe-wrap");
		Thread.sleep(2000);
		
		//WebElement f4 = d.findElement(By.xpath("//iframe[@id='CaptchaFrame']"));
		d.switchTo().frame("CaptchaFrame");
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//button[.='Solve Puzzle']")).click();
		Thread.sleep(5000);

	

		
	}
	public static void login() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./Softwaredrivers/geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("https://www.amazon.com");
		Thread.sleep(5000);
		d.findElement(By.xpath("//span[.='Hello, sign in']")).click();
		Thread.sleep(5000);
		d.findElement(By.id("ap_email")).sendKeys("8880513755");
		Thread.sleep(2000);
		d.findElement(By.id("continue")).click();
		Thread.sleep(5000);
		d.findElement(By.id("ap_password")).sendKeys("Sap1999@dvg");
		Thread.sleep(2000);
		d.findElement(By.id("signInSubmit")).click();
		
	}
	public static void add_to_cart() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./Softwaredrivers/geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("https://www.amazon.com");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("(//div[.='Options:'])[1]/ancestor::div[6]/div[1]/h2/a")).click();
		
		//d.findElement(By.xpath("//span[@id='exportsUndeliverable-cart-announce']")).click();
	
		
	}
	public static void order() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./Softwaredrivers/geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.get("https://www.amazon.in/");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("//span[.='Apple iPhone 11 (64GB) - Black']")).click();
		Thread.sleep(5000);
		
		String main = d.getWindowHandle();
		Set<String> all = d.getWindowHandles();
		ArrayList<String> list=new ArrayList<String>(all);
		String child = list.get(1);
		d.switchTo().window(child);
		
		Thread.sleep(5000);
		Actions act=new Actions(d);
		//scroll to down
		act.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@id='buy-now-button']")).click();
		Thread.sleep(2000);
		d.findElement(By.id("ap_email")).sendKeys("8880513755");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(5000);
		d.findElement(By.id("ap_password")).sendKeys("Sap1999@dvg");
		Thread.sleep(2000);
		d.findElement(By.id("signInSubmit")).click();


		
	}
	
	

}
