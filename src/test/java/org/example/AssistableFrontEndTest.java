package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AssistableFrontEndTest {
    static AppiumDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "David's Galaxy A10s");
        cap.setCapability("udid", "R9EM90BDAYJ");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");

        cap.setCapability("appPackage", "com.twite.Assista");
        cap.setCapability("appActivity", "com.twite.Assista.MainActivity");

        // Additional desired capabilities
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("newCommandTimeout", 600);
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("noReset", true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<>(url, cap);

        System.out.println("Application Started.....");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCalculator() {


        MobileElement username = driver.findElement(By.className("android.widget.EditText"));
        username.click();
        MobileElement password = driver.findElement(By.className("android.widget.EditText"));
        password.click();
//        MobileElement loginBtn = driver.findElement(By.id("00000000-0000-00f3-ffff-ffff00000016"));
//        loginBtn.click();


        String res = username.getText()+" "+ password.getText();

        System.out.println("The Result is: " + res);
//        Assert.assertEquals("6", res);

        System.out.println("Thanks!!!!!!!!!!!!!!!!!!!!!!!!");

    }

}
