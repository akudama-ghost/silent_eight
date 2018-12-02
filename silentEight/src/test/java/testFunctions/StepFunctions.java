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

    public WebElement getElementByXpath(WebDriver driver, String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    public void clickElementWithWait(WebDriver driver, PageObject po, int times) {
        int i = 0;
        while (i < times) {
            i++;
            try {
                click(driver, po.getXpath());
                break;
            } catch (Exception e) {
                System.out.println("Failed to open first from list decision tree page - try " + i + " of " + times);
            }
            hardCodedWait(1);
        }
    }
}
