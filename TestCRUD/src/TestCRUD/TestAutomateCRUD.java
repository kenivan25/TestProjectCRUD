package TestCRUD;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAutomateCRUD {
public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//CREATE
	driver.get("http://computer-database.herokuapp.com/computers");
	Thread.sleep(1000);
	driver.findElement(By.id("add")).click();
	driver.findElement(By.xpath("/html/body/section/form/div/input")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("name")).sendKeys("AutomateComputerName");
	driver.findElement(By.id("introduced")).sendKeys("2010-01-01");
	driver.findElement(By.id("discontinued")).sendKeys("2010-01-01");
	
	//for dropdown selection
	WebElement company_dropdown=driver.findElement(By.id("company"));
	Select company=new Select(company_dropdown);
	company.selectByVisibleText("Sony");
	Thread.sleep(2000);
	
	//google chrome > inspect button > copy > copy full Xpath
	driver.findElement(By.xpath("/html/body/section/form/div/input")).click();
	Thread.sleep(2000);
	
	//READ
	driver.findElement(By.id("searchbox")).sendKeys("AutomateComputerName");
	Thread.sleep(2000);
	driver.findElement(By.id("searchsubmit")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/section/table/tbody/tr[1]/td[1]/a")).click();
	Thread.sleep(2000);
	
	//UPDATE
	driver.findElement(By.id("name")).clear();
	Thread.sleep(1000);
	driver.findElement(By.id("introduced")).clear();
	Thread.sleep(1000);
	driver.findElement(By.id("discontinued")).clear();
	Thread.sleep(2000);
	driver.findElement(By.id("name")).sendKeys("AutomateComputerName001");
	driver.findElement(By.id("introduced")).sendKeys("2011-11-11");
	driver.findElement(By.id("discontinued")).sendKeys("2011-11-11");
	WebElement company_dropdown2=driver.findElement(By.id("company"));
	Select company2=new Select(company_dropdown2);
	company2.selectByVisibleText("IBM");
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/section/form[1]/div/input")).click();
	Thread.sleep(2000);
	
	//DELETE
	driver.findElement(By.id("searchbox")).sendKeys("AutomateComputerName");
	Thread.sleep(2000);
	driver.findElement(By.id("searchsubmit")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/section/table/tbody/tr[1]/td[1]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/section/form[2]/input")).click();

}
}
