package week4_assign_day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingOnWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		//Click on Open Home Page
		driver.findElement(By.id("home")).click();
		Set<String> window = driver.getWindowHandles();
		List <String> list = new ArrayList<String>(window);
		driver.switchTo().window(list.get(1));
		String childwindow = driver.getTitle();
		System.out.println("Child Window name is "+ childwindow);
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(list.get(0));
		String parentwindow = driver.getTitle();
		System.out.println("Parent Window name is "+ parentwindow);
		
		
		//Find the number of opened windows
		driver.findElement(By.xpath("//button [text() = 'Open Multiple Windows']")).click();
		Set<String> openedwindow = driver.getWindowHandles();
		List <String> openedlist = new ArrayList<String>(openedwindow);
		driver.switchTo().window(openedlist.get(1));
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(openedlist.get(0));
		
		//Close all except this window
		driver.findElement(By.xpath("//button [text() = 'Do not close me ']")).click();
		Set<String> closedwindow = driver.getWindowHandles();
		List <String> closedlist = new ArrayList<String>(closedwindow);
		driver.switchTo().window(closedlist.get(1));
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(closedlist.get(0));
		
		//Wait for 5 seconds
		driver.findElement(By.xpath("//button [text() = 'Do not close me ']")).click();
		Set<String> window1 = driver.getWindowHandles();
		List <String> list1 = new ArrayList<String>(window1);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(list1.get(0));
		driver.quit();
			
	}

}
