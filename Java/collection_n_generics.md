# Generics

---

## Benefits

- Stronger type checks at compile time. 

- Elimination of casts.

- Enabling programmers to implement generic algorithms.

---

## Raw Types

A raw type is the name of a generic class or interface without any type arguments. For example, given the generic Box class:

```java
public class Box<T> {
    public void set(T t) { /* ... */ }
    // ...
}
```

parameterized type: ```Box<Integer> intBox = new Box<>();```

raw type: ```Box rawBox = new Box();```

For backward compatibility, assigning a parameterized type to its raw type is allowed. But if you assign a raw type to a parameterized type, you get a warning.

You also get a warning if you use a raw type to invoke generic methods defined in the corresponding generic type:
```java
Box<String> stringBox = new Box<>();
Box rawBox = stringBox;
rawBox.set(8);  // warning: unchecked invocation to set(T)
```
The warning shows that raw types bypass generic type checks, deferring the catch of unsafe code to runtime. Therefore, you should avoid using raw types.
 
---

## Bounded Type Parameters

Restrict the types that can be used as type arguments in a parameterized type. For example, a method that operates on numbers might only want to accept instances of Number or its subclasses.
 
To declare a bounded type parameter, list the type parameter's name, followed by the `extends` keyword, followed by its upper bound, which in this example is `Number`. **Note that, in this context, `extends` is used in a general sense to mean either `extends` (as in classes) or `implements` (as in interfaces).**

In addition to limiting the types you can use to instantiate a generic type, bounded type parameters allow you to invoke methods defined in the bounds:
```java
public class NaturalNumber<T extends Integer> {

    private T n;

    public NaturalNumber(T n)  { this.n = n; }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }

    // ...
}
```

---
## Generic Methods

Generic methods are methods that introduce their own type parameters. This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it is declared. Static and non-static generic methods are allowed, as well as generic class constructors.

The syntax for a generic method includes a type parameter, inside angle brackets, and appears before the method's return type. For static generic methods, the type parameter section must appear before the method's return type.

```java
public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
    int counter = 0;
    for (Box<U> box: boxes) {
      U boxContents = box.get();
      System.out.println("Box #" + counter + " contains [" +
             boxContents.toString() + "]");
      counter++;
    }
  }
```

### Generic Methods and Bounded Type Parameters

Consider the following method:
```java
public static <T> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
        if (e > elem)  // compiler error
            ++count;
    return count;
}
```
it does not compile because the greater than operator (>) applies only to primitive types such as short, int, double, long, float, byte, and char. You cannot use the > operator to compare objects. To fix the problem, use a type parameter bounded by the Comparable<T> interface:
```java
public interface Comparable<T> {
    public int compareTo(T o);
}
```
The resulting code will be:
```java
public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
        if (e.compareTo(elem) > 0)
            ++count;
    return count;
}
```

---

## Type Inference and Instantiation of Generic Classes

*Type inference* is a Java compiler's ability to look at each method invocation and corresponding declaration to determine the type argument (or arguments) that make the invocation applicable.

You can replace the type arguments required to invoke the constructor of a generic class with an empty set of type parameters (<>) as long as the compiler can infer the type arguments from the context.

For example, consider the following variable declaration:

```java
Map<String, List<String>> myMap = new HashMap<String, List<String>>();
```

You can substitute the parameterized type of the constructor with an empty set of type parameters (<>):
```java
Map<String, List<String>> myMap = new HashMap<>();
```

---

## Wildcards

In generic code, the question mark (?), called the wildcard, represents an unknown type. The wildcard can be used in a variety of situations: as the type of a parameter, field, or local variable; sometimes as a return type (though it is better programming practice to be more specific). The wildcard is never used as a type argument for a generic method invocation, a generic class instance creation, or a supertype.










