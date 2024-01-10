package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HeaderSection;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;

public class Hooks {

    private static WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);
        HeaderSection headerSection=new HeaderSection(driver);
        PopularPage popularPage=new PopularPage(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }


    public static WebDriver getDriver() {
        return driver;
    }
}
