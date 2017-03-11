package checker;

import org.testng.annotations.*;

public class StudentPageTests extends TestsManager
{
    @BeforeClass
    protected void myBrowserIs()
    {
        browser = Browsers.FIREFOX;
    }

    @Test (priority = 1)
    public void goToStudentPageTest()
    {
        nav.goToBisonLoginPage();
        session.login(Util.USERNAME, Util.PASSWORD);
        nav.goToStudentPage();
        session.logout();
    }
}
