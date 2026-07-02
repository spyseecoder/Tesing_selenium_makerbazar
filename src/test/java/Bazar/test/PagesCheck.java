package Bazar.test;


import org.testng.annotations.Test;

import Bazar.base.BaseCLass;
import Bazar.pages.SelectAddCheckAndBack;
import Constants.constants;

public class PagesCheck extends BaseCLass {
	@Test()
	public void purchasebattery() {
		SelectAddCheckAndBack maker=new SelectAddCheckAndBack(driver);
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

        // Search and Add Multimeter
        maker.searchMultimeter();
        waitFor5Seconds();

        maker.clickMultimeter();
        waitFor5Seconds();

        maker.addItemToCart();
        waitFor5Seconds();

        // Close Mini Cart
        maker.clickElsewhere();
        waitFor5Seconds();

        // Open Cart
        maker.openCart();
        waitFor5Seconds();

        maker.viewFullCart();
        waitFor5Seconds();

        // Remove Multimeter
        maker.removeMultimeter();
        waitFor5Seconds();

        // Back to Home
        maker.goHome();
        waitFor5Seconds();
	}
}
