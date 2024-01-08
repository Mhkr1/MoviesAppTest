package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HeaderSection;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HeaderSectionTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    HeaderSection headerSection;
    String expected;
    String actual;

    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
        headerSection=new HeaderSection(driver);

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage.loginToApplication("rahul","rahul@2021");
        String expectedUrl="https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @After
    public void closeUp(){
        driver.quit();
    }

    @Then("the website logo should be visible")
    public void websiteLogoVisibility(){
        Assert.assertTrue(headerSection.websiteLogoVisible().isDisplayed(),"website logo Mismatch");
    }

    @Then("the home route should be visible")
    public void homeRoute(){
        Assert.assertEquals(headerSection.homeLinkText().getText(),"Home","home route Mismatch");
    }

    @Then("the popular route should be visible")
    public void popularRoute(){
        Assert.assertEquals(headerSection.popularLinkText().getText(),"Popular","popular route mismatch");
    }

    @Then("the search icon should be visible")
    public void searchLogo(){
        Assert.assertTrue(headerSection.searchIcon().isDisplayed(),"search icon mismatch");
    }

    @Then("the profile image should be visible")
    public void profileRoute(){
        Assert.assertTrue(headerSection.getAccountLink().isDisplayed(),"profile mismatch");
    }

    @When("I click popular route option on header section")
    public void clickPopularRoute(){
        headerSection.popularLinkText().click();
    }

    @When("I click profile route option on header section")
    public void clickProfileRoute(){
        headerSection.getAccountLink().click();
    }

    @When("I click search icon option on header section")
    public void clickSearchIcon(){
        headerSection.searchIcon().click();
    }

    @Then("I should be redirected to the profile route section")
    public void navigateToProfileRoute(){
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,"https://qamoviesapp.ccbp.tech/account","profile Url mismatch");
    }


    @Then("I should be redirected to the popular route section")
    public void navigateToPopularSection(){
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,"https://qamoviesapp.ccbp.tech/popular","popular Url mismatch");
    }


    @Then("I should be redirected to the search page")
    public void navigateToSearchPage(){
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,"https://qamoviesapp.ccbp.tech/search","search Url mismatch");
    }


    @Given("I am on the popular page")
    public void iAmOnPopularPage(){
        clickPopularRoute();
        navigateToPopularSection();
    }

    @Given("I am on the profile page")
    public void iAmOnProfilePage(){
        clickProfileRoute();
        navigateToProfileRoute();
    }

    @Given("I am on the search page")
    public void iAmOnSearchPage(){
        clickSearchIcon();;
        navigateToSearchPage();
    }

    @When("I click home route on header section")
    public void clickHomeRouteOnHeaderSection(){
        headerSection.homeLinkText().click();
    }

    @Then("I should be navigate to the home page on header section")
    public void navigateToHomeOnHeaderSection(){
        expected="https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expected));
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,expected,"Url Mismatch");
    }

}