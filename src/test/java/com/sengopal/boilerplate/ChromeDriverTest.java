package com.sengopal.boilerplate;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChromeDriverTest {

    @Test
    public void testDriverLoad() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "~/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        Thread.sleep(5000);

        WebElement userId = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[type='text']"))));

        userId.sendKeys("travis-ci");
        driver.findElement(By.name("btnK")).submit();

        Thread.sleep(5000);

        String url = null;
        if (driver.getCurrentUrl().contains("https://www.google.com/search")) {
            System.out.println("Code Obtained");
        }
        driver.quit();
    }
}
