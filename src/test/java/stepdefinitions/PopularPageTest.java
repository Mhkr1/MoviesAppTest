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
import pages.PopularPage;

import java.time.Duration;

public class PopularPageTest {


    WebDriver driver=Hooks.getDriver();
    String expectedUrl;
    String actualUrl;

    PopularPage popularPage=new PopularPage(driver);
    HeaderSection headerSection=new HeaderSection(driver);


    @Then("the popular movies should be visible on popular page")
    public void popularMovieList(){
        Assert.assertTrue(popularPage.moviesOnPopularPage().size()>0,"Popular Movies Not Visible");
    }

    @When("I click on a movie in popular page")
    public void clickOnVisibleMovieOnPopularPage(){
        popularPage.moviesOnPopularPage().get(0).click();
    }

    @Then("I should be navigate to that movie details page")
    public void navigateToMoviePageFromPopularPage(){
        expectedUrl="https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f";
        actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Navigation Failed");
    }


}