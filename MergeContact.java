package week4_assign_day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws Throwable {				
				 //Pseudo Code
				 
				 // * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://leaftaps.com/opentaps/control/login");
				 //* 2. Enter UserName and Password Using Id Locator 
				driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				//* 3. Click on Login Button using Class Locator
				  driver.findElement(By.className("decorativeSubmit")).click();
				 //* 4. Click on CRM/SFA Link
				  driver.findElement(By.linkText("CRM/SFA")).click();
				 //* 5. Click on contacts Linktext
				  	driver.findElement(By.linkText("Contacts")).click();
				 // * 6. Click on Merge Contacts using Xpath Locator
				  driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				 // * 7. Click on Widget of From Contact
				  driver.findElement(By.xpath("//img[@alt= 'Lookup']")).click();
				 Set<String> windowhandles = driver.getWindowHandles();
				 List <String> window = new ArrayList<String>(windowhandles);
				 driver.switchTo().window(window.get(1));
				 driver.findElement(By.name("firstName")).sendKeys("test");
				 driver.findElement(By.xpath("//button[text() = 'Find Contacts']")).click();
				 Thread.sleep(1000);
				 //* 8. Click on First Resulting Contact
				 String ID = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
				 driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
				 System.out.println(ID);
				 driver.switchTo().window(window.get(0));
				 
				 //* 9. Click on Widget of To Contact
				 driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
				 Set<String>windowhandles1 = driver.getWindowHandles();
				 List<String> window1 = new ArrayList <String>(windowhandles1);
				 driver.switchTo().window(window1.get(1));
				 driver.findElement(By.name("firstName")).sendKeys("deepak rajan");
				 driver.findElement(By.xpath("//button[text() = 'Find Contacts']")).click();
				 Thread.sleep(1000);
				 
				 //* 10. Click on Second Resulting Contact
				 driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
				 driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
				 driver.switchTo().window(window.get(0));
				  
				 //* 11. Click on Merge button using Xpath Locator
				 driver.findElement(By.linkText("Merge")).click();
				 
				 //* 12. Accept the Alert
				 driver.switchTo().alert().accept();
				 
				 //* 13. Verify the title of the page
				 System.out.println("The Title is " +  driver.getTitle());
					if (driver.getTitle().contains("View")) {
						System.out.println("Title Matched");
					}
					else
					{
						System.out.println("Title not matched");
					}
				 driver.close();
			}

		}