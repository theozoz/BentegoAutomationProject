package org.bentego.methods;

import org.bentego.Log;
import org.bentego.base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Methods {

    private WebDriverWait wait;
    WebDriver driver;

    public Methods() {
        this.driver = BaseDriver.driver;
        System.out.println(driver);
        wait = new WebDriverWait(BaseDriver.driver, Duration.ofSeconds(15), Duration.ofMillis(100));
    }

    public void setWait(int second) {
        second = second * 1000;
        try {
            sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement findElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        Log.info("Element found: "+ locator);
        return element;
    }

    public WebElement findElements(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        List<WebElement> elements = driver.findElements(locator);
        WebElement randomElement = elements.get(new Random().nextInt(elements.size()));
        Log.info("Element found: "+ locator);
        return randomElement;
    }

    public void clickElement(By locator) {
        findElement(locator).click();
        Log.info("Element click: "+ locator);

    }

    public void clickElements(By locator) {
        findElements(locator).click();
        Log.info("Element click: "+ locator);
    }

    public void sendKeys(By locator, String key) {
        findElement(locator).sendKeys(key);
        Log.info("Keys sent to element : "+ locator);

    }

    public Integer randomNumber() {
        Random r = new Random();
        return r.nextInt((56 - 30) + 1) + 30;
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", findElement(locator));
        Log.info("Scroll to element : "+ locator);

    }
}
