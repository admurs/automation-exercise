package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

import java.util.Map;

public class RegisterUserTest_DS extends TestBase {

    Map<String, String> userData;
    String webSiteUrl = ConfigReader.getProperty("url");

    @Test(groups = {"regression", "smoke"}, description = "Test Case 1: Register User")
    public void testCompleteRegistrationFlow() {
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);

        verifyPageTitle();
        initiateRegistration();
        fillAccountDetails();
        fillAddressAndCreateAccount();
        verifyAccountCreation();
        completeRegistrationAndVerify();
    }

    private void verifyPageTitle() {
        Assert.assertEquals(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().getPageTitle(), "Automation Exercise");
    }

    private void initiateRegistration() {
        userData = getAppLibrary().getPageLibrary().getRegisterUserPage_ds().startRegistration();

        Assert.assertTrue(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().isSignUpFormVisible());
    }

    private void fillAccountDetails() {
        userData = getAppLibrary().getPageLibrary().getRegisterUserPage_ds().fillAccountDetails(userData);
    }

    private void fillAddressAndCreateAccount() {
        userData = getAppLibrary().getPageLibrary().getRegisterUserPage_ds().fillAddressInformation(userData);
        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().submitAccountCreation();
    }

    private void verifyAccountCreation() {

        Assert.assertTrue(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().isAccountCreatedVisible());

        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().submitAccountContinue();

        Assert.assertEquals(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().getLoggedInUsername(), userData.get("name"));
    }

    private void completeRegistrationAndVerify() {
        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().completeRegistration();

        Assert.assertTrue(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().isAccountDeletedVisible());

        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().completeRegistrationContinue();
    }


}
