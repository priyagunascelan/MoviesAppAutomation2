package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class accountPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @When("I Test all the UI elements present on the Account page")
    public void checkUIElementinAccount(){
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/account"));
        List<WebElement> getUIEl = driver.findElements(By.xpath("//ul/li"));
        Assert.assertEquals(getUIEl.size(),2);
    }
    @Then("I Test the Logout functionality")
    public void checkLogout(){
        WebElement logoutEl = driver.findElement(By.className("logout-button"));
        logoutEl.click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/login"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://qamoviesapp.ccbp.tech/login");
    }
}
