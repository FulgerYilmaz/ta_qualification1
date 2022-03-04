package utilities;

import org.openqa.selenium.*;

public class ReusableMethods {

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}