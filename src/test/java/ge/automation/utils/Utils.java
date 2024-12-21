package ge.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    private WebDriver driver;


    public Utils(WebDriver driver) {
        this.driver = driver;
    }


    public void clearAndSendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }


}
