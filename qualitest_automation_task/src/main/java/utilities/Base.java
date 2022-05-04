package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static WebDriverWait audioWait;

    protected static Actions action;

    //page objects
    protected static LeadershipPage leadershipPage;
    protected static Header header;
    protected static QualiViewPage qualiViewPage;
    protected static SearchPage searchPage;
    protected static PodcastsPage podcastsPage;

}
