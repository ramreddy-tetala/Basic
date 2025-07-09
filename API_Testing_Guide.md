# API Testing Guide

This guide covers best practices for API testing, including tools like Postman, RestAssured, and writing integration tests in Java.

---

## 1. Why Test APIs?

APIs are the contracts between software components. Bugs in APIs can break clients, cause data corruption, or expose vulnerabilities. API testing ensures:

- Functional correctness.
- Contract (schema) compliance.
- Good error handling and edge case coverage.
- Security (e.g. authentication, authorization).

---

## 2. Manual Testing with Postman

[Postman](https://www.postman.com/) is a widely-used GUI tool for manually exploring and testing APIs.

**Typical workflow:**
- Import or define your API endpoints.
- Set up environment variables (base URLs, tokens).
- Send requests using different HTTP methods (GET, POST, etc.).
- Assert response status, body, headers.
- Chain requests using scripts for authentication flows, etc.

**Advantages:**
- Easy for exploratory testing.
- Great for documenting and sharing example requests.
- Supports automated “collections” for regression tests.

**Limitations:**
- Manual, not ideal for automated CI/CD.
- Scripting uses JavaScript, which may not align with your backend tech stack.

---

## 3. Automating Tests with RestAssured (Java)

[RestAssured](http://rest-assured.io/) is a Java DSL for making HTTP requests and asserting on responses—great for developers who want to automate API tests.

**Basic example:**
```java
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test
public void shouldReturnUserData() {
    given()
        .baseUri("https://api.example.com")
        .header("Authorization", "Bearer token")
    .when()
        .get("/user/42")
    .then()
        .statusCode(200)
        .body("username", equalTo("alice"));
}
```

**Advantages:**
- Integrates into your Java projects and CI pipelines.
- You can use all the power of Java (reuse, assertions, test runners).
- Supports JSONPath, serialization, path parameters, multipart, etc.

---

## 4. Writing Integration Tests in Java

Beyond RestAssured, you may want to write deeper integration tests in Java that:

- Spin up your whole application (using frameworks like Spring Boot, Quarkus, Micronaut).
- Use mock servers or testcontainers for external dependencies.
- Validate database state before/after API calls.
- Manage transactional lifecycle and data seeding.

**Spring Boot Example:**
```java
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserApiIntegrationTest {

    @LocalServerPort
    int port;

    @Test
    void testUserCreation() {
        // Optionally use RestTemplate, WebTestClient, or RestAssured
        given()
            .baseUri("http://localhost:" + port)
            .contentType("application/json")
            .body("{\"username\":\"bob\"}")
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .body("id", notNullValue());
    }
}
```

**Why write integration tests?**
- Ensures your API and business logic work together.
- Catches problems involving database, security, configurations, etc.

---

## 5. Postman vs. Java Integration Tests

| Feature             | Postman                      | Java Integration Tests (e.g. RestAssured)   |
|---------------------|-----------------------------|---------------------------------------------|
| For manual/exploratory | Best                          | Doable, but less convenient                 |
| Automation level    | Medium (via collections + Newman) | Best (fit CI/CD, assertions, fixtures)      |
| Language            | JavaScript (tests), GUI      | Java (same ecosystem as codebase)           |
| Reusability         | Moderate                     | High (OOP, modularization)                  |
| Learning curve      | Low                          | Moderate (helps if you know Java test libs) |
| Supports mocking    | External tools needed        | Full support via frameworks + mocks         |
| Documentation       | Excellent (visual, sharable) | Source-based (test classes)                 |

---

## 6. Best Practices

- **Test contracts:** Validate JSON schemas or OpenAPI specs.
- **Keep test data consistent:** Seed or reset test data between runs.
- **Clean up after tests:** Use transactions or dedicated test DBs.
- **Cover happy paths & errors:** Test both successful and failing scenarios.
- **Integrate with CI:** Run your tests automatically on every commit.

---

## 7. Transitioning Tips

If you’re used to Postman:
- Start automating regression suites using Postman Collections or Newman.
- Gradually port high-value tests into Java using RestAssured or your framework.
- Use Postman for documentation and quick manual checks.

If you do Java backend:
- Use JUnit/TestNG, RestAssured, and @SpringBootTest or similar for full-stack integration.
- Leverage fixtures, mocks, and containers for a realistic and isolated test environment.
- Integrate test coverage into your CI pipelines (e.g., with Maven/Gradle tasks).

---

## 8. Further Reading

- [RestAssured Documentation](http://rest-assured.io/)
- [Postman Learning Center](https://learning.postman.com/)
- [Spring Boot Testing docs](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)
- [Testcontainers for Java](https://www.testcontainers.org/)

---

_Last updated: June 2024_
