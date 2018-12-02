package stepsdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepsDef {

    private static WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:/program_files/another_resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }

    @Given("^Open browser and go to \"([^\"]*)\"$")
    public void openBrowserAndGoTo(String url) {
        driver.get(url);
    }


    @When("^search for \"([^\"]*)\"$")
    public void searchFor(String fraze) {
        driver.findElement(By.xpath("//input[@title='Szukaj']")).sendKeys(fraze);
        driver.findElement(By.xpath("//input[@title='Szukaj']")).sendKeys(Keys.RETURN);
    }

    @Then("^check if results are as expected$")
    public void checkIfResultsAreAsExpected() {
        Assert.assertTrue("Well, that's bad", driver.findElements(By.xpath("//h3[text()='Elo – Wikipedia, wolna encyklopedia']")).size() > 0);
    }
}
