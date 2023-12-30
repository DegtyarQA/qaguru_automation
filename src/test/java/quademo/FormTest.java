package quademo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest extends BaseTest {

    private final File FILE_TO_LOAD = new File("src/test/resources/fileToLoad.jpg");

    @Test
    void fillFormTest() {
        registrationPage.openRegistrationFormPage()

                .setFIO("Degtyar", "Valery")
                .setEmail("Valery@degtyar.com")
                .setGender()
                .setPhone("0291230050")
                .setBirthDay("May", "1989", "6")
                .setSubject("English", "Economics")
                .setTwoHobies()
                .uploadFile(FILE_TO_LOAD)
                .setAddress("Kolodischi, tulenina 8-23")
                .setLocation()
                .closeBanners()
                .submitForm()
                .verifySuccesSubmitTitle()
                .verifyOneDataInTable("Student Name", "Degtyar Valery");
    }
}
