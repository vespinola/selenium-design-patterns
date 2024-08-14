package com.udemy.seleniumdesign.test.command;

import com.udemy.seleniumdesign.command.ElementValidator;
import com.udemy.seleniumdesign.command.HomePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        this.homePage.getElementValidator()
                .stream()
                .map(ElementValidator::validate)
                .forEach(Assert::assertTrue);
    }
}
