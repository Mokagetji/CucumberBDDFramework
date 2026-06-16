package Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver driver;

    public static WebDriver startBrowser(String browserChoice, String url) {

        if (browserChoice.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless"); //the pipeline should always run in a headless mode
            edgeOptions.addArguments("--window-size=1920,1080");
            edgeOptions.addArguments("--disable-gpu");

            driver = new EdgeDriver(edgeOptions);
        }
        else if (browserChoice.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless"); //the pipeline should always run in a headless mode
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--disable-gpu");

            driver = new ChromeDriver(chromeOptions);
        }

        else {
            throw new RuntimeException("Unsupported browser: " + browserChoice);
        }
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get(url);
        return driver;
    }
}
