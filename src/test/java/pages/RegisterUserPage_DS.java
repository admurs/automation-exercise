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


    public void startRegistration() {
        clickElement(registerUserElements.signUpLoginButton);
        String email = getFaker().internet().emailAddress();
        String name = getFaker().name().name();
        sendKeyToElement(registerUserElements.nameText, name);
        sendKeyToElement(registerUserElements.emailText, email);
        clickElement(registerUserElements.signUpButton);
    }


    public void fillAccountDetails() {
        clickElement(titleSelected(registerUserElements.titleRadioButton));
        String password = getFaker().internet().password();
        sendKeyToElement(registerUserElements.accountPasswordText, password);
        selectBirthDate();
        clickElement(registerUserElements.checkBox1);
        clickElement(registerUserElements.checkBox2);
    }


    public void fillAddressInformation() {
        String firstName = getFaker().name().firstName();
        String lastName = getFaker().name().lastName();
        String companyName = getFaker().company().name();
        String address = getFaker().address().fullAddress();
        String address2 = getFaker().address().secondaryAddress();
        String state = getFaker().address().state();
        String city = getFaker().address().city();
        String zipCode = getFaker().address().zipCode();
        String mobile = getFaker().phoneNumber().cellPhone();
        sendKeyToElement(registerUserElements.firstNameText, firstName);
        sendKeyToElement(registerUserElements.lastNameText, lastName);
        sendKeyToElement(registerUserElements.companyNameText, companyName);
        sendKeyToElement(registerUserElements.addressText, address);
        sendKeyToElement(registerUserElements.address2Text, address2);
        selectCountry(registerUserElements.countryDrop);
        sendKeyToElement(registerUserElements.stateText, state);
        sendKeyToElement(registerUserElements.cityText, city);
        sendKeyToElement(registerUserElements.zipcodeText, zipCode);
        sendKeyToElement(registerUserElements.mobileNumberText, mobile);
        scrollTo(registerUserElements.createAccountButton);


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

    public boolean isLoggedVisible() {
        return isElementVisible(registerUserElements.userNameVerifyText, 1);
    }

    public String getPageTitle() {
        return getCurrentPageTitle();
    }
}