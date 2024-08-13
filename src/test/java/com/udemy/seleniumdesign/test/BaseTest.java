package com.udemy.seleniumdesign.test;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/Downloads/chromedriver");
//        this.driver = new ChromeDriver();

//        System.setProperty("webdriver.chrome.driver",
//                System.getProperty("user.dir")+"/Chrome/chromedriver");
        driver=new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }
}
