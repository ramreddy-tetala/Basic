# 🧩 OOPs Concepts in Java – Learning Notes

---

## 1. 🚀 What is OOP?
**Object-Oriented Programming (OOP)** is a design methodology that models a system as a collection of interacting objects, encapsulating data and behavior.

---

## 2. 🏗️ Key Principles of OOP

### 2.1 Encapsulation  
- Bundling data (fields) and code (methods) into a single unit (class).
- Restricts direct access to some of an object’s components (using `private`/`protected`).
- **Benefits:** Increases modularity, maintains internal state integrity.

  _Example:_
```java
  public class Account {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
  
}
```
  - `balance` is encapsulated; it cannot be accessed directly from outside the `Account` class, enforcing data hiding and protecting the integrity of the balance.

#### 2.2 Inheritance  
- Mechanism for creating new classes based on existing ones.
- Promotes code reuse; supports hierarchical classification.

  _Example:_
```java
 public class Vehicle {
    //...
}

public class Car extends Vehicle {
    //...
}
```
  - `Car` inherits properties of `Vehicle`.

### 2.3 Polymorphism  
- Ability for one interface to be used for different data types.
- Types: Compile-time (method overloading) & runtime (method overriding).

  _Example (Overriding):_
```
  class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }
}
```
  - `Dog` overrides `makeSound()` method.

### 2.4 Abstraction  
- Hiding complex implementation details and exposing only the essentials.
- Achieved via abstract classes (`abstract`) and interfaces.

  _Example:_
```java
public interface Payment {
    void pay(double amount);
}
```
  - Only essential behavior (`pay`) is exposed.

---

## 3. 🛡️ Additional Concepts

### Constructors
- Special methods for object creation, can be overloaded.

### `this` and `super`
- `this`: Refers to current object.
- `super`: Calls parent class members.

### Association, Aggregation, Composition
- Ways to describe "has-a" (relationship between objects).
- **Composition** implies ownership and lifecycle management.

---

## 4. 📚 Best Practices

- Design for composition over inheritance, when possible.
- Use interfaces for contract definition.
- Keep classes focused; follow Single Responsibility Principle.
- Use access modifiers (`private`, `protected`, `public`) judiciously.

---

## 5. 📖 References

- [Java OOPs Concepts – Oracle](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [OOPs in Java – Baeldung](https://www.baeldung.com/java-oop)
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)

---

*Continually revisit these concepts—they are foundational for robust, maintainable Java (and general software) design!*
