package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    @FindBy (css = ".searech-post-title a ")
    public WebElement firstResult;
}
