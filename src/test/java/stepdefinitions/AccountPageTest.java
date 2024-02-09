package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AccountPage;
import pages.HeaderSection;
import pages.LoginPage;

import java.time.Duration;

public class AccountPageTest {

    WebDriver driver=Hooks.getDriver();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    LoginPage loginPage=new LoginPage(driver);

    AccountPage accountPage=new AccountPage(driver);
    String expectedUrl;
    String actualUrl;

    @When("I am on account page")
    public void iAmOnAccountPage(){
        System.out.println("I am on Account Page");
    }


    @When("I click on logout button on account page")
    public void clickOnlogoutOnAccountPage(){
        accountPage.accountLogoutButtonEl().click();
    }



    @Then("I should be redirected to the login page")
    public void redirectedToLoginPageFromAccountPage(){
        expectedUrl="https://qamoviesapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Login URL mimatch");
    }



    @Then("account heading should be visible on account page")
    public void accountHeadingDisplayed(){
        Assert.assertEquals(accountPage.accountHeadEl().getText(),"Account","Account heading not visible");
    }

    @And("membership heading should be visible on account page")
    public void membershipHeading(){
        Assert.assertEquals(accountPage.membershipHead().get(0).getText(),"Member ship","memship heading mismatch");
    }

    @And("plan details heading should be visible on account page")
    public void planDetailsHeading(){
        Assert.assertEquals(accountPage.membershipHead().get(1).getText(),"Plan details","plan details ismatch");
    }

    @And("account user name should be visible on account page")
    public void userNameOnAccountPage(){
        Assert.assertEquals(accountPage.accountUserNameEl().getText(),"User name : rahul","username mismatch");
    }

    @And("account password should be visible on account page")
    public void passwordOnAccountPage(){
        Assert.assertEquals(accountPage.accountPasswordEl().getText(),"Password : **********","password mismatch" );
    }

    @And("account plan type should be visible on account page")
    public void planOnAccountPage(){
        Assert.assertEquals(accountPage.accountPlanType().getText(),"Premium");
    }

    @And("account plan details should be visible on account page")
    public void planDetailsOnAccountPage(){
        Assert.assertEquals(accountPage.accountPlanQuality().getText(),"Ultra HD","quality mismatch");
    }

    @And("account logout button should be visible on account page")
    public void logoutButtonOnAccountPage(){
        Assert.assertEquals(accountPage.accountLogoutButtonEl().getText(),"Logout","logout mismatch");
    }
}