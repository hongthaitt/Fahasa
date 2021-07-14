package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    ChromeDriver driver;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.xpath("//*[@class='fhs_top_account_login_button']")).click();
        driver.findElement(By.xpath("//*[@id='login_username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='login_password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@class='fhs-btn-login']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkLoginSuccesfull() {
        String title = driver.findElement(By.xpath("//*[@class='fhs_top_account_button']")).getText();
        assertTrue(title.toLowerCase().equals("tài khoản"));
    }

    public void checkLoginFail() {
        String title = driver.findElement(By.xpath("//*[@class='fhs-popup-msg fhs-login-msg']")).getText();
        assertTrue(title.equals("Số điện thoại/Email hoặc Mật khẩu sai!"));
    }
}
