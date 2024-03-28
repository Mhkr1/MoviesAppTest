package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.time.Duration;

public class Hooks {

    private static WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();

    }

    @After
    public void tearDown() {
        driver.quit();
    }


    public static WebDriver getDriver() {
        return driver;
    }
}
