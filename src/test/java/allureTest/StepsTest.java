/*package allureTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final int ISSUE = 80;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open first page", () -> {
            Configuration.holdBrowserOpen = true;
            Configuration.pageLoadStrategy = "eager";
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[class='search-input']").click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
        });

        step("Click by repository " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Open tab issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).shouldHave(Condition.exist);
        });


    }

    @Test
    public void annotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumberIntIssue(ISSUE);
    }

}*/
