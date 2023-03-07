package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage {


    public WebElement button(String buttonText){
        return Driver.getDriver().findElement(By.xpath("//span[.='"+buttonText+"']"));
    }

    @FindBy(id = "sciOutPut")
    public WebElement outPut;
}
