package week4_assign_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Alert.html");
		//Click on Alert box
		driver.findElement(By.xpath("//button [text() = 'Alert Box']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//Click on confirm box
		driver.findElement(By.xpath("//button [text() = 'Confirm Box']")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		
		//click on Prompt Box 
		driver.findElement(By.xpath("//button [text() = 'Prompt Box']")).click();
		driver.switchTo().alert().sendKeys("Mubi");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//Click on Line Breaks?
		driver.findElement(By.xpath("//button [text() = 'Line Breaks?']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//click on switch alert
		driver.findElement(By.xpath("//button [text() = 'Sweet Alert']")).click();
		driver.findElement(By.xpath("//button [text() = 'OK']")).click();
		driver.close();
	}

}
