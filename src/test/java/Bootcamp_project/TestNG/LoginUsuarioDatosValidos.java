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

public class LoginUsuarioDatosValidos {

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
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void Login_Valido() {
        test = extent.createTest("Login de datos válidos", "Prueba para verificar el inicio de sesión con datos válidos");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ejemplo@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("contra12345");
        driver.findElement(By.id("login")).click();

        // Verificar si se muestra el elemento
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isDisplayed = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div[1]")).isDisplayed();
        Assert.assertTrue(isDisplayed);

        // Marcar el caso de prueba como exitoso en el informe
        test.log(Status.PASS, "Inicio de sesión exitoso");
    }

    @AfterTest
    public void postPrueba() {
        //TODO*

        driver.findElement(By.id("btnCerrarSesion")).click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

        // Finalizar ExtentReports y generar el informe
        extent.flush();
    }

}
