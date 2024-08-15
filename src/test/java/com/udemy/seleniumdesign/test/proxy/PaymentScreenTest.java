package com.udemy.seleniumdesign.test.proxy;

import com.udemy.seleniumdesign.proxy.PaymentOptionFactory;
import com.udemy.seleniumdesign.proxy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        System.setProperty("env", "PROD");
        this.paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("a", "b", "c");

        this.paymentScreen.setPaymentOption(
                PaymentOptionFactory.get(option)
        );

        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();

        System.out.println(
                "Order Number : " + orderNumber
        );
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "121212121212");
        cc.put("year", "2023");
        cc.put("cvv", "123");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "11111111111");
        nb.put("pin", "1234");

        return new Object[][] {
                {"CC", cc},
                {"NB", nb}
        };
    }
}
