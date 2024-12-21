package ge.automation.steps;

import ge.automation.driver.DriverManager;
import ge.automation.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SauceSteps {

    WebDriver driver;
    Utils utils;

    public SauceSteps() {
        driver = DriverManager.getDriver();
        utils = new Utils(driver);


    }


    @Given("the browser is launched and {string} login page is opened")
    public void theBrowserIsLaunchedAndLoginPageIsOpened(String baseUrl) {
        driver.get(baseUrl);
    }

    @When("the user enters valid username {string} and password {string}")
    public void theUserEntersValidUsernameAndPassword(String username, String password) {
        WebElement usernameElement = driver.findElement(By.id("user-name"));
        WebElement passwordElement = driver.findElement(By.id("password"));
        utils.clearAndSendKeys(usernameElement, username);
        utils.clearAndSendKeys(passwordElement, password);


    }


    @And("clicks on login button")
    public void clicksOnLoginButton() {
        WebElement loginButtonElement = driver.findElement(By.id("login-button"));
        loginButtonElement.click();

    }


    @Then("the user should be redirected to the Products page {string}")
    public void theUserShouldBeRedirectedToTheProductsPage(String expectedUrl) {
        String url = driver.getCurrentUrl();

        Assert.assertEquals(url, expectedUrl);

    }

    @And("the user adds {string} to the cart")
    public void theUserAddsToTheCart(String product) {


        product = product.toLowerCase().replace(" ", "-");

        String productXpath = "//button[@id='add-to-cart-" + product + "']";
        driver.findElement(By.xpath(productXpath)).click();

    }

    @And("navigate to the cart page")
    public void navigateToTheCartPage() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("the cart should contains {string}")
    public void theCartShouldContains(String product) {

        WebElement findProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        findProduct.getText();

        Assert.assertEquals(findProduct.getText(), product);


    }

    @And("the user sorts the products by {string}")
    public void theUserSortsTheProductsBy(String sortingOption) {
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText(sortingOption);
    }

    @Then("the first product should be {string}")
    public void theFirstProductShouldBe(String expectedFirstProduct) {


        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]"));
        Assert.assertEquals(firstProduct.getText(), expectedFirstProduct);
    }
}