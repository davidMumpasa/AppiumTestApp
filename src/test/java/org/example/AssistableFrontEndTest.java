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
                idField.setValue("9101260665085");

                verifyBtn.click();

                MobileElement providerBtn = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Provider\"]/android.widget.TextView")));
                providerBtn.click();

                MobileElement username = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")));
                username.setValue("jeanluck");

                MobileElement email = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText"));
                email.setValue("jeanluck@gmail.com");
                MobileElement homeAddress = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText"));
                homeAddress.setValue("125 steve biko pretoria arcadia");
                MobileElement password = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText"));
                password.setValue("12345");
                MobileElement confirmPassword = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.EditText"));
                confirmPassword.setValue("12345");

                MobileElement registerBtn2 = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Register\"]/android.widget.TextView")));
                registerBtn2.click();

                MobileElement registerErrorAlert = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")));
                String registerErrorAlertStr = registerErrorAlert.getText();
                System.out.println(registerErrorAlertStr);

//                if(registerErrorAlertStr.equals("Password must meet the strength criteria")){
                MobileElement registerBtnErrorAlert = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")));
                registerBtnErrorAlert.click();

                password.setValue("JeanLuck@10");
                confirmPassword.setValue("JeanLuck@10");
                registerBtn2.click();
            }
        }
    }

    @Test
    public void testLogin(){
        WebDriverWait wait = new WebDriverWait(driver, 30); // Wait for up to 30 seconds
        MobileElement loginEmail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText"));
        loginEmail.setValue("david@gmail.com");

        MobileElement loginPassword = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText")));
        loginPassword.setValue("DavidMumpasa@10");

        MobileElement loginBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login\"]/android.widget.TextView"));
        loginBtn.click();

        MobileElement successLoginBtn = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")));
        successLoginBtn.click();

        MobileElement homePage = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));

    }
}
