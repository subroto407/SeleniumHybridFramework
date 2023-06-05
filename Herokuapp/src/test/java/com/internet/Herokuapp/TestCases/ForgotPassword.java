package com.internet.Herokuapp.TestCases;


import com.internet.Herokuapp.Configuaration.BaseClass;
import com.internet.Herokuapp.LandingPageConfiguaration.LandingPage;
import com.internet.Herokuapp.Pages.ForgotPasswordPage;
import com.internet.Herokuapp.Utilites.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPassword extends BaseClass {

    @Test
    public void forgotPassword (){

        LandingPage lp = new LandingPage(driver);
        ForgotPasswordPage fpp= new ForgotPasswordPage(driver);

        lp.getForgotPassword().click();
        sleepTime(3000);

        //Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, TestData.BASE_URL+TestData.FORGOT_PASSWORD_LINK);
        System.out.println("Link is valid");
        sleepTime(2000);

        //Header Validation
        if (fpp.getForgotPasswordHeader().isDisplayed()){
            String forgotPasswordHeader = fpp.getForgotPasswordHeader().getText();
            Assert.assertTrue(true, forgotPasswordHeader);
            System.out.println("Header is Valid");
        }else {
            System.out.println(TestData.NEGATIVE_ERROR_MASSAGE);
        }

        //Send DATA ON EMAIL FIELD
        fpp.getEmailField().sendKeys(TestData.FORGOT_PASSWORD_PAGE_EMAIL);
        sleepTime(2000);
        fpp.getPasswordRetrieveButton().click();
        sleepTime(2000);

        driver.navigate().to(TestData.BASE_URL);
        sleepTime(3000);

    }
}
