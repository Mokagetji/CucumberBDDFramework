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

    @FindBy(id = "login-email")
    WebElement emailTextBox_id;

    @FindBy(id = "login-password")
    WebElement passwordTextBox_id;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton_id;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(loginPageHeading_xpath));
        loginPageHeading_xpath.isDisplayed();
    }

    public void enterEmail(String email){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(emailTextBox_id));
        emailTextBox_id.sendKeys(email);
    }

    public void enterPassword(String password){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(passwordTextBox_id));
        passwordTextBox_id.sendKeys(password);
    }

    public void clickLoginSubmitButton(){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(loginSubmitButton_id));
        loginSubmitButton_id.click();
    }
}
