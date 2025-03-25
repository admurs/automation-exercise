package pages;

import elements.RegisterUserElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RegisterUserPage_DS extends PageBase {
    private final RegisterUserElements registerUserElements;
    private final Random random = new Random();

    public RegisterUserPage_DS() {
        this.registerUserElements = new RegisterUserElements();
    }


    public Map<String, String> startRegistration() {
        Map<String, String> userData = new HashMap<>();
        clickElement(registerUserElements.signUpLoginButton);
        userData.put("name", getFaker().name().name());
        userData.put("email", getFaker().internet().emailAddress());


        sendKeyToElement(registerUserElements.nameText, userData.get("name"));
        sendKeyToElement(registerUserElements.emailText, userData.get("email"));
        clickElement(registerUserElements.signUpButton);

        return userData;
    }


    public Map<String, String> fillAccountDetails(Map<String, String> userData) {
        userData.put("password", getFaker().internet().password());

        clickElement(titleSelected(registerUserElements.titleRadioButton));
        sendKeyToElement(registerUserElements.accountPasswordText, userData.get("password"));
        selectBirthDate();
        clickElement(registerUserElements.checkBox1);
        clickElement(registerUserElements.checkBox2);

        return userData;
    }


    public Map<String, String> fillAddressInformation(Map<String, String> userData) {
        userData.put("firstName", getFaker().name().firstName());
        userData.put("lastName", getFaker().name().lastName());
        userData.put("company", getFaker().company().name());
        userData.put("address", getFaker().address().fullAddress());
        userData.put("address2", getFaker().address().secondaryAddress());
        userData.put("state", getFaker().address().state());
        userData.put("city", getFaker().address().city());
        userData.put("zipCode", getFaker().address().zipCode());
        userData.put("mobile", getFaker().phoneNumber().cellPhone());

        sendKeyToElement(registerUserElements.firstNameText, userData.get("firstName"));
        sendKeyToElement(registerUserElements.lastNameText, userData.get("lastName"));
        sendKeyToElement(registerUserElements.companyNameText, userData.get("company"));
        sendKeyToElement(registerUserElements.addressText, userData.get("address"));
        sendKeyToElement(registerUserElements.address2Text, userData.get("address2"));
        selectCountry(registerUserElements.countryDrop);
        sendKeyToElement(registerUserElements.stateText, userData.get("state"));
        sendKeyToElement(registerUserElements.cityText, userData.get("city"));
        sendKeyToElement(registerUserElements.zipcodeText, userData.get("zipCode"));
        sendKeyToElement(registerUserElements.mobileNumberText, userData.get("mobile"));

        return userData;
    }

    public void submitAccountCreation() {
        clickElement(registerUserElements.createAccountButton);

    }

    public void submitAccountContinue() {

        clickElement(registerUserElements.continueButton);
    }


    public void completeRegistration() {

        clickElement(registerUserElements.deleteAccountButton);

    }

    public void completeRegistrationContinue() {


        clickElement(registerUserElements.deleteContinueButton);
    }


    private WebElement titleSelected(List<WebElement> elements) {
        return elements.get(random.nextInt(elements.size()));
    }

    private void selectBirthDate() {
        Select daySelect = new Select(registerUserElements.selectDaysDrop);
        daySelect.selectByValue(String.valueOf(random.nextInt(31) + 1));

        Select monthSelect = new Select(registerUserElements.selectMonthsDrop);
        monthSelect.selectByValue(String.valueOf(random.nextInt(12) + 1));

        Select yearSelect = new Select(registerUserElements.selectYearsDrop);
        yearSelect.selectByValue(String.valueOf(1900 + random.nextInt(122)));
    }

    private void selectCountry(WebElement dropdown) {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        select.selectByVisibleText(options.get(random.nextInt(options.size())).getText());
    }


    public boolean isSignUpFormVisible() {
        return isElementVisible(registerUserElements.signUpVerifyText, 1);
    }

    public boolean isAccountCreatedVisible() {
        return isElementVisible(registerUserElements.createAccoutVerifyText, 1);
    }

    public boolean isAccountDeletedVisible() {
        return isElementVisible(registerUserElements.deleteAccountVerifyText, 1);
    }

    public String getLoggedInUsername() {
        return registerUserElements.userNameVerifyText.getText();
    }

    public String getPageTitle() {
        return getCurrentPageTitle();
    }
}