# ☕ Java Backend Development - Learning Notes

---

## 1. 💡 Core Concepts

- **OOP Principles**: Encapsulation, Inheritance, Polymorphism, Abstraction.
- **Exception Handling**: Use checked vs unchecked exceptions appropriately. Always close resources (try-with-resources).
- **Collections Framework**: Lists, Sets, Maps, Queues (choose optimal structure for scenario).
- **Generics**: Promote type safety and code reusability.

## 2. 🌐 REST APIs

- **Frameworks**: Spring Boot (industry standard), Jakarta EE/Quarkus/Micronaut (alternatives).
- **Controller Layer**: Use `@RestController`, `@RequestMapping`, and parameter annotations.
- **DTOs**: Use Data Transfer Objects for input/output. Avoid exposing database models directly.
- **Validation**: Use annotations like `@Valid`, `@NotNull`, `@Size`.

## 3. 🗄️ Persistence Layer

- **ORM**: JPA/Hibernate is common. Use `@Entity`, `@Repository`, and Spring Data interfaces.
- **Transactions**: Ensure proper transaction boundaries with `@Transactional`.
- **Query Optimization**: Beware of N+1 problem. Use FetchType wisely.

## 4. 🛡️ Security

- **Spring Security**: Role-based, method/URL restrictions, password encoding (`BCryptPasswordEncoder`).
- **JWT**: Widely used for stateless authentication.
- **CORS**: Configure allowed origins for APIs.

## 5. 🛠️ Build & Dependency Management

- **Maven/Gradle**: Use for managing dependencies, plugins, builds, and profiles.
- **Project Structure**: Follow standard Maven layout (`src/main/java`, `src/test/java`, etc).

## 6. 🧪 Testing

- **Unit Testing**: JUnit 5, Mockito for mocking.
- **Integration Testing**: `@SpringBootTest`, H2 for in-memory DB.
- **Test Coverage**: Target meaningful coverage but focus on quality over quantity.

## 7. 🚦 Best Practices

- **Layered Architecture**: Controller → Service → Repository. No business logic in controllers.
- **Logging**: Use SLF4J/Logback. Avoid logging sensitive data.
- **Error Handling**: Standardize responses (`@ControllerAdvice`, custom exceptions).
- **External Configurations**: Use `application.properties` or YAML, environment variables for secrets.

## 8. 🏗️ Deployment & CI/CD

- **Build Artifacts**: Use `jar` or `war` builds for deployment.
- **Dockerization**: Containerize services for consistency.
- **CI/CD Pipelines**: Automate build, test, deployment (e.g., GitHub Actions, Jenkins).

## 9. 📚 Reference Links

- [Spring Boot Official Docs](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Java 17+ Docs](https://docs.oracle.com/en/java/javase/17/)
- [Baeldung Java Guides](https://www.baeldung.com/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

---

_Regularly update with newly learned patterns, pitfalls, and tools!_
