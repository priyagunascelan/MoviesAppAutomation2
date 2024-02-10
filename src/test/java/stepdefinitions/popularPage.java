package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class popularPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Then("I Test whether the movies are displayed")
    public void clickPopularpage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search-movies-container >li")));
        WebElement clickMovie = driver.findElement(By.xpath("//img[@alt ='Venom']"));
        clickMovie.click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f"));
        String getMovieUrl = driver.getCurrentUrl();
        Assert.assertEquals(getMovieUrl,"https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f");
    }
}
