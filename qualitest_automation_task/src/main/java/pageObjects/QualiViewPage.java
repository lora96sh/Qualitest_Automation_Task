package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QualiViewPage {

    @FindBy(css = " img[alt=Qualiview]")
    public List<WebElement> graphImages;
}
