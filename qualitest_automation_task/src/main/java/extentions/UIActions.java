package extentions;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class UIActions extends CommonOps {


    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.clear();
        elem.sendKeys(text);
    }

    public static void mouseHover(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.moveToElement(elem).build().perform();
    }

    public static void scrollToView(WebElement elem) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    public static void switchToIframe(WebElement ifrm) {
        driver.switchTo().frame(ifrm);
    }


}
