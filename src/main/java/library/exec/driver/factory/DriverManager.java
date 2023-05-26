package library.exec.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class DriverManager {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver getDriver(){
        if (driver == null){
            createDriver();
        }
        return driver;
    }

    public WebDriver returnDriver(){
        return driver;
    }


    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriverWait getWait() {
        if (wait == null){
            wait = new WebDriverWait(driver, getWaitDuration());
        }
        return wait;
    }


    /** Returns duration for specified waits */
    public Duration getWaitDuration(){
        return Duration.ofSeconds(10);
    }

    protected abstract void createDriver();

    public abstract void updateResults(String result);
}
