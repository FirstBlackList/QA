package pageObject;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.base.TestBase;
import pageObject.page.RegistrationPage;
import testFormQa.random.RandomData;

public class TestFormPageWithDriver extends TestBase {

    @Test
    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Owner("Sergey")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "QA", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение формы регистрации")
    void testForm() {

        String firstName = RandomData.randomFirstName();
        String lastName = RandomData.randomLastName();
        String email = RandomData.randomEmail();
        String phone = RandomData.randomPhone();
        String address = RandomData.randomAddress();

        new RegistrationPage()
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("1")
                .setPhone(phone)
                .setBirthDay("30", "September", "2008")
                .setSubjectContainer("English")
                .setHobbiesCheckbox()
                .uploadFile("fileupload/screenshot.jpg")
                .setAddress(address)
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .clickSubmitForm();


        new RegistrationPage()
                .verifyModalWindow()
                .verifyResults("Student Name", firstName)
                .verifyResults("Student Email", email)
                .verifyResults("Mobile", phone)
                .verifyResults("Gender", "Male")
                .verifyResults("Date of Birth", "30 September,2008")
                .verifyResults("Address", address)
                .closeModalWindow();

    }
}
