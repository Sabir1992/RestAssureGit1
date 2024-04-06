import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PartialUpdateTests extends BaseTests{

    @Test
    public void partUpdate(){


        // create request
        JSONObject body = new JSONObject();
        body.put("firstname","Tahir");

        Response response = given(resScpec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .body(body.toString())
                .patch("/booking/"+createBookingId());

        // assertions
        Assertions.assertEquals("Tahir",response.jsonPath().getJsonObject("firstname"));

    }
}
