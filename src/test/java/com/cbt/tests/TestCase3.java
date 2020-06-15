package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase3 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.partialLinkText("Registration Form")).click();
        Thread.sleep(3000);

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void warningMessage() {

        driver.findElement(By.name("firstname")).sendKeys("a");
        WebElement warningMsg = driver.findElement(By.xpath("//small[@data-bv-for='firstname'][2]"));
        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = warningMsg.getText();

        Assert.assertEquals(expected, actual);


    }


}
