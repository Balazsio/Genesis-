import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HTMLEditorPage;

public class RichTextEditorTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "HTML Editor (Case3) test")
    public static void EditorTest() {
        driver = new ChromeDriver();
        driver.get(Utils.HTMLEDITOR_URL);
        driver.manage().window().maximize();
        HTMLEditorPage htmlEditorPage = new HTMLEditorPage(driver);
        htmlEditorPage.enterText(Utils.SAMPLE_TEXT);

        htmlEditorPage.makeTextBold();
        htmlEditorPage.makeTextUnderline();
        htmlEditorPage.validateTextAppear(Utils.SAMPLE_TEXT);
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }

}
