package pageObject.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    private final SelenideElement modalWindow = $(".modal-header");
    private final SelenideElement closeModalWindowSubmit = $("#closeLargeModal");
    public void verifyModalAppears() {
        modalWindow.$(byText("Thanks for submitting the form")).shouldBe(visible);
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive")
                .$(byText(key)).parent()
                .shouldHave(text(value));
    }
    public void closeModalWindow() {
        closeModalWindowSubmit.pressEnter();
    }

}
