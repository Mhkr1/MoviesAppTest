package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.WeakHashMap;

public class PopularPage {

    @FindBy(xpath = "//li[@class='movie-icon-item']/child::a")
    List<WebElement> movieVisibileOnPopularPage;


    WebDriver driver;
    WebDriverWait wait;

    public PopularPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<WebElement> moviesOnPopularPage(){
        waitForVisibilityOfElements(movieVisibileOnPopularPage);
        return movieVisibileOnPopularPage;
    }

    private void waitForVisibilityOfElements(List<WebElement> element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
}