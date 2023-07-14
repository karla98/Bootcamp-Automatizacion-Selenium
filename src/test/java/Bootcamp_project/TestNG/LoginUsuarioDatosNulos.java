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

public class LoginUsuarioDatosNulos  {

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
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("logindatosNulos.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void Email_Nulo() {
        test = extent.createTest("Login de email nulo", "Prueba para verificar el inicio de sesión con datos nulos");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("contra12345");
        driver.findElement(By.id("login")).click();

        String textoActual = driver.findElement(By.id("alerta")).getText();
        
        // Texto esperado
        String textoEsperado = "POR FAVOR, COMPLETA TODOS LOS CAMPOS";
        
        Assert.assertEquals(textoActual, textoEsperado, "El texto no coincide");
        // Marcar el caso de prueba como exitoso en el informe
        test.log(Status.PASS, "Email: Prueba con nulos con resultado con forme a lo esperado");
    }
    
    @Test
    public void Password_Nulo() {
        test = extent.createTest("Login de password nula", "Prueba para verificar el inicio de sesión con datos nulos");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ejemplo@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("login")).click();

        String textoActual = driver.findElement(By.id("alerta")).getText();
        
        // Texto esperado
        String textoEsperado = "POR FAVOR, COMPLETA TODOS LOS CAMPOS";
        
        Assert.assertEquals(textoActual, textoEsperado, "El texto no coincide");
        // Marcar el caso de prueba como exitoso en el informe
        test.log(Status.PASS, "Password: Prueba con nulos con resultado con forme a lo esperado");
    }
    
    @AfterTest
    public void postPrueba() {
        driver.quit();

        // Finalizar ExtentReports y generar el informe
        extent.flush();
    }

}
