package org.testclasses;

import base.BaseClassTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class VerifyRegisterFeature extends BaseClassTest {
    @AfterMethod
    public void setUpRegister() {
        log.info("-".repeat(20));
        if (!driver.getCurrentUrl().endsWith("register")) {
            driver.navigate().back();
        }
        driver.navigate().refresh();
    }

    @Test
    public void validRegistration() {
        registerPage.registerAccount();
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertTrue(isSuccessPageOpen);
    }

    @Test
    public void verifyNameField() {
        registerPage.registerAccountEmptyField("name");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyEmailField() {
        registerPage.registerAccountEmptyField("email");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyPasswordField() {
        registerPage.registerAccountEmptyField("password");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyConfirmPasswordField() {
        registerPage.registerAccountEmptyField("confirm password");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyCompanyNameField() {
        registerPage.registerAccountEmptyField("company name");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyWorkEmailField() {
        registerPage.registerAccountEmptyField("work email");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyTotalEmpField() {
        registerPage.registerAccountEmptyField("total emp");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyDomainField() {
        registerPage.registerAccountEmptyField("company domain");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyUsernameField() {
        registerPage.registerAccountEmptyField("username");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }
}
