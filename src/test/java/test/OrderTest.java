package test;

import org.junit.Test;
import page.LoginPage;
import page.OrderPage;

public class OrderTest extends Base {
    OrderPage orderPage;

    @Test
    public void orderP() {
        //Buy one product
        orderPage = new OrderPage(driver);
        orderPage.searchProduct("Tam cam");
        orderPage.clickButtonByNow();
        orderPage.verifyTotal();
    }
}
