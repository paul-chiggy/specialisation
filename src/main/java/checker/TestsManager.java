package checker;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static checker.TestsManager.Browsers.FIREFOX;

/**
 * Class to manage common tests' actions like start, stop, login, launch browser etc.
 *
 * Author Chiggy
 */
public class TestsManager
{
    protected WebDriver wd;
    protected SessionManager session = null;
    protected NavigationManager nav = null;
    public enum Browsers { FIREFOX, CHROME, SAFARI, IE };
    protected Browsers browser = FIREFOX;

    @BeforeClass
    protected void start() throws Exception
    {
        System.out.println(this.getClass().getName() + " processing...");
    }

    @AfterClass
    protected void stop() throws Exception
    {
        System.out.println(this.getClass().getName() + " finished. Proceeding to other tests, if any...");
    }

    @BeforeMethod
    protected void setUp() throws Exception
    {
        setUpBrowser();
        setUpManagers();
    }

    private void setUpBrowser() throws Exception
    {
        switch(browser) {
            case FIREFOX: default:
                System.setProperty("webdriver.gecko.driver","/home/chiggy/specialisation/geckodriver");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("webdriver.log.browser.ignore", true);
                profile.setPreference("webdriver.log.driver.ignore", true);
                profile.setPreference("webdriver.log.profiler.ignore", true);

                wd = new FirefoxDriver();
                break;
            case CHROME:
                wd = new ChromeDriver();
                break;
            case IE:
                wd = new InternetExplorerDriver();
                break;
            case SAFARI:
                wd = new SafariDriver();
                break;
        }
        if (wd != null) { wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); }
    }

    private void setUpManagers() throws Exception
    {
        if(session == null) { session = new SessionManager(wd); }
        if(nav == null) { nav = new NavigationManager(wd); }
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        System.out.println("Closing browser...");
        wd.quit();
        session = null;
        nav = null;
        Util.testResultSystemOut(result, this.getClass().getName());
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
