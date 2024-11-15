package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductPage;
import utils.DriverManager;
import utils.ConfigReader;

public class SauceDemoStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Given("user navigates to SauceDemo login page")
    public void user_navigates_to_SauceDemo_login_page() {
        driver.get(ConfigReader.getProperty("url"));
        Assert.assertTrue("login page not displayed", loginPage.isLoginPageDisplayed());
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        loginPage.loginToApplication(username, password);

        Assert.assertTrue("Product page not displayed", productPage.isProductPageDisplayed());

    }

    @And("user selects the highest priced item")
    public void user_selects_the_highest_priced_item() {
        productPage.findHighestPricedItem();
    }

    @Then("user adds the selected item to the cart")
    public void user_adds_the_selected_item_to_the_cart() {
        productPage.addHighestPricedItemToCart();
        Assert.assertTrue("Product not added to the cart", productPage.isAddToCartConfirmationDisplayed());
    }

    @And("user closes the browser")
    public void user_closes_the_browser() {
        driver.quit();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
