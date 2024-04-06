import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class BaseTests {

     RequestSpecification resScpec;

    @BeforeEach
    public void configSpec(){
         resScpec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();
    }

    protected int createBookingId(){
        Response res = createBooking();
        return res.jsonPath().getJsonObject("bookingid");
    }

    protected Response  createBooking(){
        String bookingObject  = bookingObject();
    Response response =  given(resScpec)
            .when()
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .body(bookingObject)
                .post("/booking");

    response
            .then()
            .statusCode(200);
        return response;
    }

    protected String bookingObject(){
        JSONObject body = new JSONObject();
        body.put("firstname","Fuad");
        body.put("lastname","Tester");
        body.put("totalprice",555);
        body.put("depositpaid",true);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2025-01-01");
        bookingdates.put("checkout","2025-01-05");

        body.put("bookingdates",bookingdates);
        body.put("additionalneeds","Example text..");

        return body.toString();
    }

    public String createToken(){
        JSONObject body = new JSONObject();
        body.put("username","admin");
        body.put("password","password123");

        Response response = given(resScpec)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/auth ");

        return response.jsonPath().get("token");

    }

}
