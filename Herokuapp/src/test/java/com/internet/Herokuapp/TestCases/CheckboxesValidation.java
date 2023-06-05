package com.internet.Herokuapp.TestCases;


import com.internet.Herokuapp.Configuaration.BaseClass;
import com.internet.Herokuapp.LandingPageConfiguaration.LandingPage;
import com.internet.Herokuapp.Pages.CheckBoxesPage;
import com.internet.Herokuapp.Utilites.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesValidation extends BaseClass {

    @Test
    public void checkboxes (){

        LandingPage lp = new LandingPage(driver);
        CheckBoxesPage cbp =new CheckBoxesPage(driver);

        //HOME URL Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given "+baseLink);
        Assert.assertEquals(baseLink, TestData.BASE_URL);
        System.out.println("Home URL is valid");
        sleepTime(1000);

        //Header Validation and click on checkboxes button
        if(lp.getCheckBoxes().isDisplayed()){
            String checkBoxText= lp.getCheckBoxes().getText();
            Assert.assertTrue(true,checkBoxText);
        }
        lp.getCheckBoxes().click();


        //Checkbox 1 selection and Checkbox text validation
        if(cbp.getCheckBox1().isSelected())
        {
            System.out.println(TestData.POSITIVE_MASSAGE+ TestData.CHECK_BOX1_SELECTED);
        }
        else {
            System.out.println(TestData.NEGATIVE_ERROR_MASSAGE);
        }
        cbp.getCheckbox2().click();


        //Checkbox 2 selection and Checkbox text validation
        if(cbp.getCheckbox2().isSelected())
        {
            System.out.println(TestData.POSITIVE_MASSAGE+ TestData.CHECK_BOX2_SELECTED);
        }
        else {
            System.out.println(TestData.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTime( 1000);



        //URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, TestData.BASE_URL+TestData.CHECK_BOX_LINK);
        System.out.println("Link is valid");
        sleepTime(1000);


        sleepTime(1000);
        cbp.getCheckBox1().click();
        sleepTime(1000);
        cbp.getCheckbox2().click();
        sleepTime(1000);
        driver.navigate().to(TestData.BASE_URL);
        sleepTime(1000);
    }
}
