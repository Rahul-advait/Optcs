package org.testclasses;

import base.BaseClassTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class VerifyRegisterFeature extends BaseClassTest {
    @AfterMethod
    public void setUpRegister() {
        if (!driver.getCurrentUrl().endsWith("register")) {
            driver.navigate().back();
        }
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
}
