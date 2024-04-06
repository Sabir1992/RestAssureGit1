import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTests extends  BaseTests {

    @Test
    public void deleteBook(){
        Response response = given(resScpec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .when()
                .delete("/booking/"+createBookingId());

        response
                .then()
                .statusCode(201);
    }
}
