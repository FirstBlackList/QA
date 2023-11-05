/*package allureTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open first page")
    public void openMainPage() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("[class='search-input']").click();
        $("#query-builder-test").setValue(repo).submit();
    }

    @Step("Click by repository {repo}")
    public void clickOnRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Open tab issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем issue с номером {issue}")
    public void shouldSeeIssueWithNumberIntIssue(int issue) {
        takeScreenshot();
        $(withText("#" + issue)).shouldHave(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}*/
