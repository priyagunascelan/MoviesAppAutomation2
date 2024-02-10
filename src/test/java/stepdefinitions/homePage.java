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

public class homePage {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("I test the heading texts of each section")
    public void headingSection(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text() = 'Trending Now']")));
        WebElement moviesHead1 = driver.findElement(By.xpath("//h1[text() = 'Trending Now']"));
        Assert.assertEquals(moviesHead1.getText(),"Trending Now");
        WebElement moviesHead2 = driver.findElement(By.xpath("//h1[text() = 'Originals']"));
        Assert.assertEquals(moviesHead2.getText(),"Originals");
    }
    @When("I test whether the play button is displayed or not")
    public void playButton(){
        WebElement playButton = driver.findElement(By.xpath("//button[text() ='Play']"));
        boolean checkPlay = playButton.isDisplayed();
        Assert.assertTrue(checkPlay);
    }
    @And("I test whether the Trending Movies are displayed, in the corresponding movies sections")
    public void trendingmoviesListSection(){
        List<WebElement> TrendingmoviesList = driver.findElements(By.xpath("(//div[@class = 'slick-track'])[1]/div"));
        Assert.assertEquals(TrendingmoviesList.size(),10);
    }
    @And("I test whether the Original Movies are displayed, in the corresponding movies sections")
    public void OriginalmoviesListSection(){
        List<WebElement> originalmoviesList = driver.findElements(By.xpath("(//div[@class = 'slick-track'])[2]/div"));
        Assert.assertEquals(originalmoviesList.size(),10);
    }
    @Then("I test the Contact Us Section")
    public void contactUs(){
        List<WebElement> contact = driver.findElements(By.xpath("//div[@class = 'footer-icons-container']/child::*"));
        Assert.assertEquals(contact.size(),4);
    }
}
