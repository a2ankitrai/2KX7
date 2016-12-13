# Design Patterns
---

## Creational

### Singleton

### Factory

Creates objects without exposing the instantiation logic to the client and Refers to the newly created object through a common interface. When a method returns one of several possible classes that share a common super class.

The factory pattern allows you to create objects without specifying the exact class of object that will be created.

![factory](./_image/class_diagram_of_factory_pattern_in_java1.png)

**Examples**

- java.sql.DriverManager#getConnection()
- java.net.URL#openConnection()
- java.lang.Class#newInstance()
- java.lang.Class#forName()

---

### Factory Method

---
### Abstract Factory

---
### Builder

---
### Prototype

---
### Object Pool


---

## Structural 

### Adapter

### Bridge

### Composite

### Decorator

### Flyweight

**Intent**

- Use sharing to support large numbers of fine-grained objects efficiently.


### Memento

### Proxy


---

## Behavioral
---

### Chain of Responsibilty

Gives more than one object an opportunity to handle a request by linking receiving objects together.

**Reference implementations in JDK**

javax.servlet.Filter#doFilter()

The doFilter method of the Filter is called by the container each time a request/response pair is passed through the chain due to a client request for a resource at the end of the chain. The FilterChain passed in to this method allows the Filter to pass on the request and response to the next entity in the chain.

java.util.logging.Logger#log

If the logger is currently enabled for the given message level then the given message is forwarded to all the registered output Handler objects.

---
### Command

### Interpreter

### Iterator

### Mediator

### Observer

### Strategy

### Template method

### Visitor

### Null Object

---
