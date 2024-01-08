package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    @FindBy(className = "search-input-field")
    WebElement searchInputField;

    @FindBy(className = "search-button")
    WebElement searchButton;

    @FindBy(className = "link-item")
    List<WebElement> searchMoviesList;

    @FindBy(className = "not-found-search-paragraph")
    WebElement notFoundMessage;


    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement enterMovieName(){
        waitForVisibility(searchInputField);
        return searchInputField;
    }

    public WebElement clickSearchButton(){
        waitForVisibility(searchButton);
        return searchButton;
    }

    public List<WebElement> moviesListDisplayed(){
        waitForVisibility(searchMoviesList);
        return searchMoviesList;
    }

    public WebElement invalidInputMessageOnSearchPage(){
        waitForVisibility(notFoundMessage);
        return notFoundMessage;
    }


    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForVisibility(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }


}