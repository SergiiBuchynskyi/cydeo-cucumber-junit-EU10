package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpgenixLoginPage {

    public UpgenixLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "//*[@id='login']")
    public WebElement loginFormControl;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordFormControl;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement log;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement logOutStep1;

    @FindBy(xpath = "//a[.='Log out']")
    public WebElement logOutStep2;

}
