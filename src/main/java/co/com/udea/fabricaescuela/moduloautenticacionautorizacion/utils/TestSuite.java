package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.utils;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.BotonPerfil;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Suite.class)
@SuiteClasses({
    LoginPage.class,
    BotonPerfil.class
})

public class TestSuite {   
    public static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        // Otras configuraciones, como maximizar la ventana, timeouts, etc.
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
}
