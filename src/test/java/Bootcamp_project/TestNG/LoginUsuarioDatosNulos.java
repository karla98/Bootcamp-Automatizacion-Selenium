package Bootcamp_project.TestNG;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class LoginUsuarioDatosInvalidos {
    WebDriver dr;
	
	@BeforeTest
	public void preparAmbiente() {
		System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\drivers\\chrome\\chrome.exe");
		dr = new ChromeDriver();
		
		//System.setProperty("Webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver\\geckodriver.exe");
		//dr = new FirefoxDriver();
		
		dr.manage().window().maximize();
		dr.get("http://localhost:3000/");
		
	}
    
	@Test
	public void Login_Nulos() {
		System.out.println("Test 1");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.findElement(By.id("email")).clear();
		//dr.findElement(By.id("email")).sendKeys("ejemplogmail.com");
		dr.findElement(By.id("password")).clear();
		//dr.findElement(By.id("password")).sendKeys("contra");		
		dr.findElement(By.id("login")).click();
	}

	@Test
	public void Login_Password_Nulo() {
		System.out.println("Test 2");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.findElement(By.id("email")).clear();
		dr.findElement(By.id("email")).sendKeys("ejemplogmail.com");
		dr.findElement(By.id("password")).clear();
		//dr.findElement(By.id("password")).sendKeys("contra");		
		dr.findElement(By.id("login")).click();
	}

	@Test
	public void Login_Email_Nulo() {
		System.out.println("Test 3");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.findElement(By.id("email")).clear();
		//dr.findElement(By.id("email")).sendKeys("ejemplogmail.com");
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys("contra");		
		dr.findElement(By.id("login")).click();
	}
	
	@AfterTest
	public void postPrueba() {
        //TODO  salir de sesion
		dr.quit();
		//dr.close();
	}

}