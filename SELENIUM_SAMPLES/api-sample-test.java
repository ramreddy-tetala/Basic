import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Sample API test demonstrating how to use RestAssured with JUnit 5.
 * This test sends a GET request to a public API endpoint and
 * validates some basic response attributes.
 */
public class ApiSampleTest {

    /**
     * Example test:
     *  - Sends GET /users/1 request to JSONPlaceholder API
     *  - Asserts status, content type, and key fields in the response.
     */
    @Test
    public void testGetUserDetails() {
        // Set the base URI for REST-assured requests
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send the GET request and validate response in a chain
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/users/1")
        .then()
            .statusCode(200) // Verify HTTP 200 OK
            .contentType("application/json; charset=utf-8") // Verify response content type
            .body("id", equalTo(1)) // Verify user id is 1
            .body("username", equalTo("Bret")) // Verify expected username
            .body("email", containsString("@")); // Email should contain '@'
    }
}
