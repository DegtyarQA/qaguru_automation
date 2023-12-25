package quademo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    private final File FILE_TO_LOAD = new File("src/test/resources/fileToLoad.jpg");

    @Test
    void fillFormTest() {
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(".main-header").shouldHave(Condition.exactText("Practice Form"));
        $("#firstName").setValue("Valery");
        $("#lastName").setValue("Degtyar");
        $("#userEmail").setValue("Valery@degtyar.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("0291230050");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1989");
        $(byText("6")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        //$("#subjectsInput").setValue("Economics").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(FILE_TO_LOAD);
        $("#currentAddress").setValue("Kolodischi, tulenina 8-23");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(Condition.exactText("Thanks for submitting the form"));
        $(byText("Student Name")).sibling(0).shouldHave(Condition.exactText("Valery Degtyar"));
    }
}
