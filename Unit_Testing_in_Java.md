# Unit Testing in Java: JUnit, Mockito, and Comparison to QA Approaches

## Reference: Compare and Show Examples For:
- Unit testing in Java (JUnit, Mockito)
- How this differs or relates to QA-style test approaches

---

## 1. Unit Testing in Java

Unit testing is the practice of testing individual units of source code to verify that each unit functions as expected. In Java, two of the most popular frameworks are **JUnit** (for writing and running tests) and **Mockito** (for mocking dependencies in tests).

### JUnit Example
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
    }
}
```

### Mockito Example
```java
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    void testServiceWithMockDependency() {
        DataRepository mockRepo = mock(DataRepository.class);
        when(mockRepo.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockRepo);
        String result = service.process();

        assertEquals("Processed: Mock Data", result);
    }
}
```

---

## 2. QA-Style Test Approaches

**QA-style testing** (Quality Assurance) generally refers to broader validation activities like system/integration testing, UI/UX testing, user acceptance testing (UAT), and manual exploratory tests. These tests focus on application behavior, user flows, and system-wide features, not just isolated units of code.

### Example: QA Test Case (High-Level/Manual)

| Test Case ID | Description                        | Steps                                                             | Expected Result            |
|--------------|------------------------------------|-------------------------------------------------------------------|----------------------------|
| TC_Login_01  | User can log in with valid creds   | 1. Go to login page  <br> 2. Enter valid user credentials <br> 3. Click 'Login' | User dashboard is displayed |

---

## 3. Comparison Table

| Aspect          | Unit Testing (JUnit/Mockito)                | QA-Style Testing                       |
|-----------------|---------------------------------------------|----------------------------------------|
| Level           | Code/unit level                             | System level, End-to-End               |
| Who             | Developers / SDETs                          | QA engineers, testers, end users       |
| Tools           | JUnit, Mockito, TestNG                      | Selenium, JMeter, manual test cases    |
| Scope           | Small, isolated methods/classes             | Full workflows, UI, APIs, integrations |
| Automation      | Yes (high)                                  | Mix of automated & manual              |
| Examples        | Assert equals, mocking dependencies         | Checking login, user flows             |

---

## Summary

- **Unit Testing (JUnit, Mockito):** Fast, isolated, automated, written alongside code by developers to catch bugs early.
- **QA-Style Testing:** Broader, integrating multiple parts, often closer to user experience, sometimes automated but often manual.

Both approaches are complementary and essential for delivering robust, reliable software.
