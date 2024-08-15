package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductDescPage {
    @FindBy(id = "priceblock_ourprice")
    private WebElement price;

    private WebDriver driver;
    private WebDriverWait wait;

    public AmazonProductDescPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void buy() {
        this.wait.until((d) -> this.price.isDisplayed());
        System.out.println(
                this.price.getText()
        );
    }
}
