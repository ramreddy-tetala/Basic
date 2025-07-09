# API Sample Test with RestAssured

This folder demonstrates how to extend your testing toolbox from UI automation (Selenium) to backend API test automation with [RestAssured](https://rest-assured.io/).

## 📃 Introduction

UI tests help validate how users interact with your web application. With API tests, you can directly verify the responses, status codes, and data logic of your backend services—improving overall test coverage and speeding up feedback loops.

Below is a sample Java test using [RestAssured](https://rest-assured.io/) to verify the JSONPlaceholder demo API.

---

## 🔧 Sample Java API Test: `ApiSampleTest.java`
```java
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ApiSampleTest {

    @Test
    public void testGetUserDetails() {
        // Base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request to /users/1 and assert the response
        RestAssured
            .given()
                .accept(ContentType.JSON)
            .when()
                .get("/users/1")
            .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"))
                .body("email", containsString("@"));
    }
}
```

---

## 🚀 How to Run

1. **Add RestAssured dependency** (if using Maven):
```xml
    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>5.3.2</version>
      <scope>test</scope>
    </dependency>
```

2. **Add JUnit 5** (if using Maven):
```xml
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.8.2</version>
      <scope>test</scope>
    </dependency>
```

3. **Run the test:**
    - Use your IDE's test runner, or
    - Run via terminal:
```bash
      mvn test -Dtest=ApiSampleTest
```

---

## 📝 Notes

- You can replace the endpoint with your own API.
- This test checks HTTP status, content type, and specific JSON fields in the response.
- RestAssured can handle complex assertions and chained API calls for comprehensive backend testing.

---
