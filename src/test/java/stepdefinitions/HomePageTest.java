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

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;

import pages.LoginPage;



import java.time.Duration;



public class HomePageTest {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage=new HomePage(driver);

    @When("I am on home page first heading should be 'Trending Now'")
    public void firstHead(){
        Assert.assertEquals(homePage.firstMovieHeading().getText(),"Trending Now","first head Mismatch");
    }

    @Then("the second heading should be 'Originals'")
    public void secondHead(){
        Assert.assertEquals(homePage.secondMovieHeading().getText(),"Originals","2nd Head Mismatch");
    }

    @And("play button should be visible on the home page")
    public void playButtonVisible(){
        Assert.assertTrue(homePage.playBtnEle().isDisplayed(),"play button mismatch");
    }

    @And("Trending now movies should be visible")
    public void trendingMoviesDisplayed(){
        Assert.assertTrue(homePage.trendingMoviesVisibility(0).isDisplayed(),"Trending Movies Not Visible");
    }

    @And("Originals movies should be visible")
    public void originalsMoviesDisplayed(){
        Assert.assertTrue(homePage.originalsMovieVisibility(0).isDisplayed(),"Originals Movies Not Visible");
    }

    @And("contact us icons should be visible")
    public void contactIconsDisplayed(){
        Assert.assertTrue(homePage.contactIconsVisibility().size()==4,"Contact Icons Not Visible");
    }

    @And("contact us Section should be visible")
    public void contactUsSection() {
        Assert.assertTrue(homePage.contactButtonEle().isDisplayed(), "contact us section not visible");
    }

}