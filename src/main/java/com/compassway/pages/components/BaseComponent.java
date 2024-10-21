package com.compassway.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseComponent {
    protected String baseLocator;
    protected WebDriver driver;
    protected WebElement baseElement;

    public BaseComponent(WebDriver driver, String baseLocator) {
        this.baseLocator = baseLocator;
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.baseElement = driver.findElement(By.cssSelector(baseLocator));
    }

    public BaseComponent(WebDriver driver, WebElement baseElement) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.baseElement = baseElement;
    }

    public void executeJavaScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, args);
    }
}
