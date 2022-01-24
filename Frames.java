package week4_assign_day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input")).sendKeys("Mubi");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input [@id = 'a']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		  WebElement element = driver.findElement(By.id("animals"));
			 Select drop1 = new Select(element);
			 drop1.selectByValue("babycat");
			 Thread.sleep(1000);
		driver.close();
		
	}

}
