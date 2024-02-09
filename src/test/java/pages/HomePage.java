package pages;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

import java.util.List;



public class HomePage {



    @FindBy(how= How.XPATH, using = "//h1[text()='Trending Now']")
    @CacheLookup
    WebElement firstHeadingElement;

    @FindBy(how = How.XPATH, using = "//h1[text()='Trending Now']/following-sibling::div//a")
    List<WebElement> trendingMovies;

    @FindBy(how= How.XPATH, using = "//h1[text()='Originals']")
    @CacheLookup
    WebElement secondHeadingElement;

    @FindBy(xpath = "//h1[text()='Originals']/following-sibling::div//a")
    List<WebElement> originalsMovies;

    @FindBy(className = "home-movie-play-button")
    WebElement playButtonElement;


    @FindBy(className = "contact-us-paragraph")
    WebElement contactElement;

    @FindBy(css = "svg[class$='google-icon']")
    WebElement contactUsGoogleIcon;

    @FindBy(css = "svg[class$='twitter-icon']")
    WebElement contactUsTwitterIcon;

    @FindBy(css = "svg[class$='instagram-icon']")
    WebElement contactUsInstagramIcon;

    @FindBy(css = "svg[class$='youtube-icon']")
    WebElement contactUsYoutubeIcon;

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement firstMovieHeading() {
        waitForVisibility(firstHeadingElement);
        return firstHeadingElement;
    }

    public int getTrendingMovieCount(){
        return trendingMovies.size();
    }

    public int getOriginalsMovieCount(){
        return originalsMovies.size();
    }

    public WebElement trendingMoviesVisibility(int index){
        waitForVisibility(trendingMovies.get(index));
        return trendingMovies.get(index);
    }

    public WebElement secondMovieHeading() {
        waitForVisibility(secondHeadingElement);
        return secondHeadingElement;
    }

    public WebElement originalsMovieVisibility(int index) {
        waitForVisibility(originalsMovies.get(index));
        return originalsMovies.get(index);
    }

    public WebElement playBtnEle() {
        waitForVisibility(playButtonElement);
        return playButtonElement;
    }


    public WebElement contactUsGoogleIconVisibile(){
        waitForVisibility(contactUsGoogleIcon);
        return contactUsGoogleIcon;
    }

    public WebElement contactUsTwitterIconVisibility(){
        waitForVisibility(contactUsTwitterIcon);
        return contactUsTwitterIcon;
    }

    public WebElement contactUsInstagramIcon(){
        waitForVisibility(contactUsInstagramIcon);
        return contactUsInstagramIcon;
    }

    public WebElement contactUsYoutubeIcon(){
        waitForVisibility(contactUsYoutubeIcon);
        return contactUsYoutubeIcon;
    }


    public String contactButtonEle() {
        waitForVisibility(contactElement);
        return contactElement.getText();
    }

    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}