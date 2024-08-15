package com.udemy.seleniumdesign.template;

import com.udemy.seleniumdesign.template.pages.AmazonProductDescPage;
import com.udemy.seleniumdesign.template.pages.AmazonResultPage;
import com.udemy.seleniumdesign.template.pages.AmazonSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonShopping extends ShoppingTemplate {
    private String product;
    private WebDriver driver;

    private AmazonSearchPage searchPage;
    private AmazonResultPage resultPage;
    private AmazonProductDescPage productDescPage;

    public AmazonShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;

        this.searchPage = PageFactory.initElements(driver, AmazonSearchPage.class); //new AmazonSearchPage(driver);
        this.resultPage = PageFactory.initElements(driver, AmazonResultPage.class); //new AmazonResultPage(driver);
        this.productDescPage = PageFactory.initElements(driver, AmazonProductDescPage.class); //new AmazonProductDescPage(driver);
    }

    @Override
    public void launchSite() {
        searchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        searchPage.search(product);
    }

    @Override
    public void selectProduct() {
        resultPage.selectProduct();
    }

    @Override
    public void buy() {
        productDescPage.buy();
    }
}
