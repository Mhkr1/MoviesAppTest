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

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    MovieDetailsPage movieDetailsPage;
    HeaderSection headerSection;
    PopularPage popularPage;
    WebDriverWait wait;
    String expected="";
    String actual="";


    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        movieDetailsPage=new MovieDetailsPage(driver);
        headerSection=new HeaderSection(driver);
        popularPage=new PopularPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage.loginToApplication("rahul","rahul@2021");
        expected="https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expected));
    }

    @After
    public void closeUp(){
        driver.quit();
    }


    @Given("I am on the popular page of movie details page")
    public void iAmOnPopularPageOfMovieDetailsPage(){
        headerSection.popularLinkText().click();
        expected="https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expected));
    }

    @When("I click on one movie in popular page of movie details page")
    public void iClickOnMovieOfMovieDetailsPage(){
        popularPage.moviesOnPopularPage().get(0).click();
    }

    @Then("I should be navigate to that movie page of movie details page")
    public void navigateToMoviePageOnMovieDetailsPage(){
        Assert.assertTrue(movieDetailsPage.movieTitleEl().isDisplayed());
    }

    @And("the movie title should be visible on movie details page")
    public void movieTitleDisplayed(){
        Assert.assertTrue(movieDetailsPage.movieTitleEl().isDisplayed());
    }

    @And("the sensor rating should be visible on movie details page")
    public void sensorRatingVisibility(){
        Assert.assertTrue(movieDetailsPage.sensroRatingEl().isDisplayed());
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


    @When("I click one movie of popular page")
    public void clickOnOneMovieInPopularSection(){
        popularPage.moviesOnPopularPage().get(0).click();
    }

    @When("I click on one trending movie for movies details page")
    public void clickFirstTrendingMovieForMovieDetalsPage(){
        homePage.trendingMoviesVisibility(0).click();
    }

    @When("I click on one originals movie for movies details page")
    public void clickFirstOriginalsMovieForMovieDetailsPage(){
        homePage.originalsMovieVisibility(0).click();
    }


    @And("the movie watch time should be visible on movie details page")
    public void movieWatchTimeElement(){
        Assert.assertTrue(movieDetailsPage.movieWatchTimeEl().isDisplayed(),"watch movie not visible");
    }
}
