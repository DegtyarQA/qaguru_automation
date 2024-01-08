package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    private Faker dataGenRU = new Faker(new Locale("ru"));
    private Faker dataGenOther = new Faker();


    public String getLastName() {
       return dataGenRU.name().lastName();
    }

    public String getFirstName(){
        return dataGenRU.name().firstName();
    }

    public String getEmail() {
        return dataGenOther.internet().emailAddress();
    }

    public String getPhone() {
        return "029" + dataGenOther.phoneNumber().subscriberNumber(7);
    }
    public String getAddresRU() {
        return dataGenRU.address().fullAddress();
    }



}
