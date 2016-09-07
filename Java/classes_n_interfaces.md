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
copies (Item 39) in constructors, accessors, and readObject methods.

---

## Favor composition over inheritance

Instead of extending an existing class, give your new class a private field that references
an instance of the existing class. This design is called ***composition*** because the
existing class becomes a component of the new one. Each instance method in the
new class invokes the corresponding method on the contained instance of the
existing class and returns the results. This is known as ***forwarding***, and the methods
in the new class are known as ***forwarding methods***.