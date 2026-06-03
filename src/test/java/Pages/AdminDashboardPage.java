package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AdminDashboardPage {

     WebDriver driver;

     @FindBy(xpath = "//div[@class='admin-dashboard']")
     WebElement adminDashboard_xpath;

     @FindBy(xpath = "//nav//button[contains(.,'Groups')]")
     WebElement groupsTab_xpath;

     @FindBy(xpath = "//button[contains(.,'Create New Group')]")
     WebElement createNewGroupButton_xpath;

     public AdminDashboardPage(WebDriver driver){
         this.driver = driver;
     }


     public void verifyAdminDashBoardIsDisplayed(){
         new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(adminDashboard_xpath));
         adminDashboard_xpath.isDisplayed();
     }

     public void clickGroupsTab(){
         new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(groupsTab_xpath));
         groupsTab_xpath.click();
     }

     public void clickCreateNewGroupButton(){
         new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(createNewGroupButton_xpath));
         createNewGroupButton_xpath.click();
     }






}
