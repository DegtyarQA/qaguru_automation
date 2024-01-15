package kz.solva;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ChangeLocalityTest {

    static Stream<Arguments> localityDataProvider() {
        return Stream.of(
                Arguments.of(Locality.kz, List.of("Жеке тұлғаларға", "Бизнеске", "Инвесторларға")),
                Arguments.of(Locality.ru, List.of("Частным лицам", "Бизнесу", "Инвесторам"))
        );
    }


    @MethodSource("localityDataProvider")
    @ParameterizedTest(name = "Тест на локали {0} имеет кнопки {1}")
    void checkMenuButtonForLocality(
            Locality locality,
            List<String> buttons
    ) {
        open("https://solva.kz/");
        $$(".Desktop__StyledDesktopHeader-sc-1dbyhof-0 .LangSwitcher__HeaderLangSwitcher-sc-1gi296k-0").find(text(locality.name())).click();
        $$(".Navigation__StyledMenu-sc-1cdirbx-0 li").filter(visible).shouldHave(texts(buttons));
        sleep(5000);
    }

}
