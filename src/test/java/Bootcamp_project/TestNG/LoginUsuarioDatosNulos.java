package Bootcamp_project.TestNG;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class LoginUsuarioDatosNulos {
    WebDriver dr;
	
	@BeforeTest
	public void preparAmbiente() {
		//System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\drivers\\chrome\\chrome.exe");
		//dr = new ChromeDriver();
		
		System.setProperty("Webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver\\geckodriver.exe");
		dr = new FirefoxDriver();
		
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
		dr.findElement(By.id("password")).sendKeys("contra");		
		dr.findElement(By.id("login")).click();
		
		//validar prueba 
			//boolean isDisplayed = dr.findElement(By.id("alertaCamposVacios")).isDisplayed();
		    //Assert.assertTrue(isDisplayed);
		    
	    WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        Alert alert = null;
        int attempts = 0;

        while (alert == null && attempts < 5) {
            try {
                alert = wait.until(ExpectedConditions.alertIsPresent());
            } catch (Exception e) {
                attempts++;
                // Esperar un poco antes de intentar nuevamente
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        Assert.assertNotNull(alert, "No se encontró ninguna alerta en la página.");
        System.out.println("Se encontró una alerta en la página.");

        // Puedes interactuar con la alerta según sea necesario
        alert.accept();
	}
/*
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
	*/
	@AfterTest
	public void postPrueba() {
		dr.quit();
		//dr.close();
	}

}
