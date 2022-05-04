package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

public class ManagePages extends Base {

    public static void initObjects() {
        leadershipPage = PageFactory.initElements(driver, LeadershipPage.class);
        header = PageFactory.initElements(driver, Header.class);
        qualiViewPage = PageFactory.initElements(driver, QualiViewPage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        podcastsPage = PageFactory.initElements(driver, PodcastsPage.class);
    }


}
