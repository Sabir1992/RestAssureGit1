import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTests extends BaseTests{

    @Test
    public void mainUpdate(){
/*
        String token = createToken();

        Response createBookingResponse = createBooking();
        createBookingResponse.prettyPrint();

        // Extract booking ID from the response
        int bookingId = createBookingResponse.jsonPath().getInt("bookingid");
        // Update booking
        Response updateBookingResponse = updateBooking(bookingId, token);
        updateBookingResponse.prettyPrint();
*/
    }


    // 1.Create token





    // 2.Create booking


    // 3.Update booking

    public Response updateBooking(int bookingid,String token){

        Response getBookingResponse = given(resScpec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .get("/booking/"+bookingid);

        JSONObject bookingObject = new JSONObject(getBookingResponse.getBody().asString());

        bookingObject.put("firstname","Sabir");

        return given(resScpec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .body(bookingObject.toString())
                .put("/booking/"+bookingid);

    }
}
