package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    String expected="";
    String actual="";
    LoginPage loginPage;
    HomePage homePage;
    WebDriverWait wait;


    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void closeUp(){
        driver.quit();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage(){
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @When("I enter valid username as 'rahul'")
    public void enterValidUsername(){
        loginPage.enterUserField("rahul");
    }

    @And("I enter valid password as 'rahul@2021'")
    public void enterValidPassword(){
        loginPage.enterPasswordField("rahul@2021");
    }

    @And("I click the login button")
    public void clickTheLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the home page")
    public void navigatingToHomePage(){
        Assert.assertTrue(homePage.firstMovieHeading().isDisplayed(),"Not on Home Page");
    }

    @When("The website is opened perfectly")
    public void websiteOpenPerfectly(){
        expected="https://qamoviesapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expected));
    }

    @Then("the app logo image should be displayed")
    public void appLogoDisplay(){
        Assert.assertTrue(loginPage.getWebsiteLogo().isDisplayed(),"App logo image is not displayed");
    }

    @And("the heading text should be \"Login\"")
    public void checkWebsiteHead(){
        Assert.assertEquals(loginPage.getWebsiteHead().getText(),"Login","Website Text Mismatch");
    }

    @And("the username label text should be \"USERNAME\"")
    public void checkUserNameText(){
        Assert.assertEquals(loginPage.getLabelTextAtIndex(0),"USERNAME","username text Mismatch");
    }

    @And("the password label text should be \"PASSWORD\"")
    public void checkPasswordText(){
        Assert.assertEquals(loginPage.getLabelTextAtIndex(1),"PASSWORD","Password Text Mismatch");
    }

    @And("the login button should be displayed")
    public void checkLoginbuttonDisplay(){
        Assert.assertTrue(loginPage.loginButtonElement().isDisplayed(),"App logo image is not displayed");
    }

    @Then("an error message '*Username or password is invalid' should be visible")
    public void errorMessage(){
        String actualErrorMessage=loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage,"*Username or password is invalid","error message Mismatch");
    }


    @And("I enter invalid password as 'rahul2021'")
    public void enteringInvalidPassword(){
        loginPage.enterPasswordField("rahul2021");
    }

    @Then("an error message '*username and password didn't match' should be visible")
    public void getErrorForInvalidCredentials(){
        String actualErrorMsg=loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMsg,"*username and password didn't match","error Mismatch");
    }
}