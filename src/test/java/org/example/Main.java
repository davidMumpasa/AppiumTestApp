package org.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Main {

    static AppiumDriver<MobileElement> driver ;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            openCalculator();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void openCalculator() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "David's Galaxy A10s");
        cap.setCapability("udid", "R9EM90BDAYJ");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");


        cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Application Started.....");

        MobileElement one = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01"));
        one.click();
        MobileElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        plus.click();
        MobileElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
        two.click();
        plus.click();
        MobileElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
        three.click();
        MobileElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
        equals.click();
        MobileElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));

        String res = result.getText();


        System.out.println("The Result is: "+res);
        if(res.equals("6")) {
            System.out.println("Test successfully....");
        } else {
            System.out.println("Test Failed....");
        }



    }
}