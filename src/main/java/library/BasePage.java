package library;

import library.core.Page;
import library.exec.driver.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BasePage extends Page {
    public BasePage() {
        super(DriverFactory.getInstance().getDriver());
    }


}
