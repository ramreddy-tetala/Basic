# Debugging and Logging Guide (Java)

## Debugging Java Applications

Debugging is a crucial skill for Java developers. Here are common tools and techniques:

### 1. IntelliJ IDEA Debugger

- **Setting Breakpoints:** Click the gutter to the left of your code in IntelliJ to set breakpoints.
- **Start in Debug Mode:** Press the Debug icon or use `Shift + F9` (default keymap) to run.
- **Stepping:** Use buttons to *Step Over* (F8), *Step Into* (F7), and *Step Out* (Shift+F8).
- **View Variables and Call Stack:** The debugger panel shows variable values and stack frames.
- **Watches & Evaluate Expressions:** Right-click and `Add to Watches` or use `Alt+F8` to evaluate.

[More info: IntelliJ Debugger Documentation](https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html)

---

### 2. VisualVM

VisualVM is a free profiling and monitoring tool for Java.

- **Attach to Local/Remote JVM:** See all running Java processes and attach for live monitoring.
- **Heap and Thread Analysis:** Take heap/thread dumps and analyze memory leaks or deadlocks.
- **CPU Profiling:** Profile performance bottlenecks on method execution.

[More info: VisualVM Documentation](https://visualvm.github.io/)

---

### 3. Other Useful Tools

- **JDB:** The basic Java command-line debugger (`jdb MyClass`).
- **Eclipse Debugger:** Similar functionality as IntelliJ if you use Eclipse.
- **Remote Debugging:** Start JVM with
```
 -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005
```

and connect your debugger to port `5005`.

---

## Logging Best Practices

Effective logging is vital for monitoring and troubleshooting.

### 1. Logging Frameworks

- **SLF4J:** A simple logging facade/abstraction for Java.
- **Logback:** Powerful native SLF4J implementation, highly configurable.

#### Sample Maven dependencies
```xml
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-api</artifactId>
  <version>2.0.13</version>
</dependency>
<dependency>
  <groupId>ch.qos.logback</groupId>
  <artifactId>logback-classic</artifactId>
  <version>1.4.14</version>
</dependency>
```

#### Example Usage
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    logger.info("Application started");
    try {
      // business logic
    } catch (Exception e) {
      logger.error("Unexpected error", e);
    }
  }
}
```

---

### 2. Logback Configuration Example (`logback.xml`)
```xml
<configuration>
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>

  <root level="info">
    <appender-ref ref="STDOUT" />
  </root>
</configuration>
```

---

### 3. Logging Best Practices

- **Use Parameterized Messages:**
```java
  logger.debug("User {} logged in", username);
```

- **Choose Correct Levels:** `info` for application flow, `warn` for potential problems, `error` for failures, `debug/trace` for development details.
- **Don't Log Sensitive Data:** Avoid outputting passwords, secrets, or private user info.
- **Log Exceptions Properly:** Always pass the exception as the second argument (`logger.error("Failed", e)`).
- **Enable Log Rotation:** Configure logs to rotate and avoid disk space issues (handled in the logback config).
- **Centralize Logs (Production):** Use solutions like ELK, Splunk, or cloud log aggregation for distributed systems.

---

### References

- [SLF4J Manual](https://www.slf4j.org/manual.html)
- [Logback Documentation](https://logback.qos.ch/documentation.html)
- [IntelliJ Debugger](https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html)
- [VisualVM](https://visualvm.github.io/)

---

Happy debugging and logging!
