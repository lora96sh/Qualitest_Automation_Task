package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class CommonOps extends Base {
    String browser = "chrome";

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = initFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            driver = initIEDriver();

        } else throw new RuntimeException();
        driver.get("https://qualitestgroup.com/team/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        audioWait = new WebDriverWait(driver, 500);
        ManagePages.initObjects();
        action = new Actions(driver);
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }


    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;

    }


    @BeforeClass
    public void startSession() {
        initBrowser(browser);
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }


}