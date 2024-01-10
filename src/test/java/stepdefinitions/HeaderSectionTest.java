package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.A;
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

    WebDriver driver=Hooks.getDriver();
    HeaderSection headerSection=new HeaderSection(driver);
    String expected;
    String actual;



    @Then("the website logo should be visible")
    public void websiteLogoVisibility(){
        Assert.assertTrue(headerSection.websiteLogoVisible().isDisplayed(),"website logo Mismatch");
    }

    @And("the home route should be visible")
    public void homeRoute(){
        Assert.assertEquals(headerSection.homeLinkText().getText(),"Home","home route Mismatch");
    }

    @And("the popular route should be visible")
    public void popularRoute(){
        Assert.assertEquals(headerSection.popularLinkText().getText(),"Popular","popular route mismatch");
    }

    @And("the search icon should be visible")
    public void searchLogo(){
        Assert.assertTrue(headerSection.searchIcon().isDisplayed(),"search icon mismatch");
    }


    @And("the profile image should be visible")
    public void profileRoute(){
        Assert.assertTrue(headerSection.getAccountLink().isDisplayed(),"profile mismatch");
    }


    @When("I click popular route option on header section")
    public void clickPopularRoute(){
        headerSection.popularLinkText().click();
    }

    @Then("I should be redirected to the popular route section")
    public void navigateToPopularSection(){
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,"https://qamoviesapp.ccbp.tech/popular","popular Url mismatch");
    }


    @When("I click profile route option on header section")
    public void clickProfileRoute(){
        headerSection.getAccountLink().click();
    }


    @Then("I should be redirected to the profile route section")
    public void navigateToProfileRoute(){
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,"https://qamoviesapp.ccbp.tech/account","profile Url mismatch");
    }


    @When("I click search icon option on header section")
    public void clickSearchIcon(){
        headerSection.searchIcon().click();
    }


    @Then("I should be redirected to the search page")
    public void navigateToSearchPage(){
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,"https://qamoviesapp.ccbp.tech/search","search Url mismatch");
    }


    @When("I click home route on header section")
    public void clickHomeRouteOnHeaderSection(){
        headerSection.homeLinkText().click();
    }

}