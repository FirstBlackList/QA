package testFormQa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObject.base.TestBaseExtended;
import testFormQa.random.RandomData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class testFormDr {

    /*@BeforeEach
    void setUp() {
        Configuration.pageLoadTimeout = 70000;
        //Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }*/



    @Test
    void testForm3Faker() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        String name = RandomData.randomFirstName();
        String lastName = RandomData.randomLastName();
        String email = RandomData.randomEmail();
        String phone = RandomData.randomPhone();

        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);

        $("#gender-radio-2").parent().click();
        //$x("//input[@id='gender-radio-3']/parent::div").click();
        //executeJavaScript("setTimeout(function() {document.getElementById('gender-radio-3').click();}, 2000)");

        $("#userNumber").setValue(phone);

        $("#dateOfBirthInput").click();
        String month = "September";
        $(".react-datepicker__month-select").selectOption(month);
        String year = "1993";
        $(".react-datepicker__year-select").selectOption(year);

        String day = "06";
        //перед числами из одной цифры подставлять ноль (пример 01, 07 и.т.д)
        $x("//div[contains(@class, 'react-datepicker__day--0" + day + "')]" +
                "[not(contains(@class, 'react-datepicker__day--outside-month'))]").click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(".subjects-auto-complete__multi-value").shouldHave(text("English"), visible);

        $x("//label[@for='hobbies-checkbox-2']/parent::div").click();

        $("#uploadPicture").scrollTo().uploadFromClasspath("fileupload/screenshot.jpg");

        $("#currentAddress").scrollTo().setValue("Address one");

        $("#state").click();
        $(byText("Uttar Pradesh")).shouldBe(visible).click();
        $("#city").click();
        $(byText("Agra")).click();

        $("#submit").pressEnter();



        $(".modal-header").$(byText("Thanks for submitting the form"))
                .shouldBe(visible);
        $(".modal-body").shouldHave(visible,
                text(name),
                text(email),
                text(phone),
                text("06 September,1993")
        );

        $("#closeLargeModal").pressEnter();

    }
}
