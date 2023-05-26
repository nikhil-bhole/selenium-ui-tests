package library.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, getWaitDuration());
    }


    private Duration getWaitDuration() {
        return Duration.ofSeconds(10);
    }

    public Element findElement(By by) {
        return new Element(driver, by);
    }

    public Element $(By by) {
        return findElement(by);
    }



}
