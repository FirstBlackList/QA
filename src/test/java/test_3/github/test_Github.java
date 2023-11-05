/*package test_3.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SetValueOptions.withText;

public class test_Github {

    @Test
    void shouldFirstProjectGithubFromSelenide() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com");
        $x("//div//span[@class='flex-1']").click();
        $("[id='query-builder-test']").shouldHave(visible, Duration.ofSeconds(6)).val("selenide").pressEnter();
        $$x("//div[@data-testid='results-list']//div[contains(@Class, 'Box')]//a").first().click();
        $(byText("selenide/selenide")).shouldHave(visible, Duration.ofSeconds(6));
        $("[id='wiki-tab']").shouldHave(visible, Duration.ofSeconds(6)).click();
        $x("//a[contains(text(), 'Soft assertions')]").scrollTo().shouldHave(visible).click();
        ElementsCollection collection = $$x("//div[@class='markdown-body']//ul//li//a");
        *//*for (SelenideElement x : collection) {
            if (x.getOwnText().equals("Soft assertions")) {
                x.click();
                break;
            }
        }*//*
        *//*collection.forEach(x-> {
            boolean softAssertions = x.getOwnText().equals("Soft assertions");
            sleep(8000);
            if (softAssertions) {
                x.click();
            }
        });*//*
        $(".overflow-auto").scrollTo().shouldHave(visible);

    }

    @Test
    void shouldHaveProjectGithubFromSelenide() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com");
        $x("//div//span[@class='flex-1']").click();
        $("[id='query-builder-test']").val("selenide").pressEnter();
        $$x("//div[@data-testid='results-list']//div[contains(@Class, 'Box')]//a").get(6).click();
        $(byText("selenide")).shouldHave(visible);

    }

    @Test
    void shouldFirstProjectGithubFromSelenideVoidTopContributor() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/selenide/selenide");
        $$x("//div[@class='BorderGrid-row']//li").first().hover();
        //$(byText("Andrei Solntsev")).shouldHave(visible, Duration.ofSeconds(6));
        $(".Popover").$(byText("Andrei Solntsev")).shouldHave(visible, Duration.ofSeconds(4));

    }
}*/
