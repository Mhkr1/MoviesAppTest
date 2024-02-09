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
import pages.*;

import javax.accessibility.AccessibleStateSet;
import java.time.Duration;

public class MovieDetailsPageTest {

    WebDriver driver=Hooks.getDriver();

    String expectedUrl;
    String actualUrl;

    HomePage homePage=new HomePage(driver);
    MovieDetailsPage movieDetailsPage=new MovieDetailsPage(driver);
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    @When("I click on one trending movie for movies details page")
    public void clickFirstTrendingMovieForMovieDetailsPage(){
        wait.until(ExpectedConditions.visibilityOf(homePage.trendingMoviesVisibility(0))).click();
    }

    @When("I click on one originals movie for movies details page")
    public void clickFirstOriginalsMovieForMovieDetailsPage(){
        wait.until(ExpectedConditions.visibilityOf(homePage.originalsMovieVisibility(0))).click();
    }

    @And("I should be redirected to that trending movie details page")
    public void redirectToTrendingMovieDetailsPage(){
        expectedUrl="https://qamoviesapp.ccbp.tech/movies/92c2cde7-d740-443d-8929-010b46cb0305";
        actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Navigation to Trending movies details page failed");
    }

    @And("I should be redirected to that originals movie details page")
    public void redirectToOriginalMovieDetailsPage(){
        expectedUrl="https://qamoviesapp.ccbp.tech/movies/efb33428-5527-44d0-a713-1aeef4d56968";
        actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Navigation to Originals movies details page failed");
    }

    @And("the movie title should be visible on movie details page")
    public void movieTitleDisplayed(){
        Assert.assertTrue(movieDetailsPage.movieTitleEl().isDisplayed());
    }

    @And("the sensor rating should be visible on movie details page")
    public void sensorRatingVisibility(){
        Assert.assertTrue(movieDetailsPage.sensorRatingEl().isDisplayed());
    }

    @And("the release year should be visible on movie details page")
    public void releaseYearDisplayed(){
        Assert.assertTrue(movieDetailsPage.getReleaseDate().isDisplayed());
    }

    @And("the movie overview should be visible on movie details page")
    public void movieOverviewDisplayed(){
        Assert.assertTrue(movieDetailsPage.movieOverviewEl().isDisplayed());
    }

    @And("the similar movies list should be visible on movie details page")
    public void similarMovieSection(){
        Assert.assertTrue(movieDetailsPage.moreLikeMovieSection().size()>0);
    }

    @And("the genre list should be visible on movie details page")
    public void genreDisplayed(){
        Assert.assertTrue(movieDetailsPage.genreListEl().size()>0);
    }

    @And("the available audios should be visible on movie details page")
    public void audioAvailableDisplayed(){
        Assert.assertTrue(movieDetailsPage.audioEl().size()>0);
    }

    @And("the rating count should be visible on movie details page")
    public void ratingCountDisplayed(){
        Assert.assertTrue(movieDetailsPage.getRatingCount().isDisplayed());
    }

    @And("the rating average should be visible on movie details page")
    public void ratingAvgDisplayed(){
        Assert.assertTrue(movieDetailsPage.getRatingAvg().isDisplayed());
    }

    @And("the budget should be visible on movie details page")
    public void budgetDisplayed(){
        Assert.assertTrue(movieDetailsPage.getBudgetEl().isDisplayed());
    }

    @And("the release date should be visible on movie details page")
    public void releaseDateDisplayed(){
        Assert.assertTrue(movieDetailsPage.getReleaseDate().isDisplayed());
    }

    @And("the play button should be visible on movie details page")
    public void playButtonDisplayed(){
        Assert.assertTrue(movieDetailsPage.getplayButton().isDisplayed());
    }


    @And("the movie watch time should be visible on movie details page")
    public void movieWatchTimeElement(){
        Assert.assertTrue(movieDetailsPage.movieWatchTimeEl().isDisplayed(),"watch movie not visible");
    }
}