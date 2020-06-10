package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    /**
     * 3.Open chrome browser
     * 4.Visit all the websitesfrom step 3 and verify that they all have the same title.
     * 5.Verify that all URLs of all pages start with http://practice.cybertekschool.com.
     * 6.Close the browser at the end of the test.
     */

    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");


        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
            driver.get(url);
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            if ((driver.getTitle().equals(driver.getTitle())) && (driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com"))) {
                System.out.println("ALL TEST PASSED");
            }

        }

        driver.quit();
    }
}
