package ge.automation.hooks;

import ge.automation.driver.DriverManager;
import ge.automation.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.read("wait"))));
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
