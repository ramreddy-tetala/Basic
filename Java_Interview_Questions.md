# Java Interview Questions (Backend Dev & QA Focus)

Curated list of common Java backend (and some QA) interview questions with detailed sample answers, highlighting differences in expectations between QA and developer roles.

---

## 1. What is the difference between `==` and `.equals()` in Java?

**Sample Answer:**

In Java, `==` checks if two references point to the same object in memory (reference equality), whereas `.equals()` checks whether the objects are logically equal (value equality).

- **Developer Expectation:**  
  Developers should understand when to override `.equals()` and why it's necessary for custom value classes.
- **QA Expectation:**  
  QA personnel should know the difference to validate test cases and avoid false positives when comparing object data in automated tests.

---

## 2. Explain the difference between `ArrayList` and `LinkedList` in Java. When would you use one over the other?

**Sample Answer:**

- **ArrayList** is backed by a dynamic array. It is faster for random access (get/set by index), but slower when inserting or removing elements (especially in the middle).
- **LinkedList** is backed by a doubly-linked list. It is faster for adding/removing elements at the start or in the middle, but slower for accessing elements by index.

- **Developer Expectation:**  
  Developers should choose the suitable collection based on performance requirements. For frequent access, use `ArrayList`. For frequent insertions/removals, use `LinkedList`.
- **QA Expectation:**  
  QA should be aware that the choice of collection can affect performance, which might impact the results of performance/load testing.

---

## 3. What is the difference between `throw` and `throws` in Java?

**Sample Answer:**

- `throw` is used to actually throw an exception (e.g., `throw new Exception();`).
- `throws` is used in method signatures to declare that a method might throw exceptions.

- **Developer Expectation:**  
  Developers should use `throws` in method signatures and use `throw` to actually create and throw exceptions where needed.
- **QA Expectation:**  
  QA needs to understand this to write tests covering both expected and unexpected exceptions, ensuring code handles errors gracefully.

---

## 4. What is the role of the `final` keyword in Java?

**Sample Answer:**

The `final` keyword can be applied to variables, methods, and classes:

- A final variable cannot be changed once initialized.
- A final method cannot be overridden by subclasses.
- A final class cannot be subclassed.

- **Developer Expectation:**  
  Developers should use `final` to enforce immutability and prevent unintended modification or inheritance.
- **QA Expectation:**  
  QA should verify that constants or immutable objects remain unchanged and developers' design intentions are respected.

---

## 5. How would you test REST API endpoints in Java?

**Sample Answer:**

- **Developer Expectation:**  
  Developers might write unit tests using libraries like JUnit, and integration tests using tools like Spring's `MockMvc` or Testcontainers.
- **QA Expectation:**  
  QA may use tools like Postman, RestAssured (Java), or SoapUI for automated API testing. They focus on verifying correctness, negative scenarios, performance, and boundary cases.

 Example in Java (using RestAssured):
```java
given()
    .baseUri("http://localhost:8080")
    .when()
    .get("/api/hello")
    .then()
    .statusCode(200)
    .body("message", equalTo("Hello World!"));
```
---

## 6. What is the difference between unit testing and integration testing?

**Sample Answer:**

- **Unit Testing:** Tests individual components/classes in isolation.
  - **Developer Expectation:**  
    Developers write unit tests to verify their code works as intended and refactor safely.
- **Integration Testing:** Tests interactions between multiple components, such as database, web server, etc.
  - **QA Expectation:**  
    QA often writes and executes integration (and end-to-end) tests to validate the entire application workflow.

---

## 7. Explain the concept of immutability. Why is it important?

**Sample Answer:**

An immutable object cannot have its field values changed after creation.

- **Developer Expectation:**  
  Developers should design immutable classes for thread safety and to avoid bugs from accidental state changes.
- **QA Expectation:**  
  QA may verify that APIs returning immutable objects do not permit unintended modifications.

---

## 8. How does Java handle memory management and garbage collection?

**Sample Answer:**

Java uses automatic garbage collection to reclaim memory used by objects that are no longer reachable. The JVM's garbage collector periodically frees up memory for other objects.

- **Developer Expectation:**  
  Developers should write efficient code and avoid memory leaks (e.g., by releasing resources, removing references from collections).
- **QA Expectation:**  
  QA may write or use tools to check for memory leaks and profile application memory usage under load.

---

## 9. Tell me about synchronization in Java and thread safety.

**Sample Answer:**

Synchronization in Java is a mechanism that ensures only one thread can access a resource (like a method or block of code) at a time.

- **Developer Expectation:**  
  Developers need to write synchronized code to avoid race conditions and ensure thread safety.
- **QA Expectation:**  
  QA should design concurrency/stress tests to uncover thread safety issues or deadlocks.

---

## 10. What is the difference between `HashMap` and `Hashtable`?

**Sample Answer:**

- `HashMap` is not synchronized and allows one null key and multiple null values.  
- `Hashtable` is synchronized and does not allow null keys or values.

- **Developer Expectation:**  
  Developers today prefer `HashMap` for non-threaded contexts and `ConcurrentHashMap` for thread-safe operations, avoiding the overhead of `Hashtable`.
- **QA Expectation:**  
  QA should verify proper use of thread-safe collections in multi-threaded scenarios.

---

## References

- Java Official Documentation: https://docs.oracle.com/javase/tutorial/
- Effective Java by Joshua Bloch
- Spring Framework Documentation
