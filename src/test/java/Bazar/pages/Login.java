package Bazar.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constants.constants;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	@FindBy(name = constants.email)
	WebElement email;
	
	@FindBy(name = constants.password)
	WebElement password;
	
	@FindBy(xpath = constants.loginbtn)
	WebElement loginBtn;
	
	public void enterid(String uname) {
		email.click();
		email.sendKeys(uname);
	}
	
	public void enterpass(String pass) {
		password.click();
		password.sendKeys(pass);
	}
	
	public void loginbtn() {
		loginBtn.click();
	}
}
