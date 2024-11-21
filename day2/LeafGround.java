package week2.day2;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//span[text()='Click']")).click();
//Verify the title		
		String title = driver.getTitle();
		System.out.println(title);
//Back to back page
		driver.navigate().back();
//confrim the button is disable
		boolean value = driver.findElement(By.xpath("//span[text()='Disabled']")).isDisplayed();
		assertEquals(value,true);
		System.out.println(value);
//Position of the button		
		Rectangle res= driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).getRect();
		int x = res.getX();
		int y = res.getY();
		System.out.println("x-axis position:"+ x);
		System.out.println("y-axis position:"+ y);
		
//Background color of the button
		WebElement background = driver.findElement(By.xpath("//span[text()='Save']"));
		String cssvalue = background.getCssValue("background-color");
		System.out.println(cssvalue);
		
//Height and Width of the button
		WebElement handw = driver.findElement(By.xpath("(//span[text()='Success'])[1]"));
		int a = handw.getSize().getWidth();
		int b = handw.getSize().getHeight();
		System.out.println("Height is:"+a); 
		System.out.println("Width is:"+ b);		
		
	}

}
