package org.testclasses;

import base.BaseClassTest;
import base.CheckPoint;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompanyDashRegister extends BaseClassTest {

    @BeforeClass
    @Override
    public void beforeSetUp() {
        super.beforeSetUp();
        registerPage = header.clickRegisterBtn();
    }

    @BeforeMethod
    public void methodSetUp() {
        CheckPoint.clearHashMap();
    }

    @AfterMethod
    public void setUpRegister() {
        log.info("-".repeat(50));
        if (!driver.getCurrentUrl().endsWith("register")) {
            driver.navigate().back();
        }
        driver.navigate().refresh();
    }

    @Test
    public void validRegistration() {
        log.info("Starting Valid Registration method");
        registerPage.registerAccount();
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertTrue(isSuccessPageOpen);
    }

    @Test
    public void verifyNameField() {
        log.info("Starting Verify Name field method");
        registerPage.registerAccountEmptyField("name");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyEmailField() {
        log.info("Starting Verify Email field method");
        registerPage.registerAccountEmptyField("email");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyPasswordField() {
        log.info("Starting Verify Password Field");
        registerPage.registerAccountEmptyField("password");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyConfirmPasswordField() {
        log.info("Starting Verify confirm password field");
        registerPage.registerAccountEmptyField("confirm password");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyCompanyNameField() {
        log.info("Starting Verify Company Name method");
        registerPage.registerAccountEmptyField("company name");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyWorkEmailField() {
        log.info("Starting Work Email method");
        registerPage.registerAccountEmptyField("work email");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyTotalEmpField() {
        log.info("Starting Verify Total Employee field");
        registerPage.registerAccountEmptyField("total emp");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyDomainField() {
        log.info("Starting Verify domain field method");
        registerPage.registerAccountEmptyField("company domain");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }

    @Test
    public void verifyUsernameField() {
        log.info("Starting Verify Username field method");
        registerPage.registerAccountEmptyField("username");
        boolean isSuccessPageOpen = registerPage.isRegisterSuccessPage();
        Assert.assertFalse(isSuccessPageOpen);
    }
}
