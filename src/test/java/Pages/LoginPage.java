package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//main[@id='app-main-content']")
    WebElement loginPageHeading_xpath;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loginPageHeading_xpath));
        loginPageHeading_xpath.isDisplayed();

    }
}
