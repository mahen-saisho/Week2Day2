package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//Login Page:		
		WebElement username = driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input"));
		username.sendKeys("Demosalesmanager");
		WebElement password=driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input"));
		password.sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
//Click CRM Link
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
//Click Lead Tab
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
//Create Lead	
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Mahe-Company11");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Mahendran");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("mahe");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("localname");
		driver.findElement(By.name("departmentName")).sendKeys("new department");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Automating Site Practice");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("mahendran@gmail.com");
//SelectByValue	for selecting State
		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select newyork = new Select(state);
		newyork.selectByValue("NY");
//Click Create
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
//Click EDIT		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Edit & Updated fields in Important note textarea");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		String title = driver.getTitle();
		System.out.println(title);

	}

}
