package Bootcamp_project.TestNG;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.apache.commons.lang3.time.StopWatch;

public class AccesoRutasSinAutenticar {
    WebDriver dr;
    StopWatch stopWatch;

	@BeforeTest
	public void preparAmbiente() {
		System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\drivers\\chrome\\chrome.exe");
		dr = new ChromeDriver();
		
		//System.setProperty("Webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver\\geckodriver.exe");
		//dr = new FirefoxDriver();
		stopWatch = new StopWatch();
        stopWatch.start();
	}
    
	@Test
	public void AccesoHistoria2() {
		dr.manage().window().maximize();
		dr.get("http://localhost:3000/occ");
	        stopWatch.stop();
	        long elapsedTime = stopWatch.getTime();
	        Assert.assertTrue(elapsedTime < 1000, "La página estuvo más de 1 segundo cargando");
	    
		
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
