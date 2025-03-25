package tests;

import org.testng.annotations.Test;
import utility.ConfigReader;

public class RegisterUserTest extends TestBase{
    @Test(groups = {"regression", "smoke"},
            description = "Test Case 1: Register User")
    public void createNewAccount() {
        String webSiteUrl = ConfigReader.getProperty("url");

        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);
        getAppLibrary().getPageLibrary().getRegisterUserPage().createNewRegistration();


    }
}
