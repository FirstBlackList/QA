package allureTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://github.com");

        $("[class='search-input']").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").submit();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#80")).shouldHave(Condition.exist);

    }

}
