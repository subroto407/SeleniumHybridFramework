package com.internet.Herokuapp.TestCases;


import com.internet.Herokuapp.Configuaration.BaseClass;
import com.internet.Herokuapp.LandingPageConfiguaration.LandingPage;
import com.internet.Herokuapp.Pages.HorizontalSliderPage;
import com.internet.Herokuapp.Utilites.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSlider extends BaseClass {
    @Test
    public void horizontalSlider(){

        LandingPage lp = new LandingPage(driver);
        HorizontalSliderPage hsp =new HorizontalSliderPage(driver);

        //Navigate to the Corresponding Page
        lp.getHorizontalSlider().click();
        sleepTime(2000);

        //Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, TestData.BASE_URL+TestData.HORIZONTAL_SLIDER_LINK);
        System.out.println("Link is valid");
        sleepTime(2000);


        //Header Validation
        if( hsp.getHorizontalSliderHeader().isDisplayed()){
            String header = hsp.getHorizontalSliderHeader().getText() ;
            Assert.assertEquals(header,TestData.HORIZONTAL_SLIDER_HEADER);
            System.out.println("Header Text is valid");

        }
        else{
            System.out.println(TestData.NEGATIVE_ERROR_MASSAGE);
        }

        WebElement slider = driver.findElement(By.xpath("/html//div[@id='content']//input[@value='0']"));

        for (int i = 0; i <= 11; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }




        //Using Action Class TO drag the slider
        //Horizontal Slider Validation
//        Actions move = new Actions(driver);
//        Action action = move.dragAndDropBy(slider, 20, 0).build();
//        action.perform();
//        sleepTime(2000);

//        //Slider Value Validation
//        String value =driver.findElement(By.xpath("/html//span[@id='range']")).getText();
//        System.out.println( "Dragged Value " +value);
//        String val ="3.5";
//        Assert.assertEquals(value ,val );





    }
}
