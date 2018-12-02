package stepsdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testFunctions.StepFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static pageObjects.SilentEightDecisionTrees.LIST_OF_DECISION_TREES;
import static pageObjects.SilentEightLoginPage.*;
import static pageObjects.SilentEightSingleDecisionTree.BUTTON_EDIT_ASSIGNMENTS;
import static pageObjects.SilentEightSingleDecisionTree.LIST_OF_DEACTIVATE_BUTTONS;

public class StepsDef {

    private static WebDriver driver;

    private StepFunctions sf = new StepFunctions();

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


    @When("^Login$")
    public void login() {
        sf.sendString(driver, INPUT_LOGIN, System.getProperty("username"));
        sf.sendString(driver, INPUT_PASSWORD, System.getProperty("password"));
        sf.click(driver, INPUT_SUBMIT);
    }

    @And("^Open first available decision tree for (\\d+) times$")
    public void openFirstAvailableDecisionTreeForTimes(int times) {
        List<WebElement> listOfTrees = sf.getListOfElementsByXpath(driver, LIST_OF_DECISION_TREES.getXpath());
        Assert.assertTrue("There is no decision trees to open", listOfTrees.size() > 0);
        int i = 0;
        while (i < times) {
            i++;
            try {
                sf.click(driver, LIST_OF_DECISION_TREES.getXpath());
                break;
            } catch (Exception e) {
                System.out.println("Failed to open first from list decision tree page - try " + i + " of " + times);
            }
            sf.hardCodedWait(1);
        }
    }

    @And("^edit assignments$")
    public void editAssignments() {
        sf.click(driver, BUTTON_EDIT_ASSIGNMENTS);
    }

    @Then("^count deactivate buttons$")
    public void countDeactivateButtons() {
        List<WebElement> listOfButtons = sf.getListOfElementsByXpath(driver, LIST_OF_DEACTIVATE_BUTTONS.getXpath());
        Assert.assertTrue("There is no deactivate buttons", listOfButtons.size() > 0);
        System.out.println(listOfButtons.size());
    }
}
