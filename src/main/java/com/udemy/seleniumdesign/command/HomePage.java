package com.udemy.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {
    private final WebDriver driver;

    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warningBtn;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;

    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warningAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //dismissal alert
    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-warning")
    private WebElement dismissWarnAlert;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidator() {
        return Arrays.asList(
                // notification validations
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(warningBtn, warningAlert),
                new NotificationValidator(dangerBtn, dangerAlert),
                // dismiss validations
                new DismissalAlertValidator(dismissInfoAlert),
                new DismissalAlertValidator(dismissWarnAlert),
                new DismissalAlertValidator(dismissSuccessAlert),
                new DismissalAlertValidator(dismissDangerAlert)
        );
    }
}
