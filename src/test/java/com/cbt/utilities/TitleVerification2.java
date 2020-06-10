package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import javax.lang.model.util.Types;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    /**
     * 3.Visit all websites one by one.
     * 4.Verify that URLof the website contains the title of the website.
     * Ignore spacesand casein comparison.For example,title of in the first
     * websitetitle is Lulu and Giorgiaand the URLis https://lulugandgeorgia.com.
     * So,this test case must pass.
     * 5.Close the browser at theendof the test.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com");  //westelm.com blocked me. That's why I deleted it


        for (String eachURL : urls) {

            driver.get(eachURL);
            Thread.sleep(4000);

            if (eachURL.contains(driver.getTitle().replaceAll(" ", "").toLowerCase())) {

                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
                System.out.println("URL: " + eachURL);
                System.out.println("TITLE: " + driver.getTitle());
            }


        }


        driver.quit();
    }
}
