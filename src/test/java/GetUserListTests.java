import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetUserListTests {


    @Test
    public void getBookingId(){
        // https://restful-booker.herokuapp.com/booking

        given()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()
                .statusCode(200);
    }


}
