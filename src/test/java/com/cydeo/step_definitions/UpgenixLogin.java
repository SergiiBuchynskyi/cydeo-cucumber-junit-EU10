package com.cydeo.step_definitions;

import com.cydeo.pages.UpgenixLoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UpgenixLogin {

    UpgenixLoginPage upgenixLoginPage = new UpgenixLoginPage();
    int countFailedAccounts = 0;

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get("https://qa.upgenix.net/");
    }
    @When("user enters {string} and {string} in range of {int} to {int}")
    public void userEntersLoginAndPasswordInRangeOfStartToEnd(String login, String password, int start, int end) {
        for (int i = start; i <= end; i++) {
            upgenixLoginPage.loginFormControl.sendKeys(login + i + "@info.com");
            upgenixLoginPage.passwordFormControl.sendKeys(password);
            upgenixLoginPage.log.click();

            if (Driver.getDriver().getTitle().contains("Odoo")) {
                upgenixLoginPage.logOutStep1.click();
                upgenixLoginPage.logOutStep2.click();
            } else {
                System.out.println(login + i + "@info.com" + " - " + password + " is invalid credentials!");
                upgenixLoginPage.loginFormControl.clear();
                upgenixLoginPage.passwordFormControl.clear();
                countFailedAccounts++;
            }
        }

        System.out.println("Total accounts invalid: " + countFailedAccounts);
        Assert.assertEquals(0, countFailedAccounts);
    }
}
