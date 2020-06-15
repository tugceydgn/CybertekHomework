package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {

    private WebDriver driver;
    private By dob = By.xpath("//input [@name='birthday']");


    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

    }


    @Test
    public void verifyWarningMessage() throws Exception {

        driver.findElement(By.partialLinkText("Registration Form")).click();
        Thread.sleep(6000);
        driver.findElement(dob).sendKeys("wrong_dob");
        Thread.sleep(3000);
        WebElement warningMsg = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]"));
        Thread.sleep(3000);
        Assert.assertTrue(warningMsg.isDisplayed());


    }


    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
