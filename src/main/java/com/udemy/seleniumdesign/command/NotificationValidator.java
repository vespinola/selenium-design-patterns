package com.udemy.seleniumdesign.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ElementValidator {
    private final WebElement button;
    private final WebElement notification;

    public NotificationValidator(final WebElement button, final WebElement notification) {
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        this.button.click();
        boolean isDisplayed = this.notification.isDisplayed();

        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);

        boolean isNotDisplayed = !this.notification.isDisplayed();

        return isDisplayed && isNotDisplayed;
    }
}
