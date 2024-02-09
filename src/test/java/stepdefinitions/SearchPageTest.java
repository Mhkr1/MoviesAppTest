package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HeaderSection;
import pages.LoginPage;
import pages.PopularPage;
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {

    WebDriver driver=Hooks.getDriver();
    String expectedUrl;
    String actualUrl;
    HeaderSection headerSection=new HeaderSection(driver);
    SearchPage searchPage=new SearchPage(driver);



    @When("No input was entered")
    public void emptyInput(){
        headerSection.searchIcon().click();
    }

    @And("I click search button")
    public void clickSearchEl() {
        searchPage.clickSearchButton().click();
    }

    @Then("I should get the count of movies displayed")
    public void moviesVisibledOnSearchPage(){
        Assert.assertTrue(searchPage.moviesListDisplayed().size()>0);
    }

    @When("I enter invalid movie name 'salaar'")
    public void enterInvalidMovieInInputField(){
        headerSection.searchIcon().click();
        searchPage.enterMovieName().sendKeys("salaar");
    }

    @When("I enter valid movie name 'Titanic'")
    public void enterValidMovieName(){
        headerSection.searchIcon().click();
        searchPage.enterMovieName().sendKeys("Titanic");
    }

    @And("I click on the titanic movie")
    public void clickTitanicMovie(){
        searchPage.moviesListDisplayed().get(0).click();
    }

    @Then("I should be navigated to the titanic movie details page")
    public void navigateToMovieDetailsPageOfSearchPage(){
        expectedUrl="https://qamoviesapp.ccbp.tech/movies/33119fe5-3966-4bba-b98c-10b241ffc9f8";
        actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Url Mismatch");
    }

    @Then("An error message 'Your search for salaar did not find any matches.' should be visible")
    public void invalidMovieMessage(){
        Assert.assertEquals(searchPage.invalidInputMessageOnSearchPage().getText(),"Your search for salaar did not find any matches.","Movie Invalid");
    }




}