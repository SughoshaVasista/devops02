package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebpageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.get("https://sughoshavasista.github.io/devops-02/");
    }

    @Test
    public void titleValidationTest() {

        String actualTitle = driver.getTitle();

        System.out.println("Page Title: " + actualTitle);

        Assert.assertFalse(
                actualTitle.isEmpty(),
                "Page title should not be empty"
        );
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(10000);

        if (driver != null) {
            driver.quit();
        }
    }
}