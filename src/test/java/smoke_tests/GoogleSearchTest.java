package smoke_tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class GoogleSearchTest extends BaseTest {



    @Test()
    public void verifyGoogleSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.enterSearchText();
    }




}
