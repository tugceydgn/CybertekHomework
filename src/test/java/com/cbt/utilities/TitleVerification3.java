package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver chromeDriver = BrowserFactory.getDriver("chrome");


        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com");  //westelm.com blocked me. That's why I deleted it

        for (String eachURL : urls) {

            chromeDriver.get(eachURL);
            Thread.sleep(6000);

            if (eachURL.contains(chromeDriver.getTitle().replaceAll(" ", "").toLowerCase())) {

                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
                System.out.println("URL: " + eachURL);
                System.out.println("TITLE: " + chromeDriver.getTitle());
            }
            Thread.sleep(3000);
            chromeDriver.quit();

            WebDriver firefoxDriver = BrowserFactory.getDriver("firefox");
            for (String eachFirefoxURL : urls) {

                firefoxDriver.get(eachURL);
                Thread.sleep(6000);

                if (eachFirefoxURL.contains(firefoxDriver.getTitle().replaceAll(" ", "").toLowerCase())) {

                    System.out.println("TEST PASSED");
                } else {
                    System.out.println("TEST FAILED");
                    System.out.println("URL: " + eachFirefoxURL);
                    System.out.println("TITLE: " + firefoxDriver.getTitle());
                }
                Thread.sleep(3000);
                firefoxDriver.quit();

                WebDriver edgeDriver = BrowserFactory.getDriver("edge");
                for (String eachEdgeURL : urls) {

                    edgeDriver.get(eachURL);
                    Thread.sleep(6000);

                    if (eachEdgeURL.contains(edgeDriver.getTitle().replaceAll(" ", "").toLowerCase())) {

                        System.out.println("TEST PASSED");
                    } else {
                        System.out.println("TEST FAILED");
                        System.out.println("URL: " + eachEdgeURL);
                        System.out.println("TITLE: " + edgeDriver.getTitle());
                    }


                    Thread.sleep(3000);
                    edgeDriver.quit();


                }
            }
        }
    }
}