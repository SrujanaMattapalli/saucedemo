package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Additional recommended options for stability
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}