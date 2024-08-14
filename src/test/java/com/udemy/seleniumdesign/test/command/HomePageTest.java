package com.udemy.seleniumdesign.test.command;

import com.udemy.seleniumdesign.command.ElementValidator;
import com.udemy.seleniumdesign.command.HomePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
                .parallel()
                .map(ElementValidator::validate)
                .forEach(Assert::assertTrue);
    }

    //Data provider Example
    @Test(dataProvider = "getData", dependsOnMethods = "goTo")
    public void homePageValidations(ElementValidator elementValidator) {
        Assert.assertTrue(elementValidator.validate());
    }

    @Test
    public void goTo() {
        this.homePage.goTo();
    }

    @DataProvider
    public Object[] getData() {
        return this.homePage
                .getElementValidator()
                .toArray();
    }
}
