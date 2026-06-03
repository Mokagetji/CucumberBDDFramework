package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DashboardPage {

    WebDriver driver;

    @FindBy(id = "app-main-content")
    WebElement dashboardPage_id;

    @FindBy(xpath = "//button[contains(@class,'user-pill')]")
    WebElement menuButton_xpath;

    @FindBy(xpath = "//button[.//span[contains(text(),'Admin')]]")
    WebElement adminPanel_xpath;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyUserIsLoggedInSuccessfully(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(dashboardPage_id));
        dashboardPage_id.isDisplayed();
    }

    public void clickMenuButton(){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(menuButton_xpath));
        menuButton_xpath.click();
    }

    public void clickAdminPanel(){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(adminPanel_xpath));
        adminPanel_xpath.click();
    }
}
