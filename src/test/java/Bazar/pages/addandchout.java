package Bazar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Bazar.base.BaseClass3;
import Constants.constants;

public class addandchout extends BaseClass3 {

	public addandchout(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Product Details

	By productNames = By.xpath(constants.cartproductname);

	By productPrices = By.xpath(constants.cartproductprice);

	By quantity = By.xpath(constants.cartquantity);

	By linePrice = By.xpath(constants.cartlineprice);

	// Cart

	By cartTotal = By.xpath(constants.carttotal);

	By removeButtons = By.xpath(constants.removeitem);

	// First Product Name

	public String getFirstProductName() {

		return driver.findElements(productNames).get(0).getText();
	}

	// Second Product Name

	public String getSecondProductName() {

		return driver.findElements(productNames).get(1).getText();
	}

	// First Product Price

	public String getFirstProductPrice() {

		return driver.findElements(productPrices).get(0).getText();
	}

	// Second Product Price

	public String getSecondProductPrice() {

		return driver.findElements(productPrices).get(1).getText();
	}

	// First Product Quantity

	public String getFirstProductQuantity() {

		return driver.findElements(quantity).get(0).getAttribute("value");
	}

	// Second Product Quantity

	public String getSecondProductQuantity() {

		return driver.findElements(quantity).get(1).getAttribute("value");
	}

	// First Line Price

	public String getFirstLinePrice() {

		return driver.findElements(linePrice).get(0).getText();
	}

	// Second Line Price

	public String getSecondLinePrice() {

		return driver.findElements(linePrice).get(1).getText();
	}

	// Cart Total

	public String getCartTotal() {

		return waitForElementVisible(cartTotal).getText();
	}

	// Remove First Product

	public void removeFirstProduct() {

		driver.findElements(removeButtons).get(0).click();
	}

	// Remove Second Product

	public void removeSecondProduct() {

		driver.findElements(removeButtons).get(1).click();
	}

	// Verify First Product

	public boolean verifyFirstProduct(String expectedProduct) {

		return getFirstProductName().equalsIgnoreCase(expectedProduct);
	}

	// Verify Second Product

	public boolean verifySecondProduct(String expectedProduct) {

		return getSecondProductName().equalsIgnoreCase(expectedProduct);
	}

}
