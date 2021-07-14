package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import page.PageCommon;
import page.ReadExcel;


public class LoginTest extends Base {
    LoginPage login;
    PageCommon pageCommon;

    @Test(dataProvider = "PassLogin")
    public void loginFahasa(String username, String password) {
        login = new LoginPage(driver);
        pageCommon = new PageCommon(driver);
        login.login(username, password);
        pageCommon.waitAbout(5);
        login.checkLoginSuccesfull();
    }

    @Test(dataProvider = "failLogin")
    public void loginFahasa2(String username, String password) {
        login = new LoginPage(driver);
        pageCommon = new PageCommon(driver);
        login.login(username, password);
        pageCommon.waitAbout(5);
        login.checkLoginFail();
    }

    @DataProvider

    public Object[][] PassLogin() throws Exception {

        Object[][] testObjArray = ReadExcel.getTableArray("login.xlsx", "LoginPass");

        return (testObjArray);

    }

    @DataProvider
    public Object[][] failLogin() throws Exception {

        Object[][] testObjArray = ReadExcel.getTableArray("login.xlsx", "LoginFail");

        return (testObjArray);

    }
}
