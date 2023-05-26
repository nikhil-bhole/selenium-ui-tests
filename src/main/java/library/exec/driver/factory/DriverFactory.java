package library.exec.driver.factory;

import library.exec.driver.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    protected DriverFactory() {
    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<DriverManager> driverManager = new ThreadLocal<DriverManager>() {
        protected DriverManager initialValue() {
            return setDM();
        }
    };

    public DriverManager driverManager() {
        return driverManager.get();
    }

    public WebDriver getDriver() {
        return driverManager.get().getDriver();
    }

    public WebDriver returnDriver() {
        return driverManager.get().returnDriver();
    }

    public WebDriverWait getWait() {
        return driverManager.get().getWait();
    }

    public void quit() {
        driverManager.get().quitDriver();
        driverManager.remove();
    }

    public DriverManager setDM() {
        /**
         * TODO : Set server type to run tests on sauce labs/ browser stack
         */
        //ServerType serverType = ServerType.valueOf(DriverContext.getInstance().getTechStack().get("seleniumServer"));
        String browserType = "chrome";
        driverManager.set(new ChromeDriverManager());
        return driverManager.get();
    }
}
