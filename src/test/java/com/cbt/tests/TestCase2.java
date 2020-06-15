package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2 {
    private WebDriver driver;


    @BeforeMethod
    public void setup() throws InterruptedException {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.partialLinkText("Registration Form")).click();
        Thread.sleep(3000);

    }

    @Test
    public void verifyLanguagesDisplayed() {

        WebElement CPlusPlus = driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
        WebElement Java = driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
        WebElement JavaScript = driver.findElement(By.xpath("//label[@for='inlineCheckbox3']"));

        Assert.assertTrue(CPlusPlus.isDisplayed());
        Assert.assertTrue(Java.isDisplayed());
        Assert.assertTrue(JavaScript.isDisplayed());
    }


    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
