package yandextest;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandextest.pageobjects.BasicPageObject;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Statics {
    private static EventFiringWebDriver driver = null;
    private static WebDriverWait wait = new WebDriverWait(getDriver(), Config.waitUntilSeconds);
    private static JavascriptExecutor jsExecutor = (JavascriptExecutor)getDriver();

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "selenium-server" + File.separator + getOS()
                    + File.separator + "chromedriver");
            WebDriver chromeDriver = new ChromeDriver();
            chromeDriver.manage().timeouts().implicitlyWait(Config.implicitlyWaitSeconds, TimeUnit.SECONDS);
            chromeDriver.manage().window().maximize();
            driver = new EventFiringWebDriver(chromeDriver);
            driver.register(new DriverListener());
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }

    public static String getOS() {
        if(SystemUtils.IS_OS_MAC_OSX) return "mac";
        if(SystemUtils.IS_OS_WINDOWS) return "win";
        if(SystemUtils.IS_OS_LINUX) return "linux";
        return SystemUtils.OS_NAME;
    }

    public static JavascriptExecutor getJsExecutor() {
        return jsExecutor;
    }

    public static <T extends BasicPageObject> T pageObject(Class<T> clazz) {
        return PageFactory.initElements(getDriver(), clazz);
    }

    public static WebElement shouldBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void shouldNotBeExists(WebElement element) {
        wait.until(CustomConditions.invisibilityOf(element));
    }

    public static void waitUntilJSLoading() throws InterruptedException {
        wait.until(CustomConditions.jsLoading());
    }

    public static void clearLocaleStorage() {
        jsExecutor.executeScript("window.localStorage.clear();");
    }
}
