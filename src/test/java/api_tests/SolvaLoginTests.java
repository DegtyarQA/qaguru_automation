package api_tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class SolvaLoginTests {


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI="https://solva.kz/";
    }


    @Test
    void unsuccesLogin(){
        String cookies = "bcc3f6bffb0bbe3b2bdaffa57602; __ddg1_=v9tnHB4u1mXwFYVWjiKG";
        String body = "{\"login\":\"+7003216545\",\"password\":\"qwerty123\",\"remember\":false}";

        given()
                .contentType("application/json")
                .cookie("JSESSIONID", cookies)
                .body(body)
                .when()
                .post("/secure/rest/authentication/login")
                .then()
                .log().all()
                .statusCode(500)
                .body("status", is("OK"));
    }
}
