# Garbage Collection

---

**Garbage** means memory the system has previously allocated is no longer being used. For the illusion of infinite memory to work, the language needs to be very safe about “no longer being used”. In order to be collectible, the language has to ensure there’s no way for the program to use that object again. If it can’t get a reference to the object, then it obviously can’t use it again.

The definition of **in use**:

- Any object that’s being referenced by a variable that’s still in scope is in use.

- Any object that’s referenced by another object that’s in use is in use. 

The second rule is the recursive one. If object A is referenced by a variable, and it has some field that references object B, then B is in use since you can get to it through A.

The end result is a graph of reachable objects-all of the objects in the world that you can get to by starting at a variable and traversing through objects. Any object not in that graph of reachable objects is dead to the program and its memory is ripe for a reaping.

---

A garbage collector (GC) is a memory management tool. It achieves automatic memory management through the following operations:

- Allocating objects to a young generation and promoting aged objects into an old generation.

- Finding live objects in the old generation through a concurrent (parallel) marking phase. The Java HotSpot VM triggers the marking phase when the total Java heap occupancy exceeds the default threshold.

- Recovering free memory by compacting live objects through parallel copying. 

---

## Some Pointers

- Objects are created on the heap in Java irrespective of their scope e.g. local or member variable. while it's worth noting that class variables or static members are created in method area of Java memory space and both heap and method area is shared between different thread.

- Garbage Collection in Java is carried by a daemon thread called Garbage Collector.

- Before removing an object from memory garbage collection thread invokes `finalize()` method of that object and gives an opportunity to perform any sort of cleanup required. 

- There are methods like System.gc() and Runtime.gc() which is used to send request of Garbage collection to JVM but it’s not guaranteed that garbage collection will happen.

- If there is no memory space for creating a new object in Heap Java Virtual Machine throws OutOfMemoryError or `java.lang.OutOfMemoryError` heap space.


## When an Object becomes Eligible for Garbage Collection

- All references to that object explicitly set to null e.g. object = null

- The object is created inside a block and reference goes out scope once control exit that block.

- Parent object set to null; if an object holds the reference to another object and when you set container object's reference null, child or contained object automatically becomes eligible for garbage collection.

- If an object has only lived weak references via `WeakHashMap` it will be eligible for garbage collection.

---

## Heap Generations for Garbage Collection in Java

Heap is divided into three parts or generations for the sake of garbage collection in Java.

These are called as **Young generation**, **Tenured** or **Old Generation** and **Perm Area** of the heap.  New Generation is further divided into three parts known as **Eden space**, **Survivor 1** and **Survivor 2** space. When an object first created in heap its gets created in new generation inside **Eden space** and after subsequent **minor garbage collection** if an object survives its gets moved to **survivor 1** and then **survivor 2** before **major garbage collection** moved that object to old or **tenured generation**.

![gc_jvm_image.jpg](./_image/gc_jvm_image.jpg)

---

## Reference classes

### Strong Reference 

String s = "abc" , reference variable s has strong reference to String object "abc". Any object which has Strong reference attached to it is not eligible for garbage collection. Obviously these are objects which is needed by Java program.

###  Weak Reference 

Represented using `java.lang.ref.WeakReference` class and you can create Weak Reference by using following code :

```java
Counter counter = new Counter(); // strong reference - line 1
WeakReference<Counter> weakCounter = new WeakReference<Counter>(counter); //weak reference
counter = null; // now Counter object is eligible for garbage collection
```

SoftReference are more suitable for caches and WeakReference are more suitable for storing meta data. 



---

## Marking and sweeping

The first algorithm ever invented for GC is "mark-sweep". It works almost exactly like our definition of reachability:

- Starting at the roots, traverse the entire object graph. Every time you reach an object, set a “mark” bit on it to true.

- Once that’s done, find all of the objects whose mark bits are not set and delete them.

---

