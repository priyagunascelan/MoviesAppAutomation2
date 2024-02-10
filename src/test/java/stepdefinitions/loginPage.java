package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class loginPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I am on the login page")
    public void iAmonthePage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }
    @When("I check Logo is display")
    public void  checkLogo(){
        WebElement logoEl = driver.findElement(By.className("login-website-logo"));
        boolean logoCheck = logoEl.isDisplayed();
        Assert.assertTrue(logoCheck);
    }
    @When("I check Heading Text Login")
    public void checkLogin(){
        WebElement loginEl = driver.findElement(By.className("sign-in-heading"));
        String loginCheck = loginEl.getText();
        Assert.assertEquals(loginCheck,"Login");
    }
    @When("I check username label text")
    public void checkUsername(){
        WebElement usernameEl = driver.findElement(By.xpath("//label[@for ='usernameInput']"));
        String usernameCheck = usernameEl.getText();
        Assert.assertEquals(usernameCheck,"USERNAME");
    }
    @And("I check password label text")
    public void checkPassword(){
        WebElement passEl = driver.findElement(By.xpath("//label[@for ='passwordInput']"));
        String passCheck = passEl.getText();
        Assert.assertEquals(passCheck,"PASSWORD");
    }
    @Then("I check login button")
    public void checkLoginbutton(){
        WebElement loginButtonEl = driver.findElement(By.className("login-button"));
        String loginButtonCheck = loginButtonEl.getText();
        Assert.assertEquals(loginButtonCheck,"Login");
    }
    @When("I click on the login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.className("login-button")).click();
    }

    @When("I enter a valid PIN")
    public void iEnterValidPin() {
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @When("I enter a valid User ID")
    public void iEnterValidUserId() {
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
    }

    @And("I enter an invalid PIN")
    public void iEnterInvalidPin() {
        driver.findElement(By.id("passwordInput")).sendKeys("rahul");
    }

    @Then("an error message '*Username or password is invalid' should be visible")
    public void verifyInvalidPinErrorText() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(actualText, "*Username or password is invalid");
    }

    @Then("an error message '*username and password didn't match' should be visible")
    public void verifyInvalidInputsErrorText() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(actualText, "*username and password didn't match");
    }
    @And("I enter an invalid User Name")
    public void enterInvalidName(){
        WebElement Invalidusername = driver.findElement(By.id("usernameInput"));
        Invalidusername.sendKeys("harish");
    }
    @Then("an error username invalid message '*Username or password is invalid' should be visible")
    public void verifyInvalidUserNameErrorText() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(actualText, "*Username or password is invalid");
    }
    @Then("an error both invalid message '*Username or password is invalid' should be visible")
    public void verifyInvalidBothText() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message"))).getText();
        Assert.assertEquals(actualText, "*invalid username");
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomePage() {
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);
    }


}
