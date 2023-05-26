package pages;

import library.BasePage;
import org.openqa.selenium.By;

public class GoogleHomePage extends BasePage {
    private By SEARCH_TEXTBOX = By.name("q");

    public void enterSearchText() {
        $(SEARCH_TEXTBOX).visible().sendKeys("iphone");
    }
}
