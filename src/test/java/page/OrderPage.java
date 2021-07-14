package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class OrderPage {
    ChromeDriver driver;

    public OrderPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String nameProduct) {
        WebElement searchField = driver.findElement(By.id("search_desktop"));
        searchField.sendKeys(nameProduct);
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='product images-container']/a"));
        elements.get(1).click();
    }

    public void checkIframeFreeship() {
    }

    public void clickButtonByNow() {
        driver.findElement(By.xpath("//*[@class='product_view_add_box']/button[2]")).click();
    }

    public void verifyTotal() {
        String qty = driver.findElement(By.id("qty-40540505")).getAttribute("value");
        float qtyFloat = Float.parseFloat(qty);
        int qtyInt = Integer.parseInt(qty);
        String price = driver.findElement(By.xpath("//*[@id='cart-sidebar']//*[@class='price']")).getText();
        float priceFloat = Float.parseFloat(price);
        float totalExpect = qtyFloat * priceFloat;
        String totalInBill = driver.findElement(By.xpath("//*[@class='total-cart-page']//*[@class='number-cart-page-right']/span")).getText();
        assertTrue(totalExpect == Float.parseFloat(totalInBill));
    }

}
