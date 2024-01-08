package kz.solva;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolvaParametrizedTests {

    @BeforeEach
    void SetUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://solva.kz";
        Configuration.headless = false;
    }

    @CsvSource({
            "bpyhuz@mailto.plus, Qwerty123",
            "qmutexy@mailto.plus, AAAAAAA",
            "eeeee@fdfdfd.re, ttttt"
    })
    @ParameterizedTest(name = "Проверка логина с почтой {0} м паролем {1}")
    void unseccsesfullLoginTest(String email, String password) {
        open("/personal-area/login");
        $("[name=login]").setValue(email);
        $("[name=password]").setValue(password);
        $(".Button-module_content__PpYVU").click();
        $("[data-test-id=errorMessage]").shouldBe(Condition.appear).shouldHave(Condition.exactText("Неверный логин или пароль."));
    }

    @ValueSource(strings = {"Зеленое финансирование", "Микрокредит на товары"})
    @ParameterizedTest(name = "тест {0}")
    void CheckMenuBusinessTitle(String nameProduct) {
        open(Configuration.baseUrl);
        $(".Navigation__StyledMenu-sc-1cdirbx-0").$(byText("Бизнесу")).hover();
        $(byText("Для ИП и самозанятых")).parent().shouldHave(Condition.text(nameProduct));
    }

    @CsvFileSource(files = "src/test/resources/testData.csv")
    @ParameterizedTest(name = "Тест с телефоном {0} и ФИО {1}")
    void llpFormTest(String phone, String fio) {
        open("/business/llp/#llp-form");
        sleep(5000);
        $("[name=phone]").click();
        $("[name=phone]").append(phone);
        $("#client-name").setValue(fio);
        $("div .form__actions button").click();
        $(".checkbox__error").shouldHave(Condition.exactText("Если у вас нет действующего ТОО, то вы можете отправить заявку на займ для  ИП, Самозанятого или Частного лица"));
        //sleep(50000);

    }
}
