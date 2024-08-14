package com.udemy.seleniumdesign.test.strategy;

import com.udemy.seleniumdesign.strategy.CreditCard;
import com.udemy.seleniumdesign.strategy.NetBanking;
import com.udemy.seleniumdesign.strategy.PaymentOption;
import com.udemy.seleniumdesign.strategy.PaymentScreen;
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
        this.paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(PaymentOption paymentOption, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("a", "b", "c");

        this.paymentScreen.setPaymentOption(paymentOption);
//        this.paymentScreen.getPaymentOption().enterPaymentInformation(paymentDetails);
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
                {new CreditCard(), cc},
                {new NetBanking(), nb}
        };
    }
}
