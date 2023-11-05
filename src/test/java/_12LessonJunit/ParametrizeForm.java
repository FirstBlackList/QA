/*package _12LessonJunit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizeForm {

    @BeforeEach
    void setUp() {
        //Configuration.pageLoadTimeout = 70000;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/login");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void prm() {

        $("#newUser").click();
        $("#firstname").setValue("Alex");
        $("#lastname").setValue("Last");
        $("#userName").setValue("login");
        $("#password").setValue("sgtAWI975_!");
        $(".recaptcha-checkbox-border").click();
        Selenide.switchTo().alert().accept();
        $("#gotologin").click();

    }

    *//*@CsvSource({
            "login, sgtAWI975_!",
            "fill, Gtrjgsgy563!!!Here",
            "gregg, poiyywfu6732!PP",
            "ruffolo, gfhvqkh656!TT"
    })*//*
    @CsvFileSource(resources = "/userData.csv")
    @ParameterizedTest(name = "Authorization user by loginName: {0} and password: {1}")
    @Tags({@Tag("BLOCkER"), @Tag("UI_Test")})
    void enterProfile(String valueLogin, String valuePassword) throws InterruptedException {

        $("#userName").setValue(valueLogin);
        $("#password").setValue(valuePassword);
        $("#login").click();
        Thread.sleep(5000);
        $(byText("Profile")).shouldHave(visible, Duration.ofSeconds(8));
        $("#books-wrapper #submit").click();
        $(byText("Login")).shouldBe(visible);

    }

    @CsvFileSource(files = "src/test/resources/userData.csv")
    @ParameterizedTest(name = "Authorization user by loginName: {0} and password: {1}")
    @Tags({@Tag("BLOCkER"), @Tag("UI_Test")})
    void enterProfilePathFromData(String valueLogin, String valuePassword) throws InterruptedException {

        $("#userName").setValue(valueLogin);
        $("#password").setValue(valuePassword);
        $("#login").click();
        Thread.sleep(5000);
        $(byText("Profile")).shouldHave(visible, Duration.ofSeconds(8));
        $("#books-wrapper #submit").click();
        $(byText("Login")).shouldBe(visible);

    }


    static Stream<Arguments> enterProfileMethod() {
        return Stream.of(
                Arguments.of("login", "sgtAWI975_!"),
                Arguments.of("fill", "Gtrjgsgy563!!!Here"),
                Arguments.of("gregg", "poiyywfu6732!PP"),
                Arguments.of("ruffolo", "gfhvqkh656!TT")

        );
    }

    @MethodSource("enterProfileMethod")
    @ParameterizedTest(name = "Authorization user by loginName: {0} and password: {1}")
    @Tag("BLOCKER")
    void enterProfileMethodSource(
            String valueLogin, String valuePassword
    ){

        $("#userName").setValue(valueLogin);
        $("#password").setValue(valuePassword);
        $("#login").click();
        $(byText("Profile")).shouldHave(visible, Duration.ofSeconds(8));
        $("#books-wrapper #submit").click();
        $(byText("Login")).shouldBe(visible);
    }


    @MethodSource("enterProfileMethod")
    @ParameterizedTest(name = "Authorization user by |Password: {1}| and name of |User: {0}|")
    @Tag("BLOCKER")
    void enterProfileMethodSource1(
            String valueLogin, String valuePassword
    ){

        $("#userName").setValue(valueLogin);
        $("#password").setValue(valuePassword);
        $("#login").click();
        $(byText("Profile")).shouldHave(visible, Duration.ofSeconds(8));
        $("#books-wrapper #submit").click();
        $(byText("Login")).shouldBe(visible);
    }
}*/
