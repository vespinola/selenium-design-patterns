package com.udemy.seleniumdesign.test.template;

import com.udemy.seleniumdesign.template.AmazonShopping;
import com.udemy.seleniumdesign.template.EbayShopping;
import com.udemy.seleniumdesign.template.ShoppingTemplate;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate template) {
        template.shop();
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
          new AmazonShopping(driver, "samsung"),
          new EbayShopping(driver, "iphone")
        };
    }
}
