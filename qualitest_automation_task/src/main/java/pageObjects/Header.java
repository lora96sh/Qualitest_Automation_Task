package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(css = "a[href*='/about/']")
    public WebElement aboutButton;

    @FindBy(xpath = "//a[normalize-space()='Leadership Team']")
    public WebElement leadershipButton;

    @FindBy(xpath = "//a[text()='Tools & Innovation']")
    public WebElement toolsAndInnovationButton;
    @FindBy(xpath = "//div[@class='middle-block']/div[2]/a[text()='Qualiview']")
    public WebElement qualiviewButton;
    @FindBy(id = "search_toggle")
    public WebElement searchToggle;
    @FindBy(id = "search_input")
    public WebElement searchInput;

    @FindBy(id = "search_button")
    public WebElement searchButton;
}
