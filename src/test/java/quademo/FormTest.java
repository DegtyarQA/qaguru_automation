package quademo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest extends BaseTest {

    private final File FILE_TO_LOAD = new File("src/test/resources/fileToLoad.jpg");

    @DisplayName("Форма регистрации")
    @Test
    void fillFormTest() {
        String lastName = dataGenerator.getLastName();
        String firstName = dataGenerator.getFirstName();
        registrationPage.openRegistrationFormPage()
                .setFIO(lastName, firstName)
                .setEmail(dataGenerator.getEmail())
                .setGender()
                .setPhone(dataGenerator.getPhone())
                .setBirthDay("May", "1989", "6")
                .setSubject("English", "Economics")
                .setTwoHobies()
                .uploadFile(FILE_TO_LOAD)
                .setAddress(dataGenerator.getAddresRU())
                .setLocation()
                .closeBanners()
                .submitForm()
                .verifySuccesSubmitTitle()
                .verifyOneDataInTable("Student Name", lastName + " " + firstName);
        //sleep(50000);
    }
}
