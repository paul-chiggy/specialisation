package checker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class with methods to navigate through target website
 *
 * Author Chiggy
 */
public class NavigationManager
{
    private WebDriver wd = null;

    public NavigationManager() {}

    public NavigationManager(WebDriver wd)
    {
        this.wd = wd;
    }

    public void goToStudentPage()
    {
        wd.findElement(By.id("id13")).click();
    }

    public void goToProfileMenu()
    {
        wd.findElement(By.linkText("Pavlo (PI) Chigishev")).click();
    }

    public void goToBisonLoginPage()
    {
        wd.get("https://bison.saxion.nl/login");
        wd.findElement(By.cssSelector("div.row-fluid")).click();
    }
}
