# Common Backend Interview Tasks

Reference step-by-step guides for basic backend software engineering interview tasks.

---

## 1. Building CRUD REST APIs

### Example: CRUD API with Spring Boot

#### 1. Scaffold a Spring Boot Project
- Use [https://start.spring.io/](https://start.spring.io/)
    - Dependencies: `Spring Web`, `Spring Data JPA`, `H2 Database`

#### 2. Define Entity
```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // getters and setters
}
```

#### 3. Create Repository
```java
public interface UserRepository extends JpaRepository<User, Long> {}
```

#### 4. Build Controller
```java
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping
    public List<User> all() { return repo.findAll(); }

    @PostMapping
    public User create(@RequestBody User u) { return repo.save(u); }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) { return repo.findById(id).orElseThrow(); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User u) {
        u.setId(id); return repo.save(u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }
}
```

---

## 2. Writing a Simple Service with Spring Boot

#### 1. Service Interface & Implementation
```java
public interface GreetingService {
    String greet(String name);
}

@Service
public class GreetingServiceImpl implements GreetingService {
    public String greet(String name) { return "Hello, " + name + "!"; }
}
```

#### 2. Using Service in a Controller
```java
@RestController
public class GreetingController {

    @Autowired
    private GreetingService service;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return service.greet(name);
    }
}
```

---

## 3. Connecting to and Querying a Database

### JDBC Example

#### 1. Add Dependency (Maven):
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.1</version>
</dependency>
```

#### 2. Connect and Query
```java
String url = "jdbc:postgresql://localhost:5432/mydb";
String username = "user";
String password = "pass";
Connection conn = DriverManager.getConnection(url, username, password);
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT id, name FROM users");
while (rs.next()) {
    System.out.println(rs.getLong("id") + ": " + rs.getString("name"));
}
rs.close(); stmt.close(); conn.close();
```

---

### Hibernate Example

#### 1. Add Dependencies:
```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.3.1.Final</version>
</dependency>
<dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>3.1.0</version>
</dependency>
```

#### 2. Configure (hibernate.cfg.xml or application.properties)
- Set DB URL, username, password, dialect etc.

#### 3. Use JPA Repository
```java
List<User> users = userRepository.findAll();
```

---

## References

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Hibernate ORM Documentation](https://hibernate.org/orm/documentation/)

---

> 💡 **Tip:** In interviews, aim for clear, idiomatic, well-structured code, and emphasize best practices (e.g., exception handling, modularity, meaningful names, etc.)
