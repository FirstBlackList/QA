package testFormQa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import testFormQa.random.RandomData;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class testForm {

    @BeforeEach
    void setUp() {
        //Configuration.pageLoadTimeout = 70000;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testForm() {
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Petr");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("petro@gmail.com");


        $("#gender-radio-1").parent().click();
        //$(byText("Male")).click();
        $("#userNumber").setValue("8888888888");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("July")).shouldBe(visible).click();

        //$(byText("July")).shouldBe(visible).click();

        $x("//div[contains(@class, 'react-datepicker__day--030 react-datepicker__day--weekend')]").click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("S");
        $$x("//div[contains(@id, 'react-select-2-option')]").first().shouldBe(visible).click();


        $(byText("Music")).click();
        $("#uploadPicture").scrollTo().uploadFromClasspath("1.png");
        $("#currentAddress").scrollTo().setValue("Address");
        $x("//div[@id='state']").scrollTo().click();
        $(byText("Haryana")).click();
        $x("//div[@id='city']").click();
        $(byText("Karnal")).click();

        //$("#submit").pressEnter();

        executeJavaScript("setTimeout(function() {document.getElementById('submit').click();}, 2000)");

        //$x("//div[contains(@class, 'text-right')]").shouldHave(visible, Duration.ofSeconds(6)).click();

//        SelenideElement button = $("#submit");
//        Selenide.actions().moveToElement((WebElement) byText("Submit"), 0, 10).click().build().perform();
        //actions().moveToElement($("#submit")).clickAndHold().moveByOffset(0, 10).click().build().perform();
        //$(byText("Close")).click();

    }


    @Test
    void testForm2() {
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Leonid");
        $("#lastName").setValue("Leon");
        $("#userEmail").setValue("leonid@gmail.com");

        $("#gender-radio-2").parent().click();
        //$x("//input[@id='gender-radio-3']/parent::div").click();
        //executeJavaScript("setTimeout(function() {document.getElementById('gender-radio-3').click();}, 2000)");

        $("#userNumber").setValue("8123456789");

        $("#dateOfBirthInput").click();
        String month = "September";
        $(".react-datepicker__month-select").selectOption(month);
        String year = "1993";
        $(".react-datepicker__year-select").selectOption(year);

        //<div class="react-datepicker__day react-datepicker__day--004" >4</div>

        //<div class="react-datepicker__day react-datepicker__day--004 react-datepicker__day--outside-month" >4</div>

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
                text("Leonid Leon"),
                text("leonid@gmail.com"),
                text("8123456789"),
                text("06 September,1993")
        );

        $("#closeLargeModal").pressEnter();

    }


    @Test
    void testForm3Faker() {
        executeJavaScript("$('footer').remove()");

        String name = new RandomData().randomFirstName();
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
