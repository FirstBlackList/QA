package pageObject;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObject.base.TestBase;
import pageObject.page.RegistrationPage;
import testFormQa.random.RandomData;

import static io.qameta.allure.Allure.step;

public class TestFormPageAllure extends TestBase {

    @Test
    @Tag("less")
    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Owner("Sergey")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "QA", url = "https://demoqa.com")
    @DisplayName("Заполнение формы регистрации")
    void testForm() {
        //SelenideLogger.addListener("allure", new AllureSelenide());


        String firstName = RandomData.randomFirstName();
        String lastName = RandomData.randomLastName();
        String email = RandomData.randomEmail();
        String phone = RandomData.randomPhone();
        String address = RandomData.randomAddress();

        step("Открытие страницы формы регистрации", () -> {
            new RegistrationPage()
                    .openPage();
        });

        step("Заполнение полей 'имя' и 'фамилия'", () -> {
            new RegistrationPage()
                    .setFirstName(firstName)
                    .setLastName(lastName);
        });

        step("Заполнение полей 'email'", () -> {
            new RegistrationPage()
                    .setEmail(email);
        });

        step("Выбор пола", () -> {
            new RegistrationPage()
                    .setGender("1");
        });

        step("Заполнение поля 'телефон'", () -> {
            new RegistrationPage()
                    .setPhone(phone);
        });

        step("Выбор даты в календаре", () -> {
            new RegistrationPage()
                    .setBirthDay("30", "September", "2008");
        });

        step("Выбор субьекта", () -> {
            new RegistrationPage()
                    .setSubjectContainer("English");
        });

        step("Выбор checkbox'a хобби", () -> {
            new RegistrationPage()
                    .setHobbiesCheckbox();
        });

        step("Загрузка файла", () -> {
            new RegistrationPage()
                    .uploadFile("fileupload/screenshot.jpg");
        });

        step("Заполнение поля 'адрес'", () -> {
            new RegistrationPage()
                    .setAddress(address);
        });

        step("Выбор штата и города", () -> {
            new RegistrationPage()
                    .setState("Uttar Pradesh")
                    .setCity("Agra");
        });

        step("Отправка формы, клик по кнопке 'Submit'", () -> {
            new RegistrationPage()
                    .clickSubmitForm();
        });

        step("Проверка введенных данных в модальном окне", () -> {
            new RegistrationPage()
                    .verifyModalWindow()
                    .verifyResults("Student Name", firstName)
                    .verifyResults("Student Email", email)
                    .verifyResults("Mobile", phone)
                    .verifyResults("Gender", "Male")
                    .verifyResults("Date of Birth", "30 September,2008")
                    .verifyResults("Address", address);
        });

        step("Закрытие модального окна", () -> {
            new RegistrationPage()
                    .closeModalWindow();
        });


    }

    @Test
    @Tag("less")
    @Feature("Форма регистрации")
    @Story("Заполнение формы с невалидным номером телефога")
    @Owner("Sergey")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "QA", url = "https://demoqa.com")
    @DisplayName("Заполнение формы регистрации")
    void testFormNoValidPhone() {
        //SelenideLogger.addListener("allure", new AllureSelenide());


        String firstName = RandomData.randomFirstName();
        String lastName = RandomData.randomLastName();
        String email = RandomData.randomEmail();
        String phone = RandomData.invalidPhone();
        String address = RandomData.randomAddress();

        step("Открытие страницы формы регистрации", () -> {
            new RegistrationPage()
                    .openPage();
        });

        step("Заполнение полей 'имя' и 'фамилия'", () -> {
            new RegistrationPage()
                    .setFirstName(firstName)
                    .setLastName(lastName);
        });

        step("Заполнение полей 'email'", () -> {
            new RegistrationPage()
                    .setEmail(email);
        });

        step("Выбор пола", () -> {
            new RegistrationPage()
                    .setGender("1");
        });

        step("Заполнение поля 'телефон'", () -> {
            new RegistrationPage()
                    .setPhone(phone);
        });

        step("Выбор даты в календаре", () -> {
            new RegistrationPage()
                    .setBirthDay("30", "September", "2008");
        });

        step("Выбор субьекта", () -> {
            new RegistrationPage()
                    .setSubjectContainer("English");
        });

        step("Выбор checkbox'a хобби", () -> {
            new RegistrationPage()
                    .setHobbiesCheckbox();
        });

        step("Загрузка файла", () -> {
            new RegistrationPage()
                    .uploadFile("fileupload/screenshot.jpg");
        });

        step("Заполнение поля 'адрес'", () -> {
            new RegistrationPage()
                    .setAddress(address);
        });

        step("Выбор штата и города", () -> {
            new RegistrationPage()
                    .setState("Uttar Pradesh")
                    .setCity("Agra");
        });

        step("Отправка формы, клик по кнопке 'Submit'", () -> {
            new RegistrationPage()
                    .clickSubmitForm();
        });

        step("Проверка введенных данных в модальном окне", () -> {
            new RegistrationPage()
                    .verifyModalWindow()
                    .verifyResults("Student Name", firstName)
                    .verifyResults("Student Email", email)
                    .verifyResults("Mobile", phone)
                    .verifyResults("Gender", "Male")
                    .verifyResults("Date of Birth", "30 September,2008")
                    .verifyResults("Address", address);
        });

        step("Завкрытие модального окна", () -> {
            new RegistrationPage()
                    .closeModalWindow();
        });


    }
}
