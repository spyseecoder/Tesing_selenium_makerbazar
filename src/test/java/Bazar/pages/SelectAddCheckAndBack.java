package Bazar.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.constants;

public class SelectAddCheckAndBack {
	WebDriver driver;
    WebDriverWait wait;

    public SelectAddCheckAndBack(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Search
    By searchButton = By.xpath(constants.srchbtn);
    By searchBox = By.name("q");

    // Battery
    By battery = By.xpath(constants.battery);
    By batteryVariant = By.xpath(constants.batteryvar);

    // Add To Cart
    By addToCart = By.xpath(constants.addtocart);

    // Multimeter
    By multimeter = By.xpath(constants.multimeter);

    // Cart
    By cart = By.xpath(constants.cart);
    By viewCart = By.xpath(constants.vwcart);

    // Remove Multimeter (First Row)
    By removeMultimeter = By.xpath(constants.rmvmulti);

    // Home
    By home = By.xpath(constants.home);
    
 // Cart Validation

    By cartProductName = By.xpath(constants.cartproductname);

    By cartTotal = By.xpath(constants.carttotal);
// filter    
    By filterButton = By.xpath(constants.filterbtn);

    By productType = By.xpath(constants.producttype);
    
    By motor555 = By.xpath(constants.motor555);
    By productTitle = By.xpath(constants.filterproducttitle);

    public void clickSearchButton() {
        
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void searchItem(String item) {

        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(searchBox));

        box.clear();
        box.sendKeys(Keys.CONTROL + "a");
        box.sendKeys(Keys.DELETE);
        box.sendKeys(item);
        box.sendKeys(Keys.ENTER);
    }

    public void clickBattery() {
        wait.until(ExpectedConditions.elementToBeClickable(battery)).click();
    }

    public void selectVariant() {
        wait.until(ExpectedConditions.elementToBeClickable(batteryVariant)).click();
    }

    public void addItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    public void searchMultimeter() {

        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(searchBox));

        box.click();
        box.sendKeys(Keys.CONTROL + "a");
        box.sendKeys(Keys.DELETE);
        box.sendKeys("multimeter");
        box.sendKeys(Keys.ENTER);
    }

    public void clickMultimeter() {
        wait.until(ExpectedConditions.elementToBeClickable(multimeter)).click();
    }

    public void clickElsewhere() {

        new Actions(driver)
                .moveByOffset(20, 20)
                .click()
                .perform();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }

    public void viewFullCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
    }

    public void removeMultimeter() {
        wait.until(ExpectedConditions.elementToBeClickable(removeMultimeter)).click();
    }

    public void goHome() {
        wait.until(ExpectedConditions.elementToBeClickable(home)).click();
    }
    
    public String getFirstCartProductName() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductName)).getText();
    }

    public String getSecondCartProductName() {

        return driver.findElements(cartProductName).get(1).getText();
    }

    public String getCartTotal() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartTotal)).getText();
    }
    public void clickFilter() {

    	wait.until(ExpectedConditions.elementToBeClickable(filterButton)).click();
    }

    public void clickProductType() {

    	wait.until(ExpectedConditions.elementToBeClickable(productType)).click();
    }
    
    public void click555MotorFilter() {

        wait.until(ExpectedConditions.elementToBeClickable(motor555)).click();

    }
    public boolean verifyFilteredProducts() {

        List<WebElement> products = driver.findElements(productTitle);

        for (WebElement product : products) {

            String name = product.getText().toLowerCase();

            System.out.println("Product Found : " + name);

            if (!(name.contains("555") || name.contains("motor"))) {

                System.out.println("FAIL : Unexpected product found -> " + name);
                return false;
            }
        }
        return true;

    }
    public void removeFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath(constants.FILTER_TOGGLE)
        )).click();
    }
    public int getProductCount() {

        List<WebElement> products = driver.findElements(productTitle);

        return products.size();

    }
}
