package library.exec.driver.managers;

import library.exec.driver.factory.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        driver = new ChromeDriver();
    }

    @Override
    public void updateResults(String result) {
        //do nothing
    }
}
