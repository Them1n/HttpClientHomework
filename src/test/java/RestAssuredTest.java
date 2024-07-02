import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class RestAssuredTest {

    @Test
    public void testEmojiResponse() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.filters(new AllureRestAssured());

        given()
                .when()
                .get("/emojis")
                .then()
                .statusCode(200)
                .body("$", hasKey("articulated_lorry"));

        System.out.println("Response validated successfully.");
    }
}