package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver getDriver(Browsers browsers) {
        switch(browsers){
            case CHROME: default:
                return getChromeDriver();
            case FIREFOX:
                return getFireFoxDriver();
            case IE:
                return getInternetExplorerDriver();
        }
    }

    private static WebDriver getChromeDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("start-maximized", "ignore-certificate-errors");
        //options.addArguments("ignore-certificate-errors");
        //options.addArguments("chrome.switches", "--verbose");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(capabilities);
    }

    private static WebDriver getFireFoxDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(capabilities);
    }

    private static WebDriver getInternetExplorerDriver() {
        InternetExplorerDriverManager.getInstance().setup();
        return new InternetExplorerDriver();
    }

    public enum Browsers {
        CHROME,
        FIREFOX,
        IE
    }
}