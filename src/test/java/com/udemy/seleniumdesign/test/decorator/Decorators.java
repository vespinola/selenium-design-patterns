package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {
    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(webElement -> Assert.assertTrue(webElement.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(webElement -> Assert.assertFalse(webElement.isDisplayed()));
    }

    //ingredients
    private static final Consumer<DashboardPage> adminComponentPresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());

    private static final Consumer<DashboardPage> guestComponentPresence = (dp) -> shouldDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentNotPresent = (dp) -> shouldNotDisplay(dp.getGuestComponents());

    private static final Consumer<DashboardPage> superuserComponentPresence = (dp) -> shouldDisplay(dp.getSuperuserComponents());
    private static final Consumer<DashboardPage> superuserComponentNotPresent = (dp) -> shouldNotDisplay(dp.getSuperuserComponents());

    //role selection
    private static final Consumer<DashboardPage> adminSelection = dashboardPage -> dashboardPage.selectRole("admin");
    private static final Consumer<DashboardPage> superuserSelection = dashboardPage -> dashboardPage.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection = dashboardPage -> dashboardPage.selectRole("guest");
}
