package Pages;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CreateNewGroupPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='name']")
    WebElement groupName_xpath;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement groupDescription_xpath;

    @FindBy(name = "year")
    WebElement groupYear_xpath;

    @FindBy(xpath = "//input[@name='maxCapacity']" )
    WebElement groupMaximumCapacity_xpath;

    @FindBy(name = "startDate")
    WebElement groupStartDate_name;

    @FindBy(name = "endDate")
    WebElement groupEndDate_name;

    @FindBy(xpath = "//button[contains(.,'Create Group')]")
    WebElement createGroupButton_xpath;

    @FindBy(xpath = "//div[contains(text(),'Group created successfully!')]")
    WebElement groupCreatedMessage_xpath;

    public CreateNewGroupPage(WebDriver driver){
        this.driver = driver;
    }

    public void EnterGroupName(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(groupName_xpath));
        groupName_xpath.sendKeys();
    }


}
