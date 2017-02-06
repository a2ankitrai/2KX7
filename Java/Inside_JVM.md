# Inside JVM

JVM is the **virtual machine** on which **java code executes**.

JVM is responsible for **converting byte code into machine specific code**.

![jvm_architecture](./_image/jvm_architecture.png)

JVM (Java Virtual Machine) consists of **Class Loader Subsystem**, **Runtime Data Areas** and **Execution Engine**.

## Class Loader Subsystem

Classloader is a subsystem of JVM. Classloader is used to load class files. Classloader verifies the class file using byte code verifier. Class file will only be loaded if it is valid.

---

## Runtime Data Areas

### Method Area

Method area is also called class area. Method area stores data for each and every class like fields, constant pool, method’s data and information.

### Heap

Heap is place where all objects are stored in JVM. 

### Java Threads (Java thread Stacks) 

Every thread has its own stack. Whenever new method is called new stack frame is created and it is pushed on top of that thread's stack. Thread stack contains all the local variables, parameters and return address.
Stack never stores object, but it stores object reference.

### Program counter registers (PC Registers) 

Program counter registers contains the address of instructions currently being executed and address of next instruction as well.

### Native internal Threads (Native thread stack)

Native internal threads area contains all the informations related to native platform e.g. windows or linux.

---

## Execution Engine of JVM

Execution Engine contains JIT (Just In Time) Compiler and Garbage collector compiler. Execution Engine also contains Interpreter.

### JIT(Just In Time) compiler 

JIT compiler compiles bytecodes to machine code at run time and improves the performance of Java applications. Very frequently used methods are compiled as soon as JVM has started, and less used methods are compiled later.

### Garbage Collector

Garbage Collector's Garbage collection is the process by which JVM clears objects (unused objects) from heap to reclaim heap space.

***Interpreter*** is responsible for reading the bytecode and then executing the instructions.

---

***Native method libraries of JVM ***
Native method interface is an interface that connects JVM with the native method libraries for executing platform specific native methods.

Three components **Heap**, **JIT (Just In Time) Compiler** and **Garbage collector** are related to JVM’s performance tuning. There are many VM (JVM) options for 
- Increasing and decreasing the heap size for managing object for best performance.
- selecting the different garbage collector depending on your requirement.

---

## Java is platform independent language

Once source code (i.e. **.java** file) is compiled on one platform(**bytecode** is formed). That bytecode can be executed (interpreted) on any other platform running a JVM. Every platform have different JVM implementation.












---
 
Java addresses the security challenge by providing an environment in which programs downloaded across a network can be run with customizable degrees of security. A downloaded program can do anything it wants inside the boundaries of the secure environment, but can't read or write data outside those boundaries.

Platform independence, security, and network-mobility--these three facets of Java's architecture work
together to make Java suitable for the emerging networked computing environment. Because Java
programs are platform independent, network-delivery of software is more practical.
