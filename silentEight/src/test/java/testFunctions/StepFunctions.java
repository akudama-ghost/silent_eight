package testFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.PageObject;

import java.util.List;

public class StepFunctions {

    public void sendString(WebDriver driver, PageObject po, String fraze) {
        driver.findElement(By.xpath(po.getXpath())).sendKeys(fraze);
    }

    public void click(WebDriver driver, PageObject po) {
        driver.findElement(By.xpath(po.getXpath())).click();
    }

    public void click(WebDriver driver, String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }

    public List<WebElement> getListOfElementsByXpath(WebDriver driver, String xPath) {
        return driver.findElements(By.xpath(xPath));
    }

    public void hardCodedWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
