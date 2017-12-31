package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver getDriver(String browser){
        switch(browser.toLowerCase()){
            case "firefox":
                driver = getFireFoxDriver();
                break;
            case "chrome":
                driver = getChromeDriver();
                break;
            default:
                driver = getChromeDriver();
                break;
        }
        return null;
    }

    private static WebDriver getChromeDriver() {
        ChromeDriverManager.getInstance().setup();
        return driver = new ChromeDriver();
    }

    private static WebDriver getFireFoxDriver() {
        FirefoxDriverManager.getInstance().setup();
        return driver = new FirefoxDriver();
    }
}
