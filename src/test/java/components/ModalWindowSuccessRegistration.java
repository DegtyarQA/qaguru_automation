package components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowSuccessRegistration {

    private static final String TITTLE_WINDOW = "Thanks for submitting the form";

    public void verifyTittleText() {
        $("#example-modal-sizes-title-lg").shouldHave(Condition.exactText(TITTLE_WINDOW));
    }


    public void verifyKeyValueTablaData(String key, String value) {
        $(byText(key)).sibling(0).shouldHave(Condition.exactText(value));
    }
}


//"Student Name"
//"Degtyar Valery"