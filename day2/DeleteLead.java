package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//Login Page:		
		WebElement username = driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input"));
		username.sendKeys("Demosalesmanager");
		WebElement password=driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input"));
		password.sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
//Click CRM Link
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
//Click Find Lead Tab
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
//Capture First row lead id		
		WebElement capture = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String value = capture.getText();
		System.out.println(value);
//View the first lead		
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
//Delete the lead
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
//Again Click Find Lead Tab
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
//Passing the capture value
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(value);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();		

	}

}
