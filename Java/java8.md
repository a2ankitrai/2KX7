# Java 7

- Generics Type inference for constructors

# Java 8

## Lambdas : functional programming.

## Abstract classes versus interfaces in Java 8

After introducing Default Method, it seems that interfaces and abstract classes are same. However, they are still different concept in Java 8.

Abstract class can define constructor. They are more structured and can have a state associated with them. While in contrast, default method can be implemented only in the terms of invoking other interface methods, with no reference to a particular implementation's state. Hence, both use for different purposes and choosing between two really depends on the scenario context.

---

## Stream

The Stream interface is located in the `java.util.stream` package. It represents a sequence of objects somewhat like the Iterator interface. However, unlike the Iterator, it supports parallel execution.

The Stream interface supports the map/filter/reduce pattern and executes lazily, forming the basis (along with lambdas) for functional-style programming in Java 8.