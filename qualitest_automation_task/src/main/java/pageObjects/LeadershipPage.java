package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeadershipPage {
    @FindBy(xpath = "//h1[text()='Leadership Team']")
    public WebElement titleToBeDisplayed;

    @FindBy(className = "eg-leadership-team-content")
    public List<WebElement> peopleOnPage;

}
