package pages;

import elements.RegisterUserElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class RegisterUserPage extends PageBase{
    RegisterUserElements registerUserElements;
    Random random = new Random();
    public void createNewRegistration() {
        registerUserElements = new RegisterUserElements();

        String actualTitle="Automation Exercise";
        String expectedTitle= getCurrentPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        clickElement(registerUserElements.signUpLoginButton);
        String email = getFaker().internet().emailAddress();
        String name = getFaker().name().name();
        sendKeyToElement(registerUserElements.nameText,name);
        sendKeyToElement(registerUserElements.emailText,email);
        clickElement(registerUserElements.signUpButton);
        Assert.assertTrue(isElementVisible(registerUserElements.signUpVerifyText,1));
        clickElement(titleSelected(registerUserElements.titleRadioButton));
        String password = getFaker().internet().password();
        sendKeyToElement(registerUserElements.accountPasswordText, password);
        selectBirthDate();
        clickElement(registerUserElements.checkBox1);
        clickElement(registerUserElements.checkBox2);
        String firstName = getFaker().name().firstName();
        String lastName = getFaker().name().lastName();
        String companyName=getFaker().company().name();
        String address=getFaker().address().fullAddress();
        String address2=getFaker().address().secondaryAddress();
        String state=getFaker().address().state();
        String city=getFaker().address().city();
        String zipCode=getFaker().address().zipCode();
        String mobile=getFaker().phoneNumber().cellPhone();
        sendKeyToElement(registerUserElements.firstNameText,firstName);
        sendKeyToElement(registerUserElements.lastNameText,lastName);
        sendKeyToElement(registerUserElements.companyNameText,companyName);
        sendKeyToElement(registerUserElements.addressText,address);
        sendKeyToElement(registerUserElements.address2Text,address2);
        selectCountry(registerUserElements.countryDrop);
        sendKeyToElement(registerUserElements.stateText,state);
        sendKeyToElement(registerUserElements.cityText,city);
        sendKeyToElement(registerUserElements.zipcodeText,zipCode);
        sendKeyToElement(registerUserElements.mobileNumberText,mobile);
        clickElement(registerUserElements.createAccountButton);
        Assert.assertTrue(isElementVisible(registerUserElements.createAccoutVerifyText,1));
        clickElement(registerUserElements.continueButton);
        Assert.assertEquals(name,registerUserElements.userNameVerifyText.getText());
        clickElement(registerUserElements.deleteAccountButton);
        Assert.assertTrue(isElementVisible(registerUserElements.deleteAccountVerifyText,1));
        clickElement(registerUserElements.deleteContinueButton);


    }
    public WebElement titleSelected(List<WebElement> element){
        return element.get(random.nextInt(element.size()));
    }

    public void selectBirthDate(){
        Select daySelect = new Select(registerUserElements.selectDaysDrop);
        daySelect.selectByValue(String.valueOf(random.nextInt(31) + 1));
        Select monthSelect = new Select(registerUserElements.selectMonthsDrop);
        monthSelect.selectByValue(String.valueOf(random.nextInt(12) + 1));
        Select yearSelect = new Select(registerUserElements.selectYearsDrop);
        yearSelect.selectByValue(String.valueOf(1900 + random.nextInt(122)));
    }
    public void selectCountry(WebElement element){
        Select countrySelect = new Select(element);
        List<WebElement> options = countrySelect.getOptions();
        int randomIndex = random.nextInt(options.size());
        WebElement randomOption = options.get(randomIndex);
        countrySelect.selectByVisibleText(randomOption.getText());
    }
}
