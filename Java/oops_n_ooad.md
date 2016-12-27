# OOPS and OOAD

# S.O.L.I.D. principles in java

![SOLID principle](./solid_class_design_principles.png) 

---

## Object-Oriented Analysis

Object-oriented analysis is a method of analysis that examines requirements from the perspective of the classes and objects found in the vocabulary of the problem domain.

The primary tasks in object-oriented analysis (OOA) are:

- Identifying objects

- Organizing the objects by creating object model diagram

- Defining the internals of the objects, or object attributes

- Defining the behavior of the objects, i.e., object actions

- Describing how the objects interact

---

## Overloading and Overriding

- Methods can be overridden or overloaded; constructors can be overloaded but not overridden.

- With respect to the method it overrides, the overriding method
	-	Must have the same argument list.
	-	Must have the same return type, except that as of Java 5, the return type can be a subclass—this is known as a covariant return.
	-	Must not have a more restrictive access modifier.
	-	May have a less restrictive access modifier.
	-	Must not throw new or broader checked exceptions.
	-	May throw fewer or narrower checked exceptions, or any unchecked exception.

- A subclass uses `super.overriddenMethodName()` to call the superclass version of an overridden method.

- Overloading means reusing a method name, but with different arguments.

- Overloaded methods
	- Must have different argument lists
	- May have different return types, if argument lists are also different
	- May have different access modifiers
	- May throw different exceptions
	- Methods from a superclass can be overloaded

- Polymorphism applies to overriding, not to overloading.

- **Object type (not the reference variable's type), determines which overridden method is used at runtime**.

- **Reference type determines which overloaded method will be used at compile time**.	

---

## Constructors and Instantiation

- A constructor is always invoked when a new object is created.

- Each superclass in an object's inheritance tree will have a constructor called.

- Every class, even an abstract class, has at least one constructor.

- Typical constructor execution occurs as follows:

	- The constructor calls its superclass constructor, which calls its superclass
constructor, and so on all the way up to the Object constructor.
	
	- The Object constructor executes and then returns to the calling
constructor, which runs to completion and then returns to its calling
constructor, and so on back down to the completion of the constructor of
the actual instance being created.

- The default constructor is a no-arg constructor with a no-arg call to super().

- The first statement of every constructor must be a call to either `this()` (an
overloaded constructor) or `super()`.

- The compiler will add a call to `super()` unless you have already put in a call
to `this()` or `super()`.

- If your superclass does not have a no-arg constructor, you must create a constructor
and insert a call to `super()` with arguments matching those
of the superclass constructor.

- A constructor can be directly invoked only by another constructor (using
a call to `super()` or `this()`).

- Issues with calls to `this()`:
	- May appear only as the first statement in a constructor.
	- The argument list determines which overloaded constructor is called.

- Calls to `this()` and `super()` cannot be in the same constructor. You can
have one or the other, but never both.

---

## Abstraction

The process of abstraction in Java is used to hide certain details and only show the essential features of the object. In other words, it deals with the outside view of an object (interface). The only good example i see for this across different sites is interface.

Abstraction in Java is achieved by  using interface and abstract class in Java.

--- 

## Encapsulation

Its basically about hiding the state of object with the help of modifiers like private,public,protected etc. we expose the state thru public methods only if require.

---

## Abstraction and Encapsulation difference

- Abstraction is implemented in Java using interface and abstract class while Encapsulation is implemented using private, package-private and protected access modifier.
 
- Encapsulation is also called data hiding. 