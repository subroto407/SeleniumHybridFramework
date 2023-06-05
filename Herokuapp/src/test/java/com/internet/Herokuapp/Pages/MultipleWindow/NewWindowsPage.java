package com.internet.Herokuapp.Pages.MultipleWindow;

import com.internet.Herokuapp.Configuaration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWindowsPage extends BasePage {
    public NewWindowsPage(WebDriver driver){
        super(driver);
    }
    //New Header
    @FindBy(css = "body > div > h3")
    public WebElement newHeader;
    public WebElement getNewHeader(){
        return newHeader;
    }
}
