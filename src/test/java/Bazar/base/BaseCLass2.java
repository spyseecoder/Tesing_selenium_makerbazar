package Bazar.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Constants.constants;

public class BaseCLass2 {
	public WebDriver driver;

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(constants.bc2);
    }

    public void waitFor2Seconds() {

        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }
    public void waitFor5Seconds() {

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }
    public void waitFor10Seconds() {

        try {

            Thread.sleep(10000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}

