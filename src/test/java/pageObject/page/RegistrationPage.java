package pageObject.page;

import com.codeborne.selenide.SelenideElement;
import pageObject.components.CalendarComponent;
import pageObject.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal rsModal = new RegistrationResultsModal();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement phoneInput = $("#userNumber");
    private final SelenideElement dateOfBirthDay = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesCheckbox = $x("//label[@for='hobbies-checkbox-2']/parent::div");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateSubmit = $("#state");
    private final SelenideElement citySubmit = $("#city");
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String numberGender) {
        //$(byText("Male")).click();
        //$("#genterWrapper").$(byText("value")).click();
        $("#gender-radio-" + numberGender).parent().click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthDay.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectContainer(String subject) {
        $("#subjectsContainer").click();
        subjectInput.setValue(subject).pressEnter();
        $(".subjects-auto-complete__multi-value").shouldHave(text(subject), visible);
        return this;
    }

    public RegistrationPage setHobbiesCheckbox() {
        hobbiesCheckbox.click();
        return this;
    }

    public RegistrationPage uploadFile(String path) {
        uploadPicture.scrollTo().uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.scrollTo().setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateSubmit.click();
        $(byText(state)).shouldBe(visible).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        citySubmit.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmitForm() {
        $("#submit").pressEnter();
        return this;
    }

    public RegistrationPage verifyModalWindow() {
        rsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        rsModal.verifyResult(key, value);
        return this;
    }
    public RegistrationPage closeModalWindow() {
        rsModal.closeModalWindow();
        return this;
    }

}
