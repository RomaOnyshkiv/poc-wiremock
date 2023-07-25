import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class MyTests extends BaseTest{

    private Response response;

    @BeforeMethod
    public void setStabs(){
        stubFor(get(urlPathEqualTo("/"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("application/json", "application/json")
                        .withBody("{\n\"id\": 1, \n \"first_name\": \"Roman\",\n \"last_name\": \"Onyshkiv\",\n \"properties\" : {\n \"age\": 36,\n \"active\": true,\n \"date_of_birth\": \"Apr 04 1987\" \n}\n}")));
    }

    @Test
    public void simpleTest() {
        response = given().contentType("application/json").get("http://localhost:8080/");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getInt("id"), 1);
        assertEquals(response.jsonPath().getInt("properties.age"), 36);
    }
}
