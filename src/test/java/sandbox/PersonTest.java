package sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by root on 17-2-17.
 */
public class PersonTest
{
    @Test
    public void personTest() {
        Person person = new Person("Piet", 50, "Dutch");
        Assert.assertTrue(person.getAge() > 40, "Wrong age! Should be 50!");
    }
}
