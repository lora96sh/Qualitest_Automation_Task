import extentions.UIActions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class AutomationTask extends CommonOps {
    private final String dataFile = "./JsonFiles/testsData.json";
    private int expectedLeadershipOnPage;
    private int expectedGraphsOnPage;
    private String searchInput;
    private String audioQuarterLength;
    private long expectedFileLength;
    private String filePath;

    @BeforeClass
    public void beforeClass() {
        initializeData();
    }

    @Test
    public void test_01() {
        WebFlows.goToLeadershipFromHeader();
        wait.until(ExpectedConditions.visibilityOf(leadershipPage.titleToBeDisplayed));
        JSONArray leadershipData = new JSONArray();
        for (WebElement leadership : leadershipPage.peopleOnPage) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("first name", getFirstNameOfLeader(leadership));
            jsonObject.put("last name", getLasttNameOfLeader(leadership));
            jsonObject.put("title", getTitleOfLeader(leadership));
            leadershipData.put(jsonObject);
        }
        Assert.assertEquals(leadershipData.length(), expectedLeadershipOnPage);
        Assert.assertTrue(writeJsonToFile(leadershipData), "Error in Writing JSON to File");
    }

    @Test
    public void test_02() {
        WebFlows.goToQualiviewFromHeader();
        WebElement lastGraphElement = qualiViewPage.graphImages.get(qualiViewPage.graphImages.size() - 1);
        UIActions.scrollToView(lastGraphElement);
        Assert.assertEquals(qualiViewPage.graphImages.size(), expectedGraphsOnPage);
    }

    @Test
    public void test_03() throws InterruptedException {
        WebFlows.searchInSite(searchInput);
        UIActions.click(searchPage.firstResult);
        UIActions.switchToIframe(podcastsPage.iframe);
        UIActions.click(podcastsPage.playButton);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(podcastsPage.currentPlayingDuration, "00:00:00")));
        Assert.assertTrue(Double.parseDouble(podcastsPage.currentPlayingDuration.getText().split(":")[2]) > 0.0);
        audioWait.until(ExpectedConditions.textToBePresentInElement(podcastsPage.currentPlayingDuration, audioQuarterLength));
        UIActions.click(podcastsPage.download);
        Thread.sleep(5000);
        //check file length
        Path path = Paths.get(filePath);
        Assert.assertEquals(getFileLength(path), expectedFileLength);

    }


    //   ***  helper methods  ***

    private String getFirstNameOfLeader(WebElement element) {
        return element.findElement(By.tagName("div")).getText().split(" ")[0];
    }

    private String getLasttNameOfLeader(WebElement element) {
        return element.findElement(By.tagName("div")).getText().split(" ")[1];
    }

    private String getTitleOfLeader(WebElement element) {
        return element.findElements(By.tagName("div")).get(1).getText();
    }

    private boolean writeJsonToFile(JSONArray jsonArray) {
        try {
            FileWriter file = new FileWriter("./Leadership.json");
            file.write(jsonArray.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private long getFileLength(Path path) {
        long bytes = 0;
        try {
            // size of a file (in bytes)
            bytes = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    private JSONObject getTestDataAsJson() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(dataFile)));
        return new JSONObject(content);
    }
    private void initializeData(){
        JSONObject testsData;
        try {
             testsData = getTestDataAsJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!testsData.isEmpty()){
            expectedLeadershipOnPage = testsData.getInt("expectedLeadershipOnPage");
            expectedGraphsOnPage = testsData.getInt("expectedGraphsOnPage");
            searchInput = testsData.getString("searchInput");
            audioQuarterLength =testsData.getString("audioQuarterLength");
            expectedFileLength = testsData.getLong("expectedFileLength");
            String home = System.getProperty("user.home");
            filePath = home + testsData.getString("staticPath");
        }
    }
}