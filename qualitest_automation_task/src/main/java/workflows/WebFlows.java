package workflows;

import extentions.UIActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class WebFlows extends CommonOps {

    public static void goToLeadershipFromHeader() {
        UIActions.mouseHover(header.aboutButton);
        UIActions.click(header.leadershipButton);
    }

    public static void goToQualiviewFromHeader() {
        UIActions.click(header.toolsAndInnovationButton);
        UIActions.click(header.qualiviewButton);
    }

    public static void searchInSite(String searchInput) {
        UIActions.click(header.searchToggle);
        UIActions.updateText(header.searchInput, searchInput);
        UIActions.click(header.searchButton);
    }
//    public static void playAudioForTime(String time) {
//        UIActions.click(podcastsPage.playButton);
//        audioWait.until(ExpectedConditions.textToBePresentInElement(podcastsPage.currentPlayingDuration, time));
//        UIActions.click(podcastsPage.download);
//    }
}
