package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    public void enterGroupName(String groupName){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(groupName_xpath));
        groupName_xpath.sendKeys(groupName);
    }

    public void enterGroupDescription(String groupDescription){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(groupDescription_xpath));
        groupDescription_xpath.sendKeys(groupDescription);
    }

    public void enterGroupYear(String year){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(groupYear_xpath));
        groupYear_xpath.clear();
        groupYear_xpath.sendKeys(year);
    }

    public void enterGroupMaximumCapacity(String maxCapacity){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(groupMaximumCapacity_xpath));
        groupMaximumCapacity_xpath.sendKeys(maxCapacity);
    }

    public void enterGroupStartDate(String startDate ){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(groupStartDate_name));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "const element = arguments[0];" +
                        "const value = arguments[1];" +
                        "const nativeInputValueSetter = Object.getOwnPropertyDescriptor(" +
                        "window.HTMLInputElement.prototype, 'value').set;" +
                        "nativeInputValueSetter.call(element, value);" +
                        "element.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "element.dispatchEvent(new Event('change', { bubbles: true }));",
                groupStartDate_name,
                startDate
        );

    }

    public void enterGroupEndDate(String endDate ){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(groupEndDate_name));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "const element = arguments[0];" +
                        "const value = arguments[1];" +
                        "const nativeInputValueSetter = Object.getOwnPropertyDescriptor(" +
                        "window.HTMLInputElement.prototype, 'value').set;" +
                        "nativeInputValueSetter.call(element, value);" +
                        "element.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "element.dispatchEvent(new Event('change', { bubbles: true }));",
                groupEndDate_name,
                endDate
        );
    }

    public void clickCreateGroupButton(){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(createGroupButton_xpath));
        createGroupButton_xpath.click();
    }

    public void verifyGroupCreatedMessageIsDisplayed(){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(visibilityOf(groupCreatedMessage_xpath));
        groupCreatedMessage_xpath.isDisplayed();
    }


}
