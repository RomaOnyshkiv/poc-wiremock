import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class MyTests{

    private Response response;

    @Test
    public void simpleTest() {
        response = given().contentType("application/json").get("http://localhost:8080/");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getInt("id"), 1);
        assertEquals(response.jsonPath().getInt("properties.age"), 36);
    }
}
