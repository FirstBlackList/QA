package pageObject;

import io.qameta.allure.*;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObject.base.TestBase;
import pageObject.base.TestBaseExtended;
import pageObject.page.RegistrationPage;
import testFormQa.random.RandomData;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static io.qameta.allure.Allure.step;

public class TestFormPageWithDriver extends TestBaseExtended {

    @Test
    @Tag("remote")
    /*@Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Owner("Sergey")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "QA", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение формы регистрации")*/
    void testFormDriver() {

        String firstName = RandomData.randomFirstName();
        String lastName = RandomData.randomLastName();
        String email = RandomData.randomEmail();
        String phone = RandomData.randomPhone();
        String address = RandomData.randomAddress();

        step("Заполнение формы", () -> {
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
        });


        step("Checked forms", () -> {
            new RegistrationPage()
                    .verifyModalWindow()
                    .verifyResults("Student Name", firstName)
                    .verifyResults("Student Email", email)
                    .verifyResults("Mobile", phone)
                    .verifyResults("Gender", "Male")
                    .verifyResults("Date of Birth", "30 September,2008")
                    .verifyResults("Address", address)
                    .closeModalWindow();
        });



    }
}
