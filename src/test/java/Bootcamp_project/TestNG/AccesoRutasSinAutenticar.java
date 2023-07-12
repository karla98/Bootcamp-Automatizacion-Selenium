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
	}
    
	@Test
	public void AccesoHistoria2() {
		dr.manage().window().maximize();
		dr.get("http://localhost:3000/occ");
		
	}

    	@Test
	public void AccesoDashboard() {
		dr.manage().window().maximize();
		dr.get("http://localhost:3000/home");
		
	}
	
	@AfterTest
	public void postPrueba() {
        //TODO  salir de sesion
		dr.quit();
		//dr.close();
	}

}
