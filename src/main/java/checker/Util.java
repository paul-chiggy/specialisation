package checker;

import org.testng.ITestResult;

/**
 * Class to contain different utility functions
 * Author Chiggy
 */
public class Util
{
    public static void testResultSystemOut(ITestResult result, String className){
        String s = className + " [" + result.getName() + "]";
        switch(result.getStatus()){
            case(1):{
                s +=  " test DONE.";
                break;
            }
            case(2):{
                s += " test FAILED.";
                break;
            }
            case(3):{
                s += " test SKIPED.";
                break;
            }
            case(16):{
                s += " test STARTED.";
                break;
            }
            case(4):{
                s +=" test precentage succes SUCH KIND OF RESULT NEVER USED.";
                break;
            }
        }
        System.out.println(s);
    }

    public static String USERNAME = "410813";
    public static String PASSWORD = "@1loveAustralia";
}
