package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "overview-section")
    WebElement homePage_id;

    @FindBy(xpath = "//button[@class='user-pill']")
    WebElement loginButton_xpath;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyUserIsOnHomePage(){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(homePage_id));
        homePage_id.isDisplayed();
    }

    public void clickLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loginButton_xpath));
        loginButton_xpath.click();

    }
}
