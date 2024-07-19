package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.models.CredentialLogin;
import com.erp.com.pages.LoginPage;
import erp.com.constants.ConstantGlobal;
import erp.com.driver.DriverManager;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;


import java.util.List;
import java.util.Map;

import static erp.com.ulitilities.WebUI.*;


public class LoginSteps {
    private LoginPage loginPage;
    private TestContext testContext;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getLoginPage();
    }

    private static final By warning = By.xpath("//span[@id='input-error']");


    @Given("User go to the log in page")
    public void userGoToTheLogInPage() {
        openURL(ConstantGlobal.URL);
        waitForPageLoaded();
        loginPage.selectLanguage(ConstantGlobal.LANGUAGE_ENGLISH);
    }

    @When("User enter username and password")
    public void userEnterUsernameAndPassword() {
        loginPage.enterEmailAndPassword(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
    }

    @And("Click on Login button")
    public void clickOnLoginButton() {
        loginPage.clickLogin();
    }


    @Then("User should be taken to the Company list")
    public void userShouldBeTakenToTheCompanyList() {
        waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//app-page-title//span[@data-cy='company-list-title']")).isDisplayed());

    }

    @And("User should see the company list page")
    public void userShouldSeeTheCompanyListPage() {
        Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//app-page-title//span[@data-cy='company-list-title']")).isDisplayed());
    }


    @When("User enter {string} and {string}")
    public void userEnterAnd(String arg0, String arg1) {
        loginPage.enterEmailAndPassword(arg0, arg1);
    }

    @Then("Users login failed")
    public void usersLoginFailed() {
        waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//img)[7]")).isDisplayed());
    }

    @And("The warning invalid email should be displayed")
    public void theWarningShouldBeDisplayed() {
        if (checkNull(warning)) {
            Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//span[@id='input-error-email-invalid']")).isDisplayed());
        } else {
            Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//span[@id='input-error']")).isDisplayed());
        }
    }

//    @DataTableType
//    public CredentialLogin credentialsEntry(Map<String, String> entry) {
//        return new CredentialLogin(entry.get("username"), entry.get("password"));
//    }
//
//    @When("user enter valid credentials to login")
//    public void userEnterValidCredentialsToLogin(List<CredentialLogin> credentialLogins) {
//        for (CredentialLogin credential :  credentialLogins) {
//            loginPage.enterEmailAndPassword(credential.getUsername(), credential.getPassword());
//            loginPage.clickLogin();
//        }
//    }
}
