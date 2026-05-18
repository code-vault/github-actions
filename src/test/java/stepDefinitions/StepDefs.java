package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class StepDefs {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("User is on loginPage")
    public void user_is_on_login_page() {
        this.driver.get("https://www.saucedemo.com/");
    }

    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(password);
    }

    @And("User clicks login button")
    public void user_clicks_login_button() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
    }

    @Then("User should see homepage")
    public void userShouldSeeHomepage() {
        String pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo"))).getText();
        Assert.assertEquals(pageTitle, "Swag Labs");
    }
}
