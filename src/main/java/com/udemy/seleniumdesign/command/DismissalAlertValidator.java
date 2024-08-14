package com.udemy.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {
    private final WebElement dismissalAlert;

    public DismissalAlertValidator(WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        boolean isDisplayed = this.dismissalAlert.isDisplayed();

        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();

        boolean isNotDisplayed = !this.dismissalAlert.isDisplayed();

        return isDisplayed && isNotDisplayed;
    }
}
