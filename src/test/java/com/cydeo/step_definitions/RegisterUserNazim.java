package com.cydeo.step_definitions;

import com.cydeo.pages.RegisterUserNazimPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserNazim {
    RegisterUserNazimPage registerUserNazimPage = new RegisterUserNazimPage();


    Faker faker = new Faker();
    String username = faker.name().lastName();
    @Given("Launch browser and navigate to url {string}")
    public void navigateToUrlHttpAutomationexerciseCom(String url) {
        Driver.getDriver().get(url);
    }

    @Then("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Automation Exercise"));
        System.out.println(Driver.getDriver().getTitle().equals("Automation Exercise") ? "Page loaded" : "Page not Loaded");
    }

    @And("Click on Signup Login button")
    public void clickOnSignupLoginButton() {
        registerUserNazimPage.signupLogin.click();
    }

    @Then("Verify {string} is visible")
    public void verifyNewUserSignupIsVisible(String expected) {
        String actual = registerUserNazimPage.newUserSignup.getText();
        Assert.assertEquals(actual, expected);
    }

    @And("Enter name and email address")
    public void enterNameAndEmailAddress() {
        registerUserNazimPage.signupEmail.sendKeys(faker.internet().emailAddress());
        registerUserNazimPage.signupName.sendKeys(username);
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        registerUserNazimPage.signupButton.click();
    }

    @Then("Verify that {string} is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible(String expected) {
        String actual = registerUserNazimPage.enterAccountInformation.getText();
        Assert.assertEquals(actual, expected);
    }

    @And("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
        registerUserNazimPage.title.click();

        registerUserNazimPage.password.sendKeys(faker.internet().password());

        Select day = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='days']")));
        Select month = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='months']")));
        Select year = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='years']")));

        day.selectByVisibleText("1");
        month.selectByVisibleText("May");
        year.selectByVisibleText("1979");
    }

    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        registerUserNazimPage.newsletter.click();
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        registerUserNazimPage.receiveOffers.click();
    }

    @And("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fillDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber() {
        registerUserNazimPage.firstName.sendKeys("John");
        registerUserNazimPage.lastName.sendKeys(username);
        registerUserNazimPage.company.sendKeys("Johnson & Johnson inc");
        registerUserNazimPage.address1.sendKeys("One Johnson & Johnson Plaza, New Brunswick, New Jersey 08933.");
        registerUserNazimPage.address2.sendKeys("---");
        Select selectCountry = new Select(Driver.getDriver().findElement(By.xpath("//*[@id='country']")));
        selectCountry.selectByVisibleText("Canada");
        registerUserNazimPage.state.sendKeys("New Jersey");
        registerUserNazimPage.city.sendKeys("New Brunswick");
        registerUserNazimPage.zipcode.sendKeys("08933");
        registerUserNazimPage.mobileNumber.sendKeys("+38(044)498-0888");



    }


    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        registerUserNazimPage.createAccountBtn.click();
    }

    @Then("Verify that {string} is visible.")
    public void verifyThatACCOUNTCREATEDIsVisible(String expected) {
        Assert.assertEquals(registerUserNazimPage.accountCreatedText.getText(), expected);
    }

    @Then("Verify that {string} is visible and click Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton(String expected) {
        String actual = registerUserNazimPage.accountDeletedText.getText();
        Assert.assertEquals(actual,expected);
        registerUserNazimPage.continueBtn.click();

    }


    @And("Click Continue button")
    public void clickContinueButton() {
        registerUserNazimPage.continueBtn.click();
    }

    @Then("Verify that {string} username is visible..")
    public void verifyThatLoggedInAsUsernameIsVisible(String str) {


        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id=\"aswift_1\"]")));
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id=\"ad_iframe\"]")));//aswift_1
        Driver.getDriver().findElement(By.xpath("//div[@id='dismiss-button']")).click();
        Driver.getDriver().switchTo().defaultContent();

        //Driver.getDriver().navigate().refresh();
        String expected = str + " " + username;

       String actual = registerUserNazimPage.loggedInAsText.getText();// + " " + registerUserNazimPage.loggedInAsName.getText();
       Assert.assertEquals(actual,expected);
    }

    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
        registerUserNazimPage.deleteAccountBtn.click();
    }

}
