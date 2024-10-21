package com.compassway.tests;

import com.compassway.utils.ConfigLoader;
import com.compassway.utils.driver.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();
        driver.get(ConfigLoader.getProperty("baseUrl"));
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
