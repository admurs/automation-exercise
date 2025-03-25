package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterUserPage_DS;
import utility.ConfigReader;

import java.util.Map;

public class RegisterUserTest_DS extends TestBase {
    RegisterUserPage_DS registerPage = new RegisterUserPage_DS();
    Map<String, String> userData;

    @Test(groups = {"regression", "smoke"},description = "Test Case 1: Register User")
    public void testCompleteRegistrationFlow() {

        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);

        verifyPageTitle();
        initiateRegistration();
        fillAccountDetails();
        fillAddressAndCreateAccount();
        verifyAccountCreation();
        completeRegistrationAndVerify();
    }

    private void verifyPageTitle() {
        Assert.assertEquals(registerPage.getPageTitle(), "Automation Exercise");
    }

    private void initiateRegistration() {
        userData = registerPage.startRegistration();

        Assert.assertTrue(registerPage.isSignUpFormVisible());
    }

    private void fillAccountDetails() {
        userData = registerPage.fillAccountDetails(userData);
    }

    private void fillAddressAndCreateAccount() {
        userData = registerPage.fillAddressInformation(userData);
        registerPage.submitAccountCreation();
    }

    private void verifyAccountCreation() {

        Assert.assertTrue(registerPage.isAccountCreatedVisible());

        registerPage.submitAccountContinue();

        Assert.assertEquals(registerPage.getLoggedInUsername(), userData.get("name"));
    }

    private void completeRegistrationAndVerify() {
        registerPage.completeRegistration();

        Assert.assertTrue(registerPage.isAccountDeletedVisible());

        registerPage.completeRegistrationContinue();
    }

//git denemesi
}
