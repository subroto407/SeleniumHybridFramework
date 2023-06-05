package com.internet.Herokuapp.TestCases;


import com.internet.Herokuapp.Configuaration.BaseClass;
import com.internet.Herokuapp.LandingPageConfiguaration.LandingPage;
import com.internet.Herokuapp.Pages.DigestAuth;
import com.internet.Herokuapp.Utilites.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DigestAuthentication extends BaseClass {
    @Test
    public void digestAuthentication(){

        LandingPage lp = new LandingPage(driver);
        DigestAuth dauth = new DigestAuth(driver);


        //HOME URL Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given "+baseLink);
        Assert.assertEquals(baseLink, TestData.BASE_URL);
        System.out.println("Home URL is valid");
        sleepTime(2000);

        //DigestAuthentication Text validation in Base page
        if(lp.getDigestAuthentication().isDisplayed()){
            String digestAuthText= lp.getDigestAuthentication().getText();
            Assert.assertTrue(true,digestAuthText);
        }
        else {
            System.out.println(TestData.NEGATIVE_ERROR_MASSAGE);
        }
        lp.getDigestAuthentication().click();
        sleepTime(1000);

        //Value Pass On input Field login popup
        driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
        //// ... Get the URL
        //driver.get("https://<username>:<password>@www.example.com/index.html")
        sleepTime(2000);

        //Header Validation
        if(dauth.getHeader().isDisplayed()){
            String headerText= dauth.getHeader().getText();
            Assert.assertTrue(true,headerText);
            System.out.println(TestData.POSITIVE_MASSAGE);
        }
        else {
            System.out.println(TestData.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTime(2000);

        //Paragraph Validation
        if(dauth.getParagraph().isDisplayed()){
            String paragraphText= dauth.getParagraph().getText();
            Assert.assertTrue(true,paragraphText);
        }
        else {
            System.out.println(TestData.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTime(2000);
        driver.navigate().back();

    }
}
