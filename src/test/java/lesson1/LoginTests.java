package lesson1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTests {

    @Test
    public void successfulLoginTest() {
        //Configuration.holdBrowserOpen = true;
        //Configuration.browser = "firefox";
        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("bgobq@mailto.plus");
        $("[name=password]").setValue("$4C$bZxc4");
        $(".btn-success").click();
        $(".main-header__login").click();
        $(".logined-form").shouldHave(text("Здравствуйте, Валиков"));
    }

    @Test
    public void unsuccessfulLoginTest() {
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = "firefox";
        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("bgobq@mailto1.plus");
        $("[name=password]").setValue("$4C$bZxc4");
        $(".btn-success").click();
        $(".login-fo rm").shouldHave(text("Неверный пароль"));
    }

}
