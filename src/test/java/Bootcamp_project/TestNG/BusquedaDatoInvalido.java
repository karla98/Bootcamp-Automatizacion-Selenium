package Bootcamp_project.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BusquedaDatoInvalido {
	
	WebDriver dr;
	
	@BeforeTest
	public void preparAmbiente() {
		System.out.println("Before test");
		System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\drivers\\chrome\\chrome.exe");
		dr = new ChromeDriver();
		
		//System.setProperty("Webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver\\geckodriver.exe");
		//dr = new FirefoxDriver();
		
		dr.manage().window().maximize();
		dr.get("http://localhost:3000/");

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.findElement(By.id("email")).clear();
		dr.findElement(By.id("email")).sendKeys("ejemplo@gmail.com");
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys("contra12345");		
		dr.findElement(By.id("login")).click();

		dr.get("http://localhost:3000/occ");

		
	}
    
	@Test
	public void Busqueda_Invalida() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.findElement(By.id("busqueda")).clear();
		dr.findElement(By.id("busqueda")).sendKeys("<BBVA>");
		dr.findElement(By.id("buscar")).click();
	}
	
	@AfterTest
	public void postPrueba() {
		//cerrar sesion
		dr.quit();
		//dr.close();
	}
	
}
