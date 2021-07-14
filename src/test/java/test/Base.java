package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;


public class Base {
    public ChromeDriver driver = null;

    @BeforeMethod
    public void beforeMethod() {
        //WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.fahasa.com/");

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}