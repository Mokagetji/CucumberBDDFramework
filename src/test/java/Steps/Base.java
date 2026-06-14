package Steps;

import Pages.*;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Utils.BrowserFactory.driver;
import static Utils.BrowserFactory.startBrowser;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();// creating an instance of a browser factory

    final WebDriver driver = browserFactory.startBrowser("edge",
            "https://ndosisimplifiedautomation.vercel.app/");

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
    AdminDashboardPage adminDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
    CreateNewGroupPage createNewGroupPage = PageFactory.initElements(driver, CreateNewGroupPage.class);
}
