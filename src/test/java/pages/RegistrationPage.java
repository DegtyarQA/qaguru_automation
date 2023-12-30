package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.CalendarCust;
import components.ModalWindowSuccessRegistration;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarCust calendar = new CalendarCust();
    ModalWindowSuccessRegistration modalWindow = new ModalWindowSuccessRegistration();

    private final static SelenideElement titlePageText = $(".main-header");
    private final static SelenideElement firstNameInput = $("#firstName");
    private final static SelenideElement lastNameInput = $("#lastName");
    private final static SelenideElement emailInput = $("#userEmail");
    private final static SelenideElement btnSex = $("[for=gender-radio-1]");
    private final static SelenideElement phoneInput = $("#userNumber");
    private final static SelenideElement calendarOpen = $("#dateOfBirthInput");
    private final static SelenideElement subjectInput = $("#subjectsInput");
    private final static SelenideElement uploadBtn = $("#uploadPicture");
    private final static SelenideElement addressInput = $("#currentAddress");
    private final static SelenideElement submitBtn = $("#submit");


    public RegistrationPage openRegistrationFormPage() {
        open("/automation-practice-form");
        titlePageText.shouldHave(Condition.exactText("Practice Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setFIO(String first, String last) {
        setFirstName(first);
        setLastName(last);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender() {  //todo сделать универсальным
        btnSex.click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage setBirthDay(String month, String year, String day) {
        calendarOpen.click();
        calendar.setDate(month, year, day);
        return this;
    }

    public RegistrationPage setSubject(String... subject) {
        for (int i = 0; i < subject.length; i++) {
            subjectInput.setValue(subject[i]).pressEnter();
        }
        return this;
    }

    public RegistrationPage setTwoHobies() {
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-3]").click();
        return this;
    }

    public RegistrationPage uploadFile(File file) throws NullPointerException {
        try {
            uploadBtn.uploadFile(file);
        } catch (NullPointerException e) {
            System.out.println("Nema faila!!!");
        }
        return this;
    }

    public RegistrationPage closeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setLocation() {
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        return this;
    }

    public RegistrationPage submitForm() {
        submitBtn.click();
        return this;
    }

    public RegistrationPage verifySuccesSubmitTitle() {
        modalWindow.verifyTittleText();
        return this;
    }

    public void verifyOneDataInTable(String key, String value){
        modalWindow.verifyKeyValueTablaData(key, value);
    }

}
