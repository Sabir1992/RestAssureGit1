import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingTests extends BaseTests{

    @Test
    public void getBooking() {

        Response response = given(resScpec).when().get("/booking/1");

        response.then().statusCode(200);
        response.prettyPrint();


        String ad = response.jsonPath().getJsonObject("firstname");
        Assertions.assertEquals("Susan",ad);
    }
}
