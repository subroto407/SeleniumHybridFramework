package com.internet.Herokuapp.TestCases;



import com.internet.Herokuapp.Configuaration.BaseClass;
import com.internet.Herokuapp.LandingPageConfiguaration.LandingPage;
import com.internet.Herokuapp.Pages.InputsPages;
import com.internet.Herokuapp.Utilites.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Input extends BaseClass {

    @Test
    public void input(){

        LandingPage lp = new LandingPage(driver);
        InputsPages ip = new InputsPages(driver);

        lp.getInputs().click();
        sleepTime(2000);

        //Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, TestData.BASE_URL+TestData.INPUTS_LINK);
        System.out.println("Link is valid");
        sleepTime(2000);

        //Entering values
        ip.getInputField().sendKeys(TestData.INPUT_NUMBER);
        sleepTime(2000);
        ip.getInputField().clear();
        sleepTime(2000);

        driver.navigate().to(TestData.BASE_URL);
        sleepTime(2000);







    }
}
