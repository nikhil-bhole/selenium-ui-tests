package smoke_tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonLoginTest extends BaseTest {

    @Test
    public void testAmazonLogin() {
        getDriver().navigate().to("https://www.amazon.in/");
        System.out.println("Running amazon login tests.");
        Assert.assertTrue(false);
    }
}
