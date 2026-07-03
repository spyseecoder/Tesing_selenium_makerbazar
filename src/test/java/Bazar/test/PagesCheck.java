package Bazar.test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Bazar.base.BaseCLass;
import Bazar.pages.SelectAddCheckAndBack;
import Constants.constants;

public class PagesCheck extends BaseCLass {

	SelectAddCheckAndBack maker;

	@BeforeClass
	public void initialize() {

		maker = new SelectAddCheckAndBack(driver);

	}

	@Test(description = "Verify Battery can be added to the cart.")
	public void verifyBattery() {

		// Search and Add Battery
		maker.clickSearchButton();
		maker.searchItem(constants.item);
		waitFor5Seconds();

		maker.clickBattery();
		waitFor5Seconds();

		maker.selectVariant();
		waitFor5Seconds();

		maker.addItemToCart();
		waitFor5Seconds();

		// Close Mini Cart
		maker.clickElsewhere();
		waitFor5Seconds();

		maker.openCart();
		waitFor5Seconds();

		maker.viewFullCart();
		waitFor5Seconds();

		Assert.assertTrue(
				maker.getFirstCartProductName().contains("Battery"),
				"Battery was not added to cart");
		System.out.println("PASS: Battery was successfully added to the cart.");

		Assert.assertEquals(
				maker.getCartTotal(),
				"₹ 65.00",
				"Cart total is incorrect after adding Battery");
		System.out.println("PASS: Battery cart total verified successfully.");

		maker.goHome();
		waitFor5Seconds();
	}

	@Test(description = "Verify Multimeter can be added to the cart.")
	public void verifyMultimeter() {

		// Search and Add Multimeter
		maker.searchMultimeter();
		waitFor5Seconds();

		maker.clickMultimeter();
		waitFor10Seconds();

		maker.addItemToCart();
		waitFor5Seconds();

		// Close Mini Cart
		maker.clickElsewhere();
		waitFor5Seconds();

		maker.openCart();
		waitFor5Seconds();

		maker.viewFullCart();
		waitFor5Seconds();

		Assert.assertTrue(
				maker.getFirstCartProductName().contains("Multimeter"),
				"Multimeter is not the first item");
		System.out.println("PASS: Multimeter is present as the first item.");

		Assert.assertTrue(
				maker.getSecondCartProductName().contains("Battery"),
				"Battery is not the second item");
		System.out.println("PASS: Battery is present as the second item.");

		Assert.assertEquals(
				maker.getCartTotal(),
				"₹ 240.00",
				"Cart total is incorrect after adding Multimeter");
		System.out.println("PASS: Cart total verified successfully after adding Multimeter.");
	}

	@Test(description = "Verify Multimeter can be removed from the cart.")
	public void verifyRemoveMultimeter() {

		// Remove Multimeter
		maker.removeMultimeter();
		waitFor10Seconds();

		Assert.assertTrue(
				maker.getFirstCartProductName().contains("Battery"),
				"Battery is not present after removing Multimeter");
		System.out.println("PASS: Multimeter removed successfully. Battery is present in the cart.");

		Assert.assertEquals(
				maker.getCartTotal(),
				"₹ 65.00",
				"Cart total is incorrect after removing Multimeter");
		System.out.println("PASS: Cart total verified successfully after removing Multimeter.");

		// Back to Home
		maker.goHome();
		waitFor5Seconds();

		System.out.println("\n========== ALL TEST STEPS PASSED SUCCESSFULLY ==========\n");
	}
}