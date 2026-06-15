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
        EdgeOptions edgeOptions = new EdgeOptions();


        if (browserChoice.equalsIgnoreCase("edge")) {
            edgeOptions.addArguments("--headless"); //the pipeline should always run in a headless mode
            driver = new EdgeDriver(edgeOptions);
        }
        else if (browserChoice.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browserChoice.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

        else {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get(url);
        return driver;
    }
}
