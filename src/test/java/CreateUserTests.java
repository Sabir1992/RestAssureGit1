import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    @Test
    public void createUser(){
        //https://reqres.in/api/users

        JSONObject body = new JSONObject();
        body.put("name","Sabir");
        body.put("job","QA");

        Response response =given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://reqres.in/api/users");
        response.prettyPrint();

        response.then()
                .statusCode(201);

        String ad = response.jsonPath().getJsonObject("name");
        Assertions.assertEquals("Sabir",ad);
    }
}
