package org.testclasses;

import PageClasses.ForgotPassword;
import PageClasses.LoginPage;
import PageClasses.Overview;
import Utilities.Constants;
import base.BaseClassTest;
import base.CheckPoint;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompanyDashLogin extends BaseClassTest {
    ForgotPassword forgotPasswordPage;
    LoginPage loginPage;
    Overview overview;

    @BeforeClass
    @Override
    public void beforeSetUp() {
        super.beforeSetUp();
        loginPage = header.clickLoginBtn();
    }

    @BeforeMethod
    public void methodSetUp() {
        CheckPoint.clearHashMap();
    }

    @AfterMethod
    public void setUpRegister() {
        log.info("-".repeat(50));
        if (!driver.getCurrentUrl().contains("login")){
            driver.navigate().to(Constants.BASE_URL+"login");
        }
    }

    @Test
    public void validLogin() {
        overview = loginPage.login();
        boolean isLogin = overview.isOpen();
        Assert.assertTrue(isLogin, "Verify if user is logged in");
    }

    @Test
    public void invalidEmail() {
        overview = loginPage.login("email");
        boolean isAlertPresent = loginPage.isAlertPresent("Invalid Credentials");
        CheckPoint.mark("Verify alert", isAlertPresent, " is present with valid text");

        boolean isLogin = overview.isOpen();
        CheckPoint.markFinal("Verify logged in", !isLogin, " with invalid cred");

    }

    @Test
    public void invalidPassword() {
        overview = loginPage.login("password");

        boolean isAlertPresent = loginPage.isAlertPresent("Invalid Credentials");
        CheckPoint.mark("Verify alert", isAlertPresent, " is present with valid text");

        boolean isLogin = overview.isOpen();
        CheckPoint.markFinal("Verify logged in", !isLogin, " with invalid cred");
    }

    @Test
    public void rememberMe() {
        overview = loginPage.login(true);
        header = overview.logout();
        loginPage = header.clickLoginBtn();
        boolean verifyPrefilled = loginPage.checkAttributes();
        Assert.assertTrue(verifyPrefilled, "Verify prefilled email and password");
    }

    @Test
    public void verifyForgotPass() {
        forgotPasswordPage = loginPage.clickForgotPasLink();
        boolean isForgotPageOpen = forgotPasswordPage.isOpen();
        CheckPoint.mark("Verify forgot pass link",
                isForgotPageOpen, "Is forgot pass link working");
        boolean isSuccessNotification = forgotPasswordPage.enterValidEmail();
        Assert.assertTrue(isSuccessNotification);
    }

    @Test
    public void verifyForgotPassInvalidEmail() {
        forgotPasswordPage = loginPage.clickForgotPasLink();
        boolean isForgotPageOpen = forgotPasswordPage.isOpen();
        CheckPoint.mark("Verify forgot pass link",
                isForgotPageOpen, "Is forgot pass link working");
        boolean isErrorNotification = forgotPasswordPage.enterInvalidEmail();
        Assert.assertTrue(isErrorNotification);
    }

}
