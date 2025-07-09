# Fetch Types and Fetch Modes in ORM (Hibernate/JPA)

Fetching strategies determine how data is loaded from the database for associations (e.g., `@OneToMany`, `@ManyToOne`, etc.) in Hibernate/JPA.

---

## Fetch Types

### 1. Lazy Fetching (`FetchType.LAZY`)

- **Definition:** Associated data is loaded only when accessed for the first time (on-demand).
- **Example Usage:**
```java
  @OneToMany(fetch = FetchType.LAZY)
  private List<Order> orders;
```

- **Advantage:** Reduces initial loading time and memory footprint.
- **Disadvantage:** Multiple queries (N+1 problem) or potential `LazyInitializationException` if session is closed.

### 2. Eager Fetching (`FetchType.EAGER`)

- **Definition:** Associated data is loaded immediately with the parent entity (at the time of query).
- **Example Usage:**
```java
  @ManyToOne(fetch = FetchType.EAGER)
  private Customer customer;
```

- **Advantage:** Everything loaded at once; no lazy loading exceptions.
- **Disadvantage:** May load unnecessary data, increasing memory usage and slowing down queries.

---

## Fetch Modes (Hibernate Specific)

Hibernate provides different fetch modes to further control fetching behavior:

### 1. `FetchMode.SELECT`
- Default mode for `FetchType.LAZY`.
- Loads each association using a separate SQL SELECT query.

### 2. `FetchMode.JOIN`
- Uses a SQL JOIN to fetch associations eagerly in a single query.
- **Example:**
```java
  @OneToMany(fetch = FetchType.LAZY)
  @Fetch(FetchMode.JOIN)
  private Set<Order> orders;
```

### 3. `FetchMode.SUBSELECT`
- Loads collections using a subselect query when accessed.
- Reduces the number of queries for batch collections.
- **Example:**
```java
  @OneToMany(fetch = FetchType.LAZY)
  @Fetch(FetchMode.SUBSELECT)
  private Set<Order> orders;
```

---

## "Add" and "Not Add" Concepts

### 1. Add (Eager Fetching / JOIN Fetch)
- Associations are included (added) in the initial fetch query, either through eager fetching or by using `JOIN` fetch.

### 2. Not Add (Lazy Fetching / Separate Fetch)
- Associations are not included in the initial fetch; they are fetched separately (later/lazily) when accessed.

---

## Summary Table

| Strategy         | Timing        | SQL Generated               |
|------------------|--------------|-----------------------------|
| LAZY + SELECT    | On access    | N+1 SELECT                  |
| EAGER + JOIN     | Immediately  | Single SQL JOIN             |
| LAZY + SUBSELECT | On access    | 1 parent, 1 subselect query |

---

## References

- [Hibernate Official Documentation](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#fetching)
- [JPA Specification](https://jakarta.ee/specifications/persistence/3.0/jakarta-persistence-spec-3.0.html)
