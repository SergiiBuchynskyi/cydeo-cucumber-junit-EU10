package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserNazimPage {

    public RegisterUserNazimPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//body")
    public WebElement pageLoaded;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    public WebElement signupLogin;

    @FindBy(css = "div[class=\"signup-form\"] h2")
    public WebElement newUserSignup;

    @FindBy(xpath = "//input[@type=\"text\"]")
    public WebElement signupName;

    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    public WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa=\"signup-button\"]")
    public WebElement signupButton;

    @FindBy(xpath = "(//h2[@class='title text-center']/b)[1]")
    public WebElement enterAccountInformation;

    @FindBy(xpath = "//*[@id='id_gender1']")
    public WebElement title;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement name;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;



    @FindBy(xpath = "//*[@id='newsletter']")
    public WebElement newsletter;

    @FindBy(xpath = "//*[@id='optin']")
    public WebElement receiveOffers;

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='company']")
    public WebElement company;

    @FindBy(xpath = "//*[@id='address1']")
    public WebElement address1;

    @FindBy(xpath = "//*[@id='address2']")
    public WebElement address2;



    @FindBy(xpath = "//*[@id='state']")
    public WebElement state;

    @FindBy(xpath = "//*[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//*[@id='zipcode']")
    public WebElement zipcode;

    @FindBy(xpath = "//*[@id='mobile_number']")
    public WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa=\"create-account\"]")
    public WebElement createAccountBtn;

    @FindBy(xpath = "//h2[@class='title text-center']/b")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement continueBtn;

    @FindBy(xpath = "//i[@class='fa fa-user']/..")
    public WebElement loggedInAsText;

    @FindBy(xpath = "//i[@class='fa fa-user']/../b")
    public WebElement loggedInAsName;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountBtn;

    @FindBy(xpath = "//h2[@class='title text-center']/b")
    public WebElement accountDeletedText;





}
