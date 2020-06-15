package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCase5 {
    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By passwordBy = By.name("password");
    private By emailBy = By.name("email");
    private By phoneBy = By.name("phone");
    private By genderBy = By.cssSelector("input[value='female']");
    private By dobBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By cPlusPlus = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    private By signUpBy = By.id("wooden_spoon");


    @Test
    public void fillFormCompletely() throws InterruptedException {

        driver.findElement(firstNameBy).sendKeys("Tugce");
        driver.findElement(lastNameBy).sendKeys("Aydogan");
        driver.findElement(usernameBy).sendKeys("tgcydgn");
        driver.findElement(passwordBy).sendKeys("tugce1598");
        driver.findElement(emailBy).sendKeys("tgcaydogan@hotmail.com");
        driver.findElement(phoneBy).sendKeys("929-228-6192");
        driver.findElement(genderBy).click();
        driver.findElement(dobBy).sendKeys("07/26/1992");
        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Engineering");

        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();
        Thread.sleep(3000);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);


    }

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
}
