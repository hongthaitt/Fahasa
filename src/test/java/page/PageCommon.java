package page;

import org.openqa.selenium.chrome.ChromeDriver;

public class PageCommon {
    ChromeDriver driver;

    public PageCommon(ChromeDriver driver) {
        this.driver = driver;
    }

    public void waitAbout(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
