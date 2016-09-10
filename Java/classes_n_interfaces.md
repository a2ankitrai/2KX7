# Classes & Interfaces

## Minimize the accessibility of classes and members

A well-designed module hides all of its implementation details, cleanly separating its API from its implementation.
Modules then communicate only through their APIs and are oblivious to
each others' inner workings. This concept, known as **information hiding** or **encapsulation**,
is one of the fundamental tenets of software design.

**Information hiding** is important because :-

- it decouples the modules that comprise a system, allowing them to be developed, tested, optimized, used, understood, and modified in isolation.

- While information
hiding does not, in and of itself, cause good performance, it enables effective
performance tuning: once a system is complete and profiling has determined
which modules are causing performance problems, those modules can
be optimized without affecting the correctness of other modules.

- Information hiding
increases software reuse because modules that aren't tightly coupled often
prove useful in other contexts besides the ones for which they were developed.

- Finally, information hiding decreases the risk in building large systems, because
individual modules may prove successful even if the system does not.

**Access control mechanism**

The accessibility of an entity is determined by the location of its declaration and by
which, if any, of the access modifiers (private, protected, and public) is present
on the declaration. Proper use of these modifiers is essential to information hiding.
The rule of thumb is simple: **make each class or member as inaccessible as
possible.**

There is one rule that restricts your ability to reduce the accessibility of methods.
If a method overrides a superclass method, it is not permitted to have a lower
access level in the subclass than it does in the superclass. This is
necessary to ensure that an instance of the subclass is usable anywhere that an
instance of the superclass is usable.

A special case of this rule is that if a class implements an interface, all of the class methods that are also
present in the interface must be declared public. This is so because all members of
an interface are implicitly public

**Instance fields should never be public**
If an instance field is nonfinal,
or is a final reference to a mutable object, then by making the field public,
you give up the ability to limit the values that can be stored in the field.
Even if a field is final and refers
to an immutable object, by making the field public you give up the flexibility to
switch to a new internal data representation in which the field does not exist.

---

## Minimize mutability

An immutable class is simply a class whose instances cannot be modified.To make a class immutable, follow these five rules:

1. **Don’t provide any methods that modify the object’s state** (known as mutators).

2. **Ensure that the class can’t be extended.** Preventing subclassing is generally accomplished
by making the class final, but there is an alternative. The alternative to making an immutable class final is to make all of
its constructors private or package-private, and to add public static factories in
place of the public constructors.

3. **Make all fields final.**

4. **Make all fields private.** This prevents clients from obtaining access to mutable
objects referred to by fields and modifying these objects directly. While it
is technically permissible for immutable classes to have public final fields containing
primitive values or references to immutable objects, it is not recommended
because it precludes changing the internal representation in a later
release.

5. **Ensure exclusive access to any mutable components.** If your class has any
fields that refer to mutable objects, ensure that clients of the class cannot obtain
references to these objects. Never initialize such a field to a client-provided object
reference or return the object reference from an accessor. Make defensive
copies in constructors, accessors, and readObject methods.

Advantages of Immutability:-

**Immutable objects are simple.** An immutable object can be in exactly one state, the state in which it was created.

**Immutable objects are inherently thread-safe; they require no synchronization.**
They cannot be corrupted by multiple threads accessing them concurrently.Therefore, **immutable objects can be shared freely.**

An immutable class can provide static factories  that cache frequently requested instances to avoid creating
new instances when existing ones would do. All the boxed primitive classes and
BigInteger do this. Using such static factories causes clients to share instances
instead of creating new ones, reducing memory footprint and garbage collection
costs. 


---

## Favor composition over inheritance

Instead of extending an existing class, give your new class a private field that references
an instance of the existing class. This design is called ***composition*** because the
existing class becomes a component of the new one. Each instance method in the
new class invokes the corresponding method on the contained instance of the
existing class and returns the results. This is known as ***forwarding***, and the methods
in the new class are known as ***forwarding methods***.

---

## Prefer interfaces to abstract classes

**interfaces and abstract classes.** The most obvious difference between the two mechanisms is that abstract classes are permitted
to contain implementations for some methods while interfaces are not.

**Existing classes can be easily retrofitted to implement a new interface.** All
you have to do is add the required methods if they don’t yet exist and add an
implements clause to the class declaration. For example, many existing classes
were retrofitted to implement the Comparable interface when it was introduced
into the platform. Existing classes cannot, in general, be retrofitted to extend a
new abstract class.

**Interfaces are ideal for defining mixins.** Loosely speaking, a mixin is a type
that a class can implement in addition to its “primary type” to declare that it provides
some optional behavior. For example, Comparable is a mixin interface that
allows a class to declare that its instances are ordered with respect to other mutually
comparable objects. Abstract classes can’t be used to define mixins for the same reason that they can’t
be retrofitted onto existing classes: a class cannot have more than one parent, and
there is no reasonable place in the class hierarchy to insert a mixin.

**Interfaces allow the construction of nonhierarchical type frameworks.**
Type hierarchies are great for organizing some things, but other things don’t fall
neatly into a rigid hierarchy.

Exceptions:

Using abstract classes to define types that permit multiple implementations
has one great advantage over using interfaces: **It is far easier to evolve an
abstract class than an interface.** If, in a subsequent release, you want to add a
new method to an abstract class, you can always add a concrete method containing
a reasonable default implementation. All existing implementations of the abstract
class will then provide the new method. This does not work for interfaces.

**Once an interface is released and widely implemented, it is almost impossible to change.**

To summarize, an interface is generally the best way to define a type that
permits multiple implementations. An exception to this rule is the case where ease
of evolution is deemed more important than flexibility and power. Under these
circumstances, you should use an abstract class to define the type, but only if you
understand and can accept the limitations.