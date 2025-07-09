# Backend Basics

## 1. REST Principles

- **Representational State Transfer (REST)** is an architectural style for distributed systems.
- **Key REST Principles:**
  - **Statelessness:** Each request contains all information the server needs.
  - **Uniform Interface:** Consistent API structure (HTTP verbs, URI formats).
  - **Client-Server Separation:** Frontend and backend concerns are separated.
  - **Resource-Based:** Entities are modeled as resources (e.g., `/users`, `/orders`).
  - **Cacheability:** Responses should specify whether caching is allowed.

**Common HTTP Methods:**

| Method | Usage                       |
|--------|----------------------------|
| GET    | Retrieve resource          |
| POST   | Create new resource        |
| PUT    | Update/replace resource    |
| PATCH  | Partial update of resource |
| DELETE | Remove resource            |

---

## 2. Error Handling

- **Best Practices:**
  - Use consistent error response formats (e.g., JSON with `code`, `message`).
  - Capture and log details for server errors.
  - Don't leak sensitive info in error messages.
- **Example Error Response:**
```json
{
  "error": {
    "code": 404,
    "message": "User not found"
  }
}
```

---

## 3. HTTP Status Codes

| Status | Meaning                    | Typical Usage                    |
|--------|----------------------------|----------------------------------|
| 200    | OK                         | Successful request               |
| 201    | Created                    | Resource successfully created    |
| 204    | No Content                 | Successful, no body              |
| 400    | Bad Request                | Invalid request data             |
| 401    | Unauthorized               | Auth required/failed             |
| 403    | Forbidden                  | Insufficient permissions         |
| 404    | Not Found                  | Resource does not exist          |
| 409    | Conflict                   | Duplicate or conflict            |
| 500    | Internal Server Error      | Server-side problem              |

---

## 4. Simple DAO/Repository Usage

- **DAO (Data Access Object)/Repository** abstracts persistence/database logic.
- **Typical Functions:** CRUD (Create, Read, Update, Delete) operations.

**Example (Java/Spring):**
```java
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
```

**Example (Node.js/MongoDB):**
```js
// userRepository.js
const User = require('./models/User');

async function findByEmail(email) {
  return await User.findOne({ email });
}
```

*Using a repository/DAO layer keeps business logic and data access concerns separated.*

---

**Further Reading:**  
- [RESTful API Design - Best Practices](https://restfulapi.net/)
- [Spring Data JPA Reference Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
