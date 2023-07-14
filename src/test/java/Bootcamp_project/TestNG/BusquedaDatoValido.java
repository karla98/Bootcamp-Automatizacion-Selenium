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

public class BusquedaDatoValido {

    WebDriver dr;
    ExtentReports extent;
    ExtentTest logger;

    @BeforeTest
    public void preparAmbiente() {
        System.out.println("Before test");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chrome\\chromedriver.exe");
        dr = new ChromeDriver();
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Selenium\\reportes\\buscavalida.html");
        extent.attachReporter(htmlReporter);
        logger = extent.createTest("BusquedaDatoValido");
    }

    @Test
    public void Busqueda_Invalida() {
        dr.manage().window().maximize();
        dr.get("http://localhost:3000/");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dr.findElement(By.id("email")).clear();
        dr.findElement(By.id("email")).sendKeys("ejemplo@gmail.com");
        dr.findElement(By.id("password")).clear();
        dr.findElement(By.id("password")).sendKeys("contra12345");
        dr.findElement(By.id("login")).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dr.findElement(By.id("goToOCC")).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dr.findElement(By.name("busqueda")).sendKeys("BBVA");
        dr.findElement(By.id("buscar")).click();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String textoActual = dr.findElement(By.id("empresaBuscada")).getText();
        
        // Texto esperado
        String textoEsperado = "EMPRESA BUSCADA: BBVA";
        
        // Verifica si el texto esperado aparece en el elemento h2
        Assert.assertEquals(textoActual, textoEsperado, "El texto en el h2 no coincide");
        logger.log(Status.PASS, "La prueba de búsqueda valida se completó correctamente.");
    }

    @AfterTest
    public void postPrueba() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dr.findElement(By.id("btnCerrarSesionOcc")).click();

        dr.quit();

        extent.flush();
    }

}
