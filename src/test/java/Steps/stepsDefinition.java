package Steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class stepsDefinition extends Base {

    @Given("i am ndosi automation homepage")
    public void i_am_ndosi_automation_homepage() {
    homePage.verifyUserIsOnHomePage();

    }

    @And("i click login button")
    public void i_click_login_button() {
    homePage.clickLoginButton();

    }

    @When("i am on the login page")
    public void i_am_on_the_login_page() {
   loginPage.verifyLoginPage();

    }

    @And("i enter admin email (.*)$")
    public void i_enter_admin_email(String email) {
    loginPage.enterEmail(email);

    }

    @And("i enter admin password (.*)$")
    public void i_enter_admin_password(String password) {
    loginPage.enterPassword(password);

    }

    @And("i click login submit button")
    public void i_click_login_submit_button() {
    loginPage.clickLoginSubmitButton();


    }

    @Then("i should be logged in successfully as admin")
    public void i_should_be_logged_in_successfully_as_admin() {
    dashboardPage.verifyUserIsLoggedInSuccessfully();

    }

    @When("i click on the profile button")
    public void i_click_on_the_profile_button() {
    dashboardPage.clickProfileButton();

    }

    @And("i click admin panel")
    public void i_click_admin_panel() throws InterruptedException {
        driver.findElement(By.xpath("//button[.//span[contains(text(),'Admin')]]")).click();
        Thread.sleep(3000);
    }

    @Then("i should be redirected to admin dashboard")
    public void i_should_be_redirected_to_admin_dashboard() {
        assert driver.findElement(By.xpath("//div[@class='admin-dashboard']")).isDisplayed();
    }

    @When("i click groups")
    public void i_click_groups() throws InterruptedException {
        driver.findElement(By.xpath("//nav//button[contains(.,'Groups')]")).click();
        Thread.sleep(3000);

    }

    @And("i click create new group button")
    public void i_click_create_new_group_button() {
        driver.findElement(By.xpath("//button[contains(.,'Create New Group')]")).click();

    }

    @And("i enter the group name (.*)$")
    public void i_enter_the_group_name(String groupName) {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(groupName);
    }

    @And("i enter the group description (.*)$")
    public void i_enter_the_group_description(String groupDescription) {
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(groupDescription);
    }

    @And("i enter the year (.*)$")
    public void i_enter_the_year(String year) {
        driver.findElement(By.name("year")).clear();
        driver.findElement(By.name("year")).sendKeys(year);
    }

    @And("i enter the max capacity (.*)$")
    public void i_enter_the_max_capacity(String maxCapacity) {
        driver.findElement(By.xpath("//input[@name='maxCapacity']")).sendKeys(maxCapacity);

    }

    @And("i enter the start date (.*)$")
    public void i_enter_the_start_date(String startDate) {
        String[] parts = startDate.split("/");

        driver.findElement(By.name("startDate")).click();

        driver.findElement(By.name("startDate"))
                .sendKeys(
                        parts[0],
                        Keys.ARROW_RIGHT,
                        parts[1],
                        Keys.ARROW_RIGHT,
                        parts[2]
                );
    }

    @And("i enter the end date (.*)$")
    public void i_enter_the_end_date(String endDate) {
        String[] parts = endDate.split("/");

        driver.findElement(By.name("endDate")).click();

        driver.findElement(By.name("endDate"))
                .sendKeys(
                        parts[0],
                        Keys.ARROW_RIGHT,
                        parts[1],
                        Keys.ARROW_RIGHT,
                        parts[2]
                );

    }

    @And("i click create button")
    public void i_click_create_button() {
        driver.findElement(By.xpath("//button[contains(.,'Create Group')]")).click();
    }

    @Then("the group should be created")
    public void the_group_should_be_created() throws InterruptedException {
        assert driver.findElement(By.xpath("//div[contains(text(),'Group created successfully!')]")).isDisplayed();
        Thread.sleep(2000);
    }

    @When("i click back to website button")
    public void i_click_back_to_website_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'← Back to Website')]")).click();
        Thread.sleep(2000);

    }

    @And("i click logout button")
    public void i_click_logout_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[.//span[text()='Logout']]")).click();
        Thread.sleep(2000);
    }

    @And("i click OK to confirm logout")
    public void i_click_OK_to_confirm_logout() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

    }

    @Then("i should be logged out successfully")
    public void i_should_be_logged_out_successfully() throws InterruptedException {
        assert driver.findElement(By.id("app-main-content")).isDisplayed();
        Thread.sleep(2000);
    }

    @And("i click sign up here hyperlink")
    public void i_click_sign_up_here_hyperlink() throws InterruptedException {
        driver.findElement(By.id("signup-toggle")).click();
        Thread.sleep(2000);
    }

    @And("i click select your group button")
    public void i_click_select_your_group_button() throws InterruptedException {
        driver.findElement(By.id("register-group")).click();
        Thread.sleep(3000);
    }

    @Then("the created group (.*) should exist in the group dropdown")
    public void the_created_group_should_exist_in_the_group_dropdown(String groupName) throws InterruptedException {
        assert driver.findElement(By.xpath("//option[contains(text(),'" + groupName + "')]")).isDisplayed();
        Thread.sleep(2000);
    }
}