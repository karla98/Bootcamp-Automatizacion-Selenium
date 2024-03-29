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

public class LoginUsuarioDatosInvalidos  {

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
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("logindatosInvalidos.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void Email_Invalido() {
        test = extent.createTest("Login de email con formato invalido", "Prueba para verificar el inicio de sesión con datos en formato no adecuado");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ejemplogmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("contra12345");
        driver.findElement(By.id("login")).click();

        String textoActual = driver.findElement(By.id("alerta")).getText();
        
        // Texto esperado
        String textoEsperado = "INGRESE UN CORREO ELECTRÓNICO VÁLIDO";
        
        Assert.assertEquals(textoActual, textoEsperado, "El texto no coincide");
        // Marcar el caso de prueba como exitoso en el informe
        test.log(Status.PASS, "Email: Prueba con formatos invalidos con resultado con forme a lo esperado");
    }
    
    @Test
    public void Password_Invalida() {
        test = extent.createTest("Login de datos con password invalida", "Prueba para verificar el inicio de sesión con datos en formato no adecuado");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ejemplo@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("login")).click();

        String textoActual = driver.findElement(By.id("alerta")).getText();
        
        // Texto esperado
        String textoEsperado = "CONTRASEÑA DEMASIADO CORTA";
        
        Assert.assertEquals(textoActual, textoEsperado, "El texto no coincide");
        // Marcar el caso de prueba como exitoso en el informe
        test.log(Status.PASS, "Password: Prueba con formatos invalidos con resultado con forme a lo esperado");
    }
    
    @AfterTest
    public void postPrueba() {
        driver.quit();

        // Finalizar ExtentReports y generar el informe
        extent.flush();
    }

}
