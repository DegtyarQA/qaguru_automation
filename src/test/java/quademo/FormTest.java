package quademo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FormTest extends BaseTest {

    private final File FILE_TO_LOAD = new File("src/test/resources/fileToLoad.jpg");

    @Tag("simploa")
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
                .verifyOneDataInTable("Student Name", lastName +" 3" + firstName);
    }
}
