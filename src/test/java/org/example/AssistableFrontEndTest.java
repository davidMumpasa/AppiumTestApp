package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

//    @Test
//    public void testCalculator() {
//
//        MobileElement registerBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"New User ? Sign Up\"]/android.widget.TextView"));
//        registerBtn.click();
//
//        MobileElement idField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText"));
//        idField.setValue("1234567891234");
//
//        MobileElement verifyBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Verify\"]/android.widget.TextView"));
//        verifyBtn.click();
//
//    }

    @Test
    public void testCalculator() {

        MobileElement loginBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login\"]/android.widget.TextView"));
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 30); // Wait for up to 30 seconds
        MobileElement loginError = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")));
        String errorAlert = loginError.getText();

        System.out.println(errorAlert);

        if(errorAlert.equals("Please fill in both email and password.")){
            MobileElement alertOkBtn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"));
            alertOkBtn.click();

            MobileElement registerBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"New User ? Sign Up\"]/android.widget.TextView"));
            registerBtn.click();

            // id verification button
            MobileElement verifyBtn = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='Verify']/android.widget.TextView")));
            verifyBtn.click();

            // id alert error message
            MobileElement idErrorAlert = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView"));
            String idErrorAlertStr = idErrorAlert.getText();
            System.out.println(idErrorAlertStr);

            if(idErrorAlertStr.equals("ID number must have exactly 13 digits")){
                // id alert error message button
                MobileElement idAlertBtn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"));
                idAlertBtn.click();

                // Fill the form
                MobileElement idField = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText"));
                idField.setValue("1234567891234");

                verifyBtn.click();


            }


        }


    }


}
