package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterUserPage_DS;
import utility.ConfigReader;


public class RegisterUserTest_DS extends TestBase {

    private static final Logger logger = LogManager.getLogger(RegisterUserPage_DS.class);
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
        logger.info("===============================================================");
        Assert.assertEquals(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().getPageTitle(), "Automation Exercise");
        logger.info("Giriş sayfası doğrulandı");
    }

    private void initiateRegistration() {
        logger.info("===============================================================");
        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().startRegistration();

        Assert.assertTrue(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().isSignUpFormVisible());
        logger.info("Giriş başarılı");
    }

    private void fillAccountDetails() {
        logger.info("===============================================================");
        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().fillAccountDetails();
        logger.info("Giriş başarılı");
    }

    private void fillAddressAndCreateAccount() {
        logger.info("===============================================================");
        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().fillAddressInformation();

        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().submitAccountCreation();
        logger.info("Kişisel bilgiler dolduruldu");
    }

    private void verifyAccountCreation() {
        logger.info("===============================================================");
        Assert.assertTrue(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().isAccountCreatedVisible());

        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().submitAccountContinue();

        Assert.assertTrue(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().isLoggedVisible());
        logger.info("Adres bilgiler dolduruldu");
    }

    private void completeRegistrationAndVerify() {
        logger.info("===============================================================");
        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().completeRegistration();

        Assert.assertTrue(getAppLibrary().getPageLibrary().getRegisterUserPage_ds().isAccountDeletedVisible());

        getAppLibrary().getPageLibrary().getRegisterUserPage_ds().completeRegistrationContinue();
        logger.info("Kullanıcı oluşturma ve silme başarılı");
    }


}
