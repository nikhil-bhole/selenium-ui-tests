package library.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Element {
    private WebDriver driver;
    private WebElement element;
    private By by;
    private WebDriverWait wait;

    public Element(WebDriver driver, WebElement e) {
        this.driver = driver;
        wait = new WebDriverWait(driver, getWaitDuration());
        this.element = e;
    }

    public Element(WebDriver driver, WebElement e, By by) {
        this.driver = driver;
        wait = new WebDriverWait(driver, getWaitDuration());
        this.element = e;
        this.by = by;
    }

    public Element(WebDriver driver, By by, Duration... delay) {
        this.driver = driver;
        this.by = by;
        try {
            wait = new WebDriverWait(driver, delay.length > 0 ? delay[0] : getWaitDuration());
            this.element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

        } catch (Exception e) {
            this.element = null;
        }
    }



    public By by() {
        return by;
    }

    public WebElement element() {
        return element;
    }

    public Element $(By by) {
        return new Element(driver, wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(this.element, by)), by);
    }

    public Element visible() {
        this.element = wait.until(ExpectedConditions.visibilityOf(this.element));
        return this;
    }

    public Element sendKeys(String val) {
        try {
            try {
                this.element().sendKeys(val);
            } catch (Exception e) {
                this.sendKeys(val);
            }
        } catch (Exception e) {
            throw e;
        }
        return this;
    }

    public Duration getWaitDuration() {
        return Duration.ofSeconds(10);
    }
}


