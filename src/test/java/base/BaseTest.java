package base;

import library.BasePage;
import library.exec.driver.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    protected BasePage po;

    /**
     * return web driver for the current thread - can be used when running using TestNG
     */
    public WebDriver getDriver() {
        return DriverFactory.getInstance().getDriver();
    }

    /**
     * return web driver wait for the current thread - can be used when running using TestNG
     */
    public WebDriverWait getWait() {
        return DriverFactory.getInstance().getWait();
    }

    /**
     * return BasePO instance - can be used when running using TestNG
     */
    public BasePage getPO() {
        if (this.po == null) {
            this.po = new BasePage();
        }
        return po;
    }

    public void setPO() {
        this.po = new BasePage();
    }

    @BeforeMethod
    public void startUp(Method method, Object[] args) {
        getDriver().navigate().to("https://www.google.com/");
    }

    /**
     * if cucumber test the update the status and removes the current thread's value for this thread-local
     */
    //@AfterMethod(groups = {"quitDriver"})
    public void closeDown(ITestResult result) {

    }

    //@BeforeTest
    public void startReport() {

    }

    @AfterTest
    public void tearDown() {
        getDriver().close();
    }


}
