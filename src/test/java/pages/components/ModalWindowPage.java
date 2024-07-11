package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowPage {
    private SelenideElement modalWindow = $(".modal-dialog");
    private SelenideElement modalWindowHeader = $("#example-modal-sizes-title-lg");
    private SelenideElement modalWindowTable = $(".table-responsive");

    public ModalWindowPage checkModalWindow () {
        modalWindow.should(appear);

        return this;
    }

    public ModalWindowPage checkModalWindowHeader (String value) {
        modalWindowHeader.shouldHave(text(value));;

        return this;
    }

    public ModalWindowPage checkModalWindowTable (String key, String value) {
        modalWindowTable.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public void checkModalWindowNotVisible() {
        modalWindow.shouldNotBe(visible);
    }

}
