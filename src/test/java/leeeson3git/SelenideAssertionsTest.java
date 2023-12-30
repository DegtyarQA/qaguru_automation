package leeeson3git;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideAssertionsTest {

    @Test
    void assertionSelenideTest() {
        open("https://github.com/selenide/selenide");
        Configuration.browserSize="1024x768";
        $("#wiki-tab").click();
        $$("#wiki-pages-box ul li").last().$("button").click();
        $("#wiki-pages-box ul li").sibling(16).shouldHave(text("SoftAssertions")).click();
        $("#wiki-pages-box ul li").sibling(16).$("a").click();
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").shouldHave(text("3. Using JUnit5 extend test class:"));
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").sibling(0).$("div pre").shouldNotBe(empty);
        closeWebDriver();
    }

    @Test
    void gitSolutionsMenuTest() {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $$("[aria-labelledby=solutions-for-heading] li").get(0).click();
        //$(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(exactText("The AI-powered developer platform."));
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a>header").shouldHave(exactText("B"));
        $("#column-b>header").shouldHave(exactText("B"));
        //sleep(50000);
    }

    @Test
    void test1() {
        $("").getValue();
    }
}
