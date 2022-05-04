package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PodcastsPage {

    @FindBy(css= "iframe[loading='lazy']")
    public WebElement iframe;

    @FindBy(css= "path[d*='M10,']")
    public WebElement playButton;

    @FindBy(css = "img[alt*='Download']")
    public WebElement download;
    @FindBy(className = "elapsed")
    public WebElement currentPlayingDuration;

    @FindBy(className = "static-duration")
    public WebElement staticDuration;

}
