package quademo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import utils.DataGenerator;

import java.util.Map;

public class BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    DataGenerator dataGenerator = new DataGenerator();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        //WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.browser = "chrome";
        Configuration.browserVersion="100.0";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.remote = System.getProperty("remote_url");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = desiredCapabilities;
    }

    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttach(){
        Attach.screenshotAs("Last screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
