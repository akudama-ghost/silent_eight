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
import pageObjects.DynamicObjects;
import testFunctions.StepFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static pageObjects.SilentEightDecisionTrees.*;
import static pageObjects.SilentEightLoginPage.*;
import static pageObjects.SilentEightSingleDecisionTree.*;

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
        List<WebElement> listOfTrees = sf.getListOfElementsByXpath(driver, LIST_OF_AVAILABLE_DECISION_TREES.getXpath());
        Assert.assertTrue("There is no available decision trees to open", listOfTrees.size() > 0);
        sf.clickElementWithWait(driver, LIST_OF_AVAILABLE_DECISION_TREES, times);
    }

    @And("^Open edit assignments window$")
    public void editAssignments() {
        sf.click(driver, BUTTON_EDIT_ASSIGNMENTS);
        sf.hardCodedWait(1);
    }

    @And("^assign \"([^\"]*)\" as ([^\"]*)")
    public void assignAsAvailable(String key, String batch) {
        Assert.assertTrue("No such an element on the list", sf.getListOfElementsByXpath(driver, DynamicObjects.getXPathOfEditAssignmentsItem(key)).size() > 0);
        String currentBatch = sf.getElementByXpath(driver, DynamicObjects.getXPathOfEditAssignmentsSectionTitle(key)).getText();
        if (batch.equals("Available")) {
            if (currentBatch.equals("Assigned")) {
                sf.click(driver, DynamicObjects.getXPathOfEditAssignmentsActionButtonForKey(key, "remove"));
            } else if (currentBatch.equals("Active")) {
                sf.click(driver, DynamicObjects.getXPathOfEditAssignmentsActionButtonForKey(key, "deactivate"));
                sf.click(driver, DynamicObjects.getXPathOfEditAssignmentsActionButtonForKey(key, "remove"));
            }
        } else if (batch.equals("Assigned")) {
            if (currentBatch.equals("Available")) {
                sf.click(driver, DynamicObjects.getXPathOfEditAssignmentsActionButtonForKey(key, "add"));
            } else if (currentBatch.equals("Active")) {
                sf.click(driver, DynamicObjects.getXPathOfEditAssignmentsActionButtonForKey(key, "deactivate"));
            }
        } else {
            if (currentBatch.equals("Available")) {
                sf.click(driver, DynamicObjects.getXPathOfEditAssignmentsActionButtonForKey(key, "add"));
                sf.click(driver, DynamicObjects.getXPathOfEditAssignmentsActionButtonForKey(key, "activate"));
            } else if (currentBatch.equals("Assigned")) {
                sf.click(driver, DynamicObjects.getXPathOfEditAssignmentsActionButtonForKey(key, "activate"));
            }
        }
    }

    @Then("^check error message$")
    public void checkErrorMessage() {
        sf.click(driver, BUTTON_SAVE_EDIT_ASSIGNMENTS);

        //Expected results view is attached in file: src\test\resources\Capture.PNG
        // Test expects to met an error, because it tries to activate items already activated.

        Assert.assertTrue("Something went not as expected, please, check this test", sf.getListOfElementsByXpath(driver, ERROR_MESSAGE_AFTER_EDIT_ASSIGNMENTS.getXpath()).size() > 0);
    }

    @And("^copy decision tree in use if there is none in available section$")
    public void copyDecisionTreeInUseIfThereIsNoneInAvailableSection() {
        List<WebElement> listOfTrees = sf.getListOfElementsByXpath(driver, LIST_OF_DECISION_TREES_IN_USE.getXpath());
        Assert.assertTrue("There is no decision trees in use to copy", listOfTrees.size() > 0);
        if (sf.getListOfElementsByXpath(driver, LIST_OF_AVAILABLE_DECISION_TREES.getXpath()).size() == 0) {
            sf.clickElementWithWait(driver, COPY_DECISION_TREE_IN_USE, 5);
            String name = sf.getElementByXpath(driver, NAME_OF_DECISION_TREE_TO_COPY.getXpath()).getText();
            name = name.substring(1, name.length() - 2) + " - copy";
            sf.sendString(driver, NAME_OF_NEW_COPY_OF_DECISION_TREE, name);
            sf.click(driver, SUBMIT_COPYING_PROCESS_BUTTON);
        }

    }
}
