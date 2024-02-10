package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class searchPage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @And("I Test the Search functionality by searching with some movie names")
    public void clickSearch()  {
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        WebElement searchEl = driver.findElement(By.xpath("(//div[@class = 'search-account-container'])/*[1]"));
        searchEl.click();
    }
    @And("I enter the Movie name in search Icon")
    public void enterMovie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        WebElement enterMovie = driver.findElement(By.id("search"));
        enterMovie.sendKeys("ca");
        WebElement searchIconClick = driver.findElement(By.className("search-button"));
        searchIconClick.click();
    }
    @Then("I count the number of movies display")
    public void countMoviesinSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-movies-container")));
        List<WebElement> countMovies = driver.findElements(By.xpath("//ul[@class ='search-movies-container']/*"));
        Assert.assertEquals(countMovies.size(),3);
    }
    @Then("I clicking movie in search results, redirect to the movie details page")
    public void moviedetails(){
        WebElement clickSearchMovie = driver.findElement(By.xpath("(//ul[@class ='search-movies-container']/*)[2]"));
        clickSearchMovie.click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/movies/b2872586-3e64-4fc0-a244-f21c2e62fb37"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://qamoviesapp.ccbp.tech/movies/b2872586-3e64-4fc0-a244-f21c2e62fb37");
    }
}
