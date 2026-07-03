package Bazar.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass3 {

    public WebDriver driver;
    public WebDriverWait wait;

    public BaseClass3(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Wait Until Clickable
    public WebElement waitForElementClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait Until Visible
    public WebElement waitForElementVisible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait Until Present
    public WebElement waitForElementPresent(By locator) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Click
    public void click(By locator) {

        waitForElementClickable(locator).click();
    }

    // Type
    public void type(By locator, String text) {

        waitForElementVisible(locator).sendKeys(text);
    }

    // Clear And Type
    public void clearAndType(By locator, String text) {

        WebElement element = waitForElementVisible(locator);

        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    // Get Text
    public String getText(By locator) {

        return waitForElementVisible(locator).getText().trim();
    }

    // Get Attribute
    public String getAttribute(By locator, String attribute) {

        return waitForElementVisible(locator).getAttribute(attribute);
    }

    // Get Element
    public WebElement getElement(By locator) {

        return waitForElementVisible(locator);
    }

    // Is Displayed
    public boolean isDisplayed(By locator) {

        return waitForElementVisible(locator).isDisplayed();
    }

    // Is Present
    public boolean isPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }

    // Is Enabled
    public boolean isEnabled(By locator) {

        return waitForElementVisible(locator).isEnabled();
    }

    // Move To Element
    public void moveToElement(By locator) {

        Actions action = new Actions(driver);

        action.moveToElement(waitForElementVisible(locator)).perform();
    }

    // Hover And Click
    public void hoverAndClick(By locator) {

        Actions action = new Actions(driver);

        action.moveToElement(waitForElementVisible(locator))
              .click()
              .perform();
    }

    // Click Anywhere
    public void clickElsewhere() {

        Actions action = new Actions(driver);

        action.moveByOffset(20, 20)
              .click()
              .perform();
    }

    // Select By Visible Text
    public void selectByVisibleText(By locator, String text) {

        Select select = new Select(waitForElementVisible(locator));

        select.selectByVisibleText(text);
    }

    // Select By Value
    public void selectByValue(By locator, String value) {

        Select select = new Select(waitForElementVisible(locator));

        select.selectByValue(value);
    }

    // Select By Index
    public void selectByIndex(By locator, int index) {

        Select select = new Select(waitForElementVisible(locator));

        select.selectByIndex(index);
    }
}
