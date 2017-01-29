# Java Questions

# General

Q. Java Primitive data type on Stack or Heap?

When a method is called, certain data is placed on the stack. When the method finishes, data is removed from the stack. At other points in a program's execution, data is added to the stack, or removed from it.

Therefore, if you have a variable which is intended to outlive the execution of the method that created it, it needs to be on the heap. This applies both to any objects that you create, and any primitives that are stored within those objects.

However, if a variable is intended to go out of scope shortly after its creation - say, at the end of the method in which it's created, or even earlier, then it's appropriate for that variable to be created on the stack. Local variables and method arguments fit this criterion; if they are primitives, the actual value will be on the stack, and if they are objects, a reference to the object (but not the object itself) will be on the stack.

Q. ClassNotFoundException Vs NoClassDefFoundError

ClassNotFoundException :  ClassNotFoundException occurs when class loader could not find the required class in class path . So , basically you should check your class path and add the class in the classpath.

NoClassDefFoundError : This is more difficult to debug and find the reason. This is thrown when at compile time the required classes are present , but at run time the classes are changed  or removed or class's static initializes threw exceptions. It means the class which is getting loaded is present in classpath , but one of the classes which are required by this class , are either removed or failed to load by compiler .So you should see the classes which are dependent on this class .


---

# Thread

Q. What will happen if we don’t override run method of thread in java?

When we call start() method on thread, it internally calls run() method with newly created thread. So, if we don’t override run() method newly created thread won’t be called and nothing will happen.

Q. What will happen if we override start method of thread?

When we call start() method on thread, it internally calls run() method with newly created thread. So, if we override start() method, run() method will not be called until we write code for calling run() method.

Q. Difference between starting thread with run() and start() methods in java

When you call start() method, main thread internally calls run() method to start newly created Thread. So run() method is ultimately called by newly created thread. When you call run() method main thread rather than starting run() method with newly thread it start run() method by itself.

Q. Can we start Thread again in java?

No, we cannot start Thread again, doing so will throw runtimeException java.lang.IllegalThreadStateException. 

