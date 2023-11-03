package test_3.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin {

    @Test
    public void testLoginError() throws InterruptedException {
        //Configuration.holdBrowserOpen = true;
        Configuration.browser = "firefox";
        open("https://qa.guru/cms/system/login");
        $(".login-form").shouldHave(text("Войти"));
        $("[name=email]").setValue("qagurubot@gmail.com");
        $("[name=password]").setValue("qagurupassword").pressEnter();
        //$(".xdget-button").click();
        $(".xdget-block").shouldHave(visible);

    }

    @Test
    public void testLoginSuccess() throws InterruptedException {
        //Configuration.holdBrowserOpen = true;
        //Configuration.browser = "firefox";

        open("https://qa.guru/cms/system/login");
        $(".login-form").shouldHave(text("Войти"));
        $("[name=email]").setValue("azokblack@gmail.com");
        $("[name=password]").setValue("A1+a&L&0Cz");
        $(".xdget-button").click();
        $("[class='main-header__login']").click();
        $(".xdget-block").shouldHave(text("Здравствуйте, Сергей"), visible);

    }

    @Test
    void successfulSearchTest() {

        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }


    @Test
    void itShouldName() {

        // ctrl + alt + v = variables
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse("12.10.2023", formatter);//ctrl + shift + space ILI .var



        assertEquals(DayOfWeek.THURSDAY, localDate.getDayOfWeek());


        /*for (int i = 0; i < 10; i++) { //10.for
            for (int i1 = 10; i1 > 0; i1--) {
                
            }
        }*/

    }
}
