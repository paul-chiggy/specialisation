package checker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class to operate browser's sessions login, logout etc
 *
 * Author Chiggy
 */
public class SessionManager
{
    private WebDriver wd = null;

    public SessionManager() {}

    public SessionManager(WebDriver wd)
    {
        this.wd = wd;
    }

    private void setLogin(String login)
    {
        wd.findElement(By.id("username")).click();
        wd.findElement(By.id("username")).clear();
        wd.findElement(By.id("username")).sendKeys(login);
    }

    private void setPassword(String password)
    {
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys(password);
    }

    public void login(String login, String password)
    {
        setLogin(login);
        setPassword(password);
        wd.findElement(By.id("id3")).click();
    }

    public void logout()
    {
        wd.findElement(By.linkText("Pavlo (PI) Chigishev")).click();
        wd.findElement(By.linkText("Logout")).click();
    }
}
