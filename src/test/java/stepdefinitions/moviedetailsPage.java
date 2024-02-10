package stepdefinitions;

import io.cucumber.java.en.And;
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

public class moviedetailsPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    @When("I in the Home Page click on any Movie and test all the UI elements present in it")
    public void uiElpresentInHome(){
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        WebElement clickAMovie = driver.findElement(By.xpath("((//div[@class = 'slick-track'])[1]/div)[3]"));
        clickAMovie.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class ='movie-title']")));
        List<WebElement> allUiEl = driver.findElements(By.xpath("//ul"));
        Assert.assertEquals(allUiEl.size(),3);
    }
    @Then("I in the Popular Page click on any Movie and test all the UI elements present in it")
    public void uiInPopular(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f"));
        List<WebElement> allUiEl = driver.findElements(By.xpath("//ul"));
        Assert.assertEquals(allUiEl.size(),3);
    }
}
