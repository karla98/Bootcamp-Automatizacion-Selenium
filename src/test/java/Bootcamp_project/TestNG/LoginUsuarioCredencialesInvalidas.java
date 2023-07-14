package Bootcamp_project.TestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginUsuarioCredencialesInvalidas  {

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeTest
    public void preparAmbiente() {
        System.out.println("Before test");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();

        //System.setProperty("Webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver\\geckodriver.exe");
        //driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");

        // Configurar ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("loginCredencialesIncorrectas.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    
    @Test
    public void Credenciales_Invalidas() {
        test = extent.createTest("Credenciales inválidas", "Prueba para verificar el inicio de sesión de un usuarios existente pero con algun dato incorrecto");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ejemplo@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("contra123");
        driver.findElement(By.id("login")).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String textoActual = driver.findElement(By.id("alerta")).getText();
        
        // Texto esperado
        String textoEsperado = "LAS CREDENCIALES INGRESADAS SON INCORRECTAS";
        
        Assert.assertEquals(textoActual, textoEsperado, "El texto no coincide");
        // Marcar el caso de prueba como exitoso en el informe
        test.log(Status.PASS, "Prueba con credenciales inválidas con resultado con forme a lo esperado");
    }
    
    @Test
    public void User_Inexistente() {
    	try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test = extent.createTest("Usuario inexistente", "Prueba para verificar la existencia de un usuario");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ejemplo2023@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("contra123");
        driver.findElement(By.id("login")).click();

        String textoActual = driver.findElement(By.id("alerta")).getText();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Texto esperado
        String textoEsperado = "LAS CREDENCIALES INGRESADAS SON INCORRECTAS";
        
        Assert.assertEquals(textoActual, textoEsperado, "El texto no coincide");
        // Marcar el caso de prueba como exitoso en el informe
        test.log(Status.PASS, "Prueba con credenciales inválidas con resultado con forme a lo esperado");
    }

    @AfterTest
    public void postPrueba() {
        driver.quit();

        // Finalizar ExtentReports y generar el informe
        extent.flush();
    }

}
