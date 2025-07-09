# Common @ Annotations Used in Java Spring Boot Framework

Spring Boot leverages many annotations to simplify configuration, dependency injection, and REST API development. Below are some frequently used Spring Boot annotations:

---

## Core Annotations

- `@SpringBootApplication`  
    - Marks the main class of a Spring Boot application.
    - Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.

- `@Component`, `@Service`, `@Repository`, `@Controller`
    - Stereotype annotations to specify different types of components for Spring's component scanning.

---

## Dependency Injection

- `@Autowired`
    - Automatically injects dependencies by type.

- `@Qualifier`
    - Used along with `@Autowired` to resolve ambiguity when multiple beans of same type exist.

---

## REST API Annotations

- `@RestController`
    - Marks a class as a RESTful web service controller. Combines `@Controller` and `@ResponseBody`.

- `@RequestMapping`
    - Maps HTTP requests to handler methods of controller.

- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping`
    - Shortcut annotations for HTTP GET, POST, PUT, DELETE, and PATCH requests.

---

## Configuration and Properties

- `@Value`
    - Injects values into fields from properties files.

- `@Configuration`
    - Indicates that a class provides @Bean definitions.

- `@Bean`
    - Declares a bean to be managed by the Spring container.

- `@ConfigurationProperties`
    - Binds external properties to Java objects.

---

## Data and Persistence

- `@Entity`
    - Specifies that the class is an entity mapped to a database table (JPA).

- `@Id`
    - Denotes the primary key of an entity.

- `@GeneratedValue`
    - Specifies the generation strategy for the primary key.

- `@Repository`
    - Specializes `@Component` for persistence layer beans.

---

## Others

- `@Transactional`
    - Indicates that a method/class should be executed within a transaction.

- `@ExceptionHandler`
    - Used to define custom exception handling methods in controllers.

---

## Example
```java
@RestController
@RequestMapping("/api")
public class SampleController {

    @Autowired
    private MyService myService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

---

_For more details, refer to the [Spring Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)_.
