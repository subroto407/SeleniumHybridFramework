package com.internet.Herokuapp.TestCases.FormAuthenticationValidation;

import com.internet.Herokuapp.Configuaration.BaseClass;
import com.internet.Herokuapp.LandingPageConfiguaration.LandingPage;
import com.internet.Herokuapp.Pages.FormAuthenticationValidate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidUserNamePassword extends BaseClass {

    @Test
    public void validUserNamePassword(){
        LandingPage lp = new LandingPage(driver);
        FormAuthenticationValidate fav = new FormAuthenticationValidate(driver);


        //click on form authentication link
        lp.getFormAuthentication().click();
        sleepTime(1000);

        //enter valid username
        fav.getUserName().sendKeys("tomsmith");
        sleepTime(1000);

        //enter valid password
        fav.getPassword().sendKeys("SuperSecretPassword!");
        sleepTime(1000);

        //click on login button
        fav.getLoginClick().click();
        sleepTime(1000);

        //validate login secure area massage
        WebElement secureMassage = driver.findElement(By.cssSelector("#flash"));
        String actualLoginSecureMassage = secureMassage.getText();
        String expectedLoginSecureMassage = "You logged into a secure area!\n"+"×";
        Assert.assertEquals(actualLoginSecureMassage ,expectedLoginSecureMassage);

    }

}
