package Bazar.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Bazar.base.BaseCLass;
import Bazar.pages.SelectAddCheckAndBack;

public class FilterTest extends BaseCLass {

	@Test(description = "Verify product filter functionality.")
	public void applyProductFilter() {

		SelectAddCheckAndBack maker = new SelectAddCheckAndBack(driver);

		// Search Product
//		maker.clickSearchButton();
//		maker.searchItem(constants.batterysearch);
//		waitFor5Seconds();
//
//		// Open Filter
//		maker.clickFilter();
//		waitFor5Seconds();
//
//		// Select Product Type
//		maker.clickProductType();
//		waitFor5Seconds();
//
//		System.out.println("PASS: Product filter applied successfully.");
		
		maker.clickSearchButton();
		maker.searchItem("Motor");
		waitFor5Seconds();
		
		//appl yfilter

		maker.clickFilter();
		waitFor5Seconds();
		//filter

		maker.click555MotorFilter();
		waitFor5Seconds();

		Assert.assertTrue(
		        maker.verifyFilteredProducts(),
		        "Displayed products do not match the selected 555 Motor filter.");

		System.out.println("PASS: 555 Motor filter applied successfully.");

		int filteredCount = maker.getProductCount();
		//count

		System.out.println("Filtered Products : " + filteredCount);
		
		//click to remove filter
		
		maker.click555MotorFilter();
		waitFor5Seconds();

		int normalCount = maker.getProductCount();
		//countn after removal

		System.out.println("Products After Removing Filter : " + normalCount);

		Assert.assertTrue(
		        normalCount > filteredCount,
		        "Filter was not removed successfully.");

		System.out.println("PASS: Filter removed successfully.");

	}
}
