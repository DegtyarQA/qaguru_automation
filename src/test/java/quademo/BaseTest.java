package quademo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import utils.DataGenerator;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    DataGenerator dataGenerator = new DataGenerator();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        //WebDriverRunner.getWebDriver().manage().window().maximize();
        System.out.println("BeforeAll from BaseTest!!!");
    }
}
