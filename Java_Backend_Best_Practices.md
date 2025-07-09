# Java Backend Best Practices

## 1. Code Organization and Readability

- **Project Structure:**  
  - Follow standard Maven/Gradle directory layout:
```
    src/main/java  
    src/main/resources  
    src/test/java
```

- Group code by feature or module for scalability.

- **Naming Conventions:**
  - Use meaningful, descriptive class and method names (e.g., `UserController`, `OrderService`).
  - Use camelCase for variables and methods; PascalCase for classes.

- **Readability:**
  - Keep methods short and focused (Single Responsibility Principle).
  - Add comments for complex logic, avoid redundant comments.
  - Leverage JavaDoc for public APIs.

- **Consistent Formatting:**
  - Configure code formatters (Checkstyle, Spotless).
  - Indent and space code clearly.

---

## 2. Recommended Design Patterns

- **Singleton:**  
  Restrict instantiation of a class to one object.  
  Useful for services like configuration providers or logging.

```java
  public class ConfigService {
      private static ConfigService instance;
      private ConfigService() {}
      public static synchronized ConfigService getInstance() {
          if (instance == null) instance = new ConfigService();
          return instance;
      }
  }
```

- **Factory Pattern:**  
  Hide object creation logic in a factory class.
```java
  public interface Vehicle { }
  public class Car implements Vehicle { }
  public class Bike implements Vehicle { }
  public class VehicleFactory {
      public static Vehicle create(String type) {
          if ("car".equals(type)) return new Car();
          if ("bike".equals(type)) return new Bike();
          throw new IllegalArgumentException("Unknown type");
      }
  }
```

- **Repository Pattern:**  
  Encapsulate data access logic, separate from business logic.
```java
  public interface UserRepository {
      User findById(Long id);
      void save(User user);
  }
  public class UserRepositoryImpl implements UserRepository {
      // Database access implementation
  }
```

---

## 3. REST API Design Tips

- **Resource Naming:**
  - Use plural nouns: `/users`, `/orders`.
  - Nested resources: `/users/{userId}/orders`.

- **HTTP Methods:**
  - `GET` – Retrieve resources
  - `POST` – Create resources
  - `PUT` – Update/replace resources
  - `PATCH` – Partial update
  - `DELETE` – Remove resources

- **Status Codes:**
  - `200 OK` – Success
  - `201 Created` – New resource created
  - `204 No Content` – Success, no response body
  - `400 Bad Request` – Invalid client data
  - `404 Not Found` – Resource doesn’t exist
  - `500 Internal Server Error` – Server error

- **Consistent Responses:**
  - Use standard response objects
  - Example:

  ```json
    {
      "status": "success",
      "data": {...},
      "message": ""
    }
  ```

  - **Error Handling:**
  - Return meaningful error messages and codes.
  - Example:
  ```json
    {
      "status": "error",
      "error": {
        "code": "USER_NOT_FOUND",
        "message": "User with id 123 not found"
      }
    }
  ```

  - **Versioning:**
  - Use URI versioning: `/api/v1/users`
  - Or use header-based versioning.

---

## References

- [Effective Java (Joshua Bloch)](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- [RESTful API Design Best Practices](https://restfulapi.net/)
- [Spring’s REST API Guidelines](https://spring.io/guides/gs/rest-service/)

