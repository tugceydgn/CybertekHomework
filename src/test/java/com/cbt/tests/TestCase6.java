package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase6 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();


    }

    /**
     * Step 1. Go to "https://www.tempmailaddress.com/"
     * Step 2. Copy and save email as a string.
     * Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
     * Step 4. And click on “Sign Up For Mailing List".
     * Step 5. Enter any valid name.
     * Step 6. Enter email from the Step 2.
     * Step 7. Click Sign Up
     * Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
     * Step 9. Navigate back to the “https://www.tempmailaddress.com/”
     * Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
     * Step 11. Click on that email to open it.
     * Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
     * Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     */

    @Test
    public void TestCase6() throws InterruptedException {


        WebElement copy = driver.findElement(By.id("email"));
        String copiedEmail = copy.getText();

        Thread.sleep(3000);

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.partialLinkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Tugce Aydogan");
        driver.findElement(By.name("email")).sendKeys(copiedEmail);
        driver.findElement(By.name("wooden_spoon")).click();

        Thread.sleep(5000);

        WebElement message = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(message.isDisplayed());

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        Thread.sleep(3000);
        String expected = "do-not-reply@practice.cybertekschool.com";
        String fromMailXpath = "//table[1]//tbody//tr[1]//td[1]";
        WebElement fromMail = driver.findElement(By.xpath(fromMailXpath));
        Assert.assertEquals(fromMail.getText().trim(), expected);

        fromMail.click();

        WebElement afterOpenedFromMail = driver.findElement(By.id("odesilatel"));

        Assert.assertEquals(afterOpenedFromMail.getText(), expected);

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";

        WebElement actualSubject = driver.findElement(By.xpath("//span[@id='predmet']"));
        Assert.assertEquals(actualSubject.getText(), expectedSubject);


        //


    }
}
