package factories;

import data.BrowserData;
import exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory implements IFactory {

    private String browserName = System.getProperty("browser.name", "chrome");

    @Override
    public WebDriver createDriver() throws BrowserNotSupportedException{
        switch (BrowserData.valueOf(browserName.toUpperCase())) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                return new ChromeDriver(chromeOptions);
            case EDGE:
                return new EdgeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new BrowserNotSupportedException(browserName);
        }

    }
}
