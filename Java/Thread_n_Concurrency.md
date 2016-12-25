# Threads and Concurrency
---

## Thread Implementation

By extending the Thread class or implmenting the Runnable interface. In both cases need to implement the run() method.

```java
Runnable r = new Runnable() {
  public void run() {
	//	... code to be executed ...
  }
};
```

## Sleep, Yield and Join

### **Sleep**

`Thread.sleep()` method can be used to pause the execution of current thread for specified time in milliseconds. The argument value for milliseconds can’t be negative, else it throws `IllegalArgumentException`. Sleep implementation in Thread class is native.

```java
try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
```

**Sleep Properties**

- **sleep()** is a static method that is being called on the currently executing thread (it is always the current thread that is put to sleep). 
- while sleeping, the thread still owns synchronization locks it has acquired;
- Any other thread can interrupt the current thread in sleep, in that case `InterruptedException` is thrown.


### **Yield**

The java.lang.Thread.yield() method causes the currently executing thread object to temporarily pause and allow other threads to execute. This static method is essentially used to notify the system that the current thread is willing to "give up the CPU" for a while. The general idea is that:

> The thread scheduler will select a different thread to run instead of the current one.

Yield implementation in Thread class is native.

[Details](http://www.javamex.com/tutorials/threads/yield.shtml)

### **Join**

Java Thread join method can be used to pause the current thread execution until unless the specified thread is dead. 

For suppose in main thread we call `t1.join()` (t1 being another thread) then the execution of main will stop until t1 has been completed.

There are three overloaded join functions.

- `public final void join()`: puts the current thread on wait until the thread on which it’s called is dead. If the thread is interrupted, it throws InterruptedException.

- `public final synchronized void join(long millis)`: wait for the thread on which it’s called to be dead or wait for specified milliseconds. 

- `public final synchronized void join(long millis, int nanos)`: wait for thread to die for given milliseconds plus nanoseconds.

**ReverseHello**

---

## Thread interruption in Java

Interruption is a mechanism whereby a thread that is waiting (or sleeping) can be made to prematurely stop waiting.

The InterruptedException is thrown by the `Thread.sleep()` method. In general, `InterruptedException` is thrown when another thread interrupts the thread calling the blocking method. The other thread interrupts the blocking/sleeping thread by calling interrupt() on it:

```java
thr.interrupt();
```

---

## Threads and processes

A thread is essentially a **subdivision of a process**, or "lightweight process" (LWP) on some systems. A process is generally the most major and separate unit of execution recognised by the OS.

Crucially, **each process has its own memory space**.  A **thread** is a subdivision that **shares the memory space** of its parent process. On the other hand, each thread has its own private **stack** and **registers**, including program counter. These are essentially the things that threads need in order to be independent.

---

## Synchronized

---

## Waiting and Notifying

Wait, Noitfy and NotifyAll methods are defined in Object class not in Thread beacause it's the object whose lock is acquired or released while calling wait or notify respectively. When a thread enters a synchronized block w.r.t. an object it acquires it's lock. Within the thread `run()` method if `wait` is called on the object whose lock this thread is acquired; that lock will be released. The thread may again acquire a lock on this object in future when notify will be called from another thread.

### Wait

Object wait methods has three variance, one which waits indefinitely for any other thread to call notify or notifyAll method on the object to wake up the current thread. Other two variances puts the current thread in wait for specific amount of time before they wake up.

### notify

notify method wakes up only one thread waiting on the object and that thread starts execution. So if there are multiple threads waiting for an object, this method will wake up only one of them. The choice of the thread to wake depends on the OS implementation of thread management.

### notifyAll

notifyAll method wakes up all the threads waiting on the object, although which one will process first depends on the OS implementation.


---

# BlockingQueue

`java.util.concurrent.BlockingQueue` is a java Queue that support operations that wait for the queue to become non-empty when retrieving and removing an element, and wait for space to become available in the queue when adding an element.

Java BlockingQueue interface is part of java collections framework and it’s primarily used for implementing producer consumer problem.
Java provides several BlockingQueue implementations such as ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, SynchronousQueue etc.

**Important Methods**
- `put(E e)`: This method is used to insert elements to the queue. If the queue is full, it waits for the space to be available.
- `E take()`: This method retrieves and remove the element from the head of the queue. If queue is empty it waits for the element to be available.


---
# Thread Safety

A class is thread safe if it behaves correctly when accessed from multiple threads, regardless of the scheduling or 
interleaving of the execution of those threads by the runtime environment, and with no additional synchronization or 
other coordination on the part of the calling code. 

Stateless objects are always thread safe. *Stateless objects has no fields and references no fields from other classes*

---

## Race Conditions

A race condition occurs when  the correctness of a computation depends on the relative timing or interleaving of multiple threads by the runtime; in other words, when getting the right answer relies on lucky timing. The most common type of race condition is check then act, where a potentially stale observation is used to make a decision on what to do next.

---

## Thread local variables

---

## Executors

---

## CyclicBarrier and CountDownLatch

---

## Deadlocks
