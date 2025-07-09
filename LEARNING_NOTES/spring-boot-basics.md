# Spring Boot Basics Cheatsheet

**Spring Boot** is a framework for building stand-alone, production-grade Spring applications easily, minimizing boilerplate configuration.

---

## 1. Spring Boot Project Structure
```
my-springboot-app/
├── src/main/java/
├── src/main/resources/
│   └── application.properties or application.yml
├── pom.xml / build.gradle
```

---

## 2. Main Application Class
```java
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

---

## 3. Common Annotations

| Annotation           | Purpose                                             |
|----------------------|-----------------------------------------------------|
| `@SpringBootApplication` | Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`     |
| `@RestController`    | Marks the class as a REST controller                |
| `@RequestMapping`    | Maps HTTP requests to handler methods               |
| `@GetMapping`        | Maps HTTP GET requests                              |
| `@PostMapping`       | Maps HTTP POST requests                             |
| `@Autowired`         | Injects dependencies (beans)                        |
| `@Service`           | Marks a service class                               |
| `@Repository`        | Marks a data-access class                           |

---

## 4. Sample REST Controller
```java
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello, Spring Boot!";
    }
}
```

---

## 5. Application Properties

- `application.properties` or `application.yml` (in `src/main/resources`):
```
Server port
server.port=8081

Custom property
myapp.greeting=Hi!
```

- Access custom property in code:
```java
@Value("${myapp.greeting}")
private String greeting;
```
---

## 6. Packaging and Running

- **Build JAR:**
```sh
  mvn clean package
  # or using Gradle
  ./gradlew build
```

- **Run:**
```sh
  java -jar target/my-springboot-app-0.0.1-SNAPSHOT.jar
```

- **Or directly:**
```sh
  ./mvnw spring-boot:run
```

---

## 7. Useful Links

- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Initializr](https://start.spring.io/) – Generate project skeleton

---

