package Bazar.test;

import org.testng.annotations.Test;

import Bazar.base.BaseCLass2;
import Bazar.pages.Login;
import Constants.constants;

public class LoginTest extends BaseCLass2 {
	@Test()
	public void logintosite() {
		Login login=new Login(driver);
		waitFor5Seconds();
		
		login.enterid(constants.uid);
		waitFor5Seconds();
	
		login.enterpass(constants.pass);
		waitFor2Seconds();
		
		login.loginbtn();
	}
	
	
}
