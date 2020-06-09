package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests_Chrome {

    public static void main(String[] args) {


        /**
         * 1. Open browser
         * 2.Go to website https://google.com
         * 3. Save the title in a string variable
         * 4. Go to https://etsy.com
         * 5. Save the title in a string variable
         * 6. Navigate back to previous page
         * 7. Verify that title is same is in step 3
         * 8. Navigate forward to previous page
         * 9. Verify that title is same is in step 5
         */


        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://google.com");
        String expectedGoogleTitle = "Google";
        driver.navigate().to("https://etsy.com");
        String expectedEtsyTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        driver.navigate().back();
        String actualGoogle = driver.getTitle();

        driver.navigate().forward();
        String actualEtsyTitle = driver.getTitle();

        StringUtility.verifyEquals(expectedGoogleTitle, actualGoogle);
        StringUtility.verifyEquals(expectedEtsyTitle, actualEtsyTitle);


        driver.quit();


    }
}