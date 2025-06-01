package io.cucumber.zaidan.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

    private static Driver instance;
    private static WebDriver driver;
    public final static Integer TIMEOUT = 10;

    private Driver() {
        // Setup Edge driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        driver = new ChromeDriver(options);

        // Remove navigator.webdriver via JS
        ((JavascriptExecutor) driver).executeScript(
            "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (instance == null) {
            instance = new Driver();
        }
    }

    public static void closeDriver() {
        if( driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }

    public static void openUrl(String url) {
        if (driver == null) {
            setUpDriver();
        }
        driver.get(url);
    }
}
