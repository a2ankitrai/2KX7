# Threads and Concurrency
---

## Threads and processes

A thread is essentially a **subdivision of a process**, or "lightweight process" (LWP) on some systems. A process is generally the most major and separate unit of execution recognised by the OS.

Crucially, **each process has its own memory space**.  A **thread** is a subdivision that **shares the memory space** of its parent process. On the other hand, each thread has its own private **stack** and **registers**, including program counter. These are essentially the things that threads need in order to be independent.

---

**Thread States**

![Thread_states](./_image/Thread_states.png)

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

The `java.lang.Thread.yield()` method causes the currently executing thread object to temporarily pause and allow other threads to execute. This **static method** is essentially used to notify the system that the current thread is willing to "give up the CPU" for a while. The general idea is that:

> The thread scheduler will select a different thread to run instead of the current one.

Yield implementation in Thread class is native. During yield the thread still owns synchronization locks it has acquired.

[Details](http://www.javamex.com/tutorials/threads/yield.shtml)

### **Join**

Java Thread join method can be used to pause the current thread execution until unless the specified thread is dead. 

For suppose in main thread we call `t1.join()` (`t1` being another thread) then the execution of main will stop until `t1` has been completed.

There are three overloaded join functions.

- `public final void join()`: puts the current thread on wait until the thread on which it’s called is dead. If the thread is interrupted, it throws InterruptedException.

- `public final synchronized void join(long millis)`: wait for the thread on which it’s called to be dead or wait for specified milliseconds. 

- `public final synchronized void join(long millis, int nanos)`: wait for thread to die for given milliseconds plus nanoseconds.

**ReverseHello**

---

## Thread interruption in Java

Interruption is a mechanism whereby a thread that is waiting (or sleeping) can be made to prematurely stop waiting.

The InterruptedException is thrown by the `Thread.sleep()` method. In general, `InterruptedException` is thrown when another thread interrupts the thread calling the blocking method. The other thread interrupts the blocking/sleeping thread by calling interrupt() on it:

Thread provides the interrupt method for interrupting a thread and for querying whether a thread has been interrupted. Each thread has a boolean property
that represents its interrupted status; interrupting a thread sets this status .

```java
thread.interrupt();
```


---

## Synchronized

### Acquiring lock on class, 2 Ways to acquire lock on class in java

Thread can acquire lock on class’s class object by-
- Entering synchronized block and parameter passed with synchronization tells which class has to be synchronized
	
	```java
	synchronized (MyClass.class) {
          //thread has acquired lock on MyClass’s class object.
       }
	```
	
- Entering static synchronized methods.

	```java
	public static synchronized void method1() {
          //thread has acquired lock on MyRunnable’s class object.
       }
	```

---

## Waiting and Notifying

Wait, Noitfy and NotifyAll methods are defined in Object class not in Thread beacause it's the object whose lock is acquired or released while calling wait or notify respectively. When a thread enters a synchronized block w.r.t. an object it acquires it's lock. Within the thread `run()` method if `wait` is called on the object whose lock this thread is acquired; that lock will be released. The thread may again acquire a lock on this object in future when notify will be called from another thread.

### Wait

Object wait methods has three variance, one which waits indefinitely for any other thread to call notify or notifyAll method on the object to wake up the current thread. Other two variances puts the current thread in wait for specific amount of time before they wake up.

### notify

notify method wakes up only one thread waiting on the object and that thread starts execution. So if there are multiple threads waiting for an object, this method will wake up only one of them. The choice of the thread to wake depends on the OS implementation of thread management.

### notifyAll

notifyAll method wakes up all the threads waiting on the object, although which one will process first depends on the OS implementation.

**Key Points**

- Before calling these methods thread must own object’s monitor means `wait()` and `notify()` methods must be called from synchronized blocks or synchronized method otherwise `IllegalMonitorStateException` is thrown at runtime.
- Native methods : implementation of wait() and notify() methods are provided by JVM.

[Producer - Consumer problem](./eclipse_projects/Threads/src/main/java/com/thread/producerConsumer)

---

## Volatile

When a field is declared volatile, the compiler and runtime
are put on notice that this variable is shared and that operations on it should not
be reordered with other memory operations. Volatile variables are not cached in
registers or in caches where they are hidden from other processors, so a read of a
volatile variable always returns the most recent write by any thread.

It is possible for multiple CPU’s to exist on machine, so it is possibility that thread might cache different values in different CPU’s for same variable, so it’s important that value is not cached in CPU and always read from main memory.

A compile-time error will occur if a final variable is declared volatile.
```
 volatile final int x = 0; //The field x can be either final or volatile, not both. 
```

**Key Points**

- If a field is declared volatile, in that case the Java memory model ensures that all threads see a consistent value for the variable.
- Locking can guarantee both visibility and atomicity; volatile variable can only guarantee visibilty.

You can use volatile variables only when all the following criteria are met:
- Writes to the variable do not depend on its current value, or you can ensure that only a single thread ever updates the value;
- The variable does not participate in invariants with other state variables; and
- Locking is not required for any other reason while the variable is being accessed.

---

## Race Conditions

A race condition occurs when  the correctness of a computation depends on the relative timing or interleaving of multiple threads by the runtime; in other words, when getting the right answer relies on lucky timing. The most common type of race condition is check then act, where a potentially stale observation is used to make a decision on what to do next.


---

# BlockingQueue

Blocking queues provide blocking `put` and `take` methods as well as the timed equivalents `offer` and `poll`. If the queue is full, put blocks until space becomes available; if the queue is empty, take blocks until an element is available. Queues can be bounded or unbounded; unbounded queues are never full, so a put on an unbounded queue never blocks.

Blocking queues support the *producer-consumer* design pattern.

`java.util.concurrent.BlockingQueue` is a java Queue that support operations that wait for the queue to become non-empty when retrieving and removing an element, and wait for space to become available in the queue when adding an element.

Java `BlockingQueue` interface is part of java collections framework and it’s primarily used for implementing producer consumer problem.
Java provides several BlockingQueue implementations such as `ArrayBlockingQueue`, `LinkedBlockingQueue`, `PriorityBlockingQueue`, `SynchronousQueue` etc.

`LinkedBlockingQueue` and `ArrayBlockingQueue` are FIFO queues, analogous to `LinkedList` and `ArrayList` but with better concurrent performance than a synchronized List. `PriorityBlockingQueue` is a priority-ordered queue, which is useful when you want to process elements in an order other than FIFO. Just like other sorted collections, `PriorityBlockingQueue` can compare elements according to their natural order (if they implement `Comparable`) or using a `Comparator`.

`SynchronousQueue`, is not really a queue at all, in that it maintains no storage space for queued elements. Instead, it maintains a list of queued threads waiting to enqueue or dequeue an element. Since a `SynchronousQueue` has no storage capacity, put and take will block unless another thread is already waiting to participate in the handoff. Synchronous queues are generally suitable only when there are enough consumers that there nearly always will be one ready to take the handoff.

**Important Methods**
- `put(E e)`: This method is used to insert elements to the queue. If the queue is full, it waits for the space to be available.
- `E take()`: This method retrieves and remove the element from the head of the queue. If queue is empty it waits for the element to be available.


## Deques and Work Stealing

A Deque is a double-ended queue that allows efficient insertion and removal from both the head and the tail. Implementations include `ArrayDeque` and `LinkedBlockingDeque`.

A producer-consumer design has one shared work queue for all consumers; in a work stealing design, every consumer has its own deque. If a consumer exhausts the work in its own deque, it can steal work from the tail of someone else’s deque. Work stealing can be more scalable than a traditional producer-consumer design because workers don’t contend for a shared work queue; most of the time they access only their own deque, reducing contention. When a worker has to access another’s queue, it does so from the tail rather than the head, further reducing contention.

Work stealing is well suited to problems in which consumers are also producers - when performing a unit of work is likely to result in the identification of more work. For example, processing a page in a web crawler usually results in the identification of new pages to be crawled. Similarly, many graph-exploring algorithms, such as marking the heap during garbage collection, can be efficiently parallelized using work stealing. When a worker identifies a new unit of work, it places it at the end of its own deque (or alternatively, in a work sharing design, on that of another worker); when its deque is empty, it looks for work at the end of someone else’s deque, ensuring that each worker stays busy.

---

## Synchronizers

A *synchronizer* is any object that coordinates the control flow of threads based on its state. Blocking queues can act as synchronizers; other types of synchronizers include **semaphores**, **barriers**, and **latches**.

### Latches

A *latch* is a synchronizer that can delay the progress of threads until it reaches its *terminal* state. A latch acts as a gate: until the latch reaches the terminal state the gate is closed and no thread can pass, and in the terminal state the gate opens, allowing all threads to pass. Once the latch reaches the terminal state, it cannot change state again, so it remains open forever. Latches can be used to ensure that certain activities do not proceed until other one-time activities complete, such as:

- Ensuring that a computation does not proceed until resources it needs have been initialized.

- Ensuring that a service does not start until other services on which it depends have started.

- Waiting until all the parties involved in an activity, for instance the players in a multi-player game, are ready to proceed. In this case, the latch reaches the terminal state after all the players are ready.

`CountDownLatch` is a flexible latch implementation that can be used in any of these situations; it allows one or more threads to wait for a set of events to occur. The latch state consists of a counter initialized to a positive number, representing the number of events to wait for. The `countDown` method decrements the counter, indicating that an event has occurred, and the await methods wait for the counter to reach zero, which happens when all the events have occurred. If the counter is nonzero on entry, `await` blocks until the counter reaches zero, the waiting thread is interrupted, or the wait times out.

[Latch Code](./eclipse_projects/Threads/src/main/java/com/thread/synchronizers/LatchTest.java)

### FutureTask

`FutureTask` implements Future, which describes an abstract result-bearing computation. A computation represented by a `FutureTask` is implemented with a `Callable`, the result-bearing equivalent of `Runnable`, and can be in one of three states: waiting to run, running, or completed. Completion subsumes all the ways a computation can complete, including normal completion, cancellation, and exception. Once a `FutureTask` enters the completed state, it stays in that state forever.

The behavior of Future.get depends on the state of the task. If it is completed, get returns the result immediately, and otherwise blocks until the task transitions to the completed state and then returns the result or throws an exception. `FutureTask` conveys the result from the thread executing the computation to the thread(s) retrieving the result; the specification of `FutureTask` guarantees that this transfer constitutes a safe publication of the result.

### Semaphores

Counting semaphores are used to control the number of activities that can access a certain resource or perform a given action at the same time. Counting semaphores can be used to implement resource pools such as database connection pools or to impose a bound on a collection.

A Semaphore manages a set of virtual permits; the initial number of permits is passed to the Semaphore constructor. Activities can acquire permits (as long as some remain) and release permits when they are done with them. If no permit is available, acquire blocks until one is (or until interrupted or the operation times out). The release method returns a permit to the semaphore. A degenerate case of a counting semaphore is a binary semaphore, a Semaphore with an initial count of one. A binary semaphore can be used as a mutex with nonreentrant locking semantics; whoever holds the sole permit holds the mutex.

A semaphore controls access to a shared resource by using permits in java.

- If permits are greater than zero, then semaphore allow access to shared resource.
- If permits are zero or less than zero, then semaphore does not allow access to shared resource.

These permits are sort of counters, which allow access to the shared resource. Thus, to access the resource, a thread must be granted a permit from the semaphore.

**Methods**

- void acquire( ) throws InterruptedException
- void release( )



### Barriers

Barriers are similar to latches in that they block a group of threads until some event has occurred. The key difference is that with a barrier, all the threads must come together at a barrier point at the same time in order to proceed. Latches are for waiting for events; barriers are for waiting for other threads.

`java.util.concurrent.CyclicBarrier` is java implementation.

[Cyclic Barrier](./eclipse_projects/Threads/src/main/java/com/thread/synchronizers/PatternPrint.java)

- `public CyclicBarrier(int parties);`
	Creates a new CyclicBarrier that will trip when the given number of parties (threads) are waiting upon it, and does not perform a predefined action when the barrier is tripped.
	
	Parameters: parties - the number of threads that must invoke await() before the barrier is tripped 
	
	Throws: IllegalArgumentException - if parties is less than 1 

- `public CyclicBarrier(int parties, Runnable barrierAction)`
	Creates a new CyclicBarrier that will trip when the given number of parties (threads) are waiting upon it, and which will execute the given barrier action when the barrier is tripped, performed by the last thread entering the barrier.

	Parameters: 
		
	parties - the number of threads that must invoke await() before the barrier is tripped 
	
	barrierAction - the command to execute when the barrier is tripped, or null if there is no action 
	
	Throws: IllegalArgumentException - if parties is less than 1

---

## Deadlocks

Deadlock is a situation where two threads are waiting for each other to release lock holded by them on resources.

**Measures to avoid Deadlock**

- Lock specific member variables of class rather than locking whole class: We must try to lock specific member variables of class rather than locking whole class.

Deadlocks Detecting Tool - VisualVM, jstack.

- `suspend`, `resume` and `destroy` method are deprecated because they are deadlock prone.

---

# Task Execution

**Tasks:** abstract, discrete units of work.

**Executing tasks sequentially**: The simplest is to execute tasks sequentially in a single thread. Perform poorly in production because it can handle only one request at a time. In server applications, sequential processing rarely provides either good throughput or good responsiveness.

**Explicitly creating threads for tasks**: A more responsive approach is to create a new thread for servicing each request. Under light to moderate load, the thread-per-task approach is an improvement
over sequential execution. As long as the request arrival rate does not exceed the
server’s capacity to handle requests, this approach offers better responsiveness
and throughput.

## Disadvantages of unbounded thread creation

**Thread lifecycle overhead.** Thread creation and teardown are not free. The actual
overhead varies across platforms, but thread creation takes time, introducing
latency into request processing, and requires some processing activity
by the JVM and OS. If requests are frequent and lightweight, as in most
server applications, creating a new thread for each request can consume
significant computing resources.

**Resource consumption.** Active threads consume system resources, especially
memory. When there are more runnable threads than available processors,
threads sit idle. Having many idle threads can tie up a lot of memory,
putting pressure on the garbage collector, and having many threads competing
for the CPUs can impose other performance costs as well. If you have
enough threads to keep all the CPUs busy, creating more threads won’t help
and may even hurt.

**Stability.** There is a limit on how many threads can be created. The limit varies
by platform and is affected by factors including JVM invocation parameters,
the requested stack size in the Thread constructor, and limits on threads
placed by the underlying operating system. When you hit this limit, the
most likely result is an OutOfMemoryError. Trying to recover from such an
error is very risky; it is far easier to structure your program to avoid hitting
this limit.

---

## The Executor framework

Executing tasks sequentially in a single thread, and execute each task in its
own thread. Both have serious limitations: the sequential approach suffers from
poor responsiveness and throughput, and the thread-per-task approach suffers
from poor resource management.

The primary abstraction for task execution in the Java class libraries is not Thread, but `Executor`

```java
public interface Executor {
	void execute(Runnable command);
}
```

It provides a standard means of decoupling task submission from task execution, describing tasks with Runnable.
The `Executor` implementations also provide lifecycle support and hooks for adding statistics
gathering, application management, and monitoring.

`Executor` is based on the producer-consumer pattern, where activities that submit tasks are the producers (producing units of work to be done) and the threads that execute tasks are the consumers (consuming those units of work). Using an Executor is usually the easiest path to implementing a producer-consumer design in your application.

---

**Thread pools** : a homogeneous pool of worker threads. A thread pool is tightly bound to a work queue holding tasks waiting to be executed. Worker threads have a simple life: request the next task from the work queue, execute it, and go back to waiting for another task.

Executing tasks in pool threads has a number of advantages over the threadper-
task approach. Reusing an existing thread instead of creating a new one
amortizes thread creation and teardown costs over multiple requests. Create a thread pool by calling
one of the static factory methods in Executors:

create a thread pool by calling
one of the static factory methods in `Executors` class:

**newFixedThreadPool.** A fixed-size thread pool creates threads as tasks are submitted,
up to the maximum pool size, and then attempts to keep the pool
size constant (adding new threads if a thread dies due to an unexpected
Exception).

**newCachedThreadPool.** A cached thread pool has more flexibility to reap idle
threads when the current size of the pool exceeds the demand for processing,
and to add new threads when demand increases, but places no bounds
on the size of the pool.

**newSingleThreadExecutor.** A single-threaded executor creates a single worker
thread to process tasks, replacing it if it dies unexpectedly. Tasks are guaranteed
to be processed sequentially according to the order imposed by the
task queue (FIFO, LIFO, priority order).

**newScheduledThreadPool.** A fixed-size thread pool that supports delayed and
periodic task execution, similar to Timer.

Submitting a task with execute adds the task to the work
queue, and the worker threads repeatedly dequeue tasks from the work queue
and execute them.

---

### Executor lifecycle

Since Executors provide a service to applications, they should be able to
be shut down as well, both gracefully and abruptly, and feed back information to
the application about the status of tasks that were affected by the shutdown.

To address the issue of execution service lifecycle, the ExecutorService interface
extends Executor, adding a number of methods for lifecycle management
(as well as some convenience methods for task submission).

```java
public interface ExecutorService extends Executor {
	void shutdown();
	List<Runnable> shutdownNow();
	boolean isShutdown();
	boolean isTerminated();
	boolean awaitTermination(long timeout, TimeUnit unit)
	throws InterruptedException;
	// ... additional convenience methods for task submission
}
```

The lifecycle implied by ExecutorService has three states—running, shutting
down, and terminated. ExecutorServices are initially created in the running state.
The shutdown method initiates a graceful shutdown: no new tasks are accepted
but previously submitted tasks are allowed to complete—including those that
have not yet begun execution. The shutdownNow method initiates an abrupt shutdown:
it attempts to cancel outstanding tasks and does not start any tasks that
are queued but not begun.



---

# Thread Safety

A class is thread safe if it behaves correctly when accessed from multiple threads, regardless of the scheduling or interleaving of the execution of those threads by the runtime environment, and with no additional synchronization or other coordination on the part of the calling code. 

Stateless objects are always thread safe. *Stateless objects has no fields and references no fields from other classes.*

---

## Thread local variables

`ThreadLocal` is used to create thread local variables. Every thread has it’s own `ThreadLocal` variable and they can use it’s `get()` and `set()` methods to get the default value or change it’s value local to Thread.

When you have some object that is not thread-safe, but you want to avoid synchronizing access to that object you can use `ThreadLocal`.

ThreadLocal in Java is a different way to achieve thread-safety, it doesn't address synchronization requirement, instead it eliminates sharing by providing explicitly copy of Object to each thread. Since Object is no more shared there is no requirement of Synchronization which can improve scalability and performance of application.

### Usage of ThreadLocal class:

-  ThreadLocal are fantastic to implement Per Thread Singleton classes or per thread context information like transaction id.

- You can wrap any non Thread Safe object in ThreadLocal and suddenly its uses becomes Thread-safe, as its only being used by Thread Safe. One of the classic example of ThreadLocal is sharing SimpleDateForamt. Since SimpleDateFormat is not thread safe, having a global formatter may not work but having per Thread formatter will certainly work.


---

## Executors

Executor implementation in java uses thread pools which consists of worker threads. The entire management of worker threads is handled by the framework. So the overhead in memory management is much reduced compared to earlier multithreading approaches.

The **Java Executor framework** provides multi-threading applications an easy abstraction layer. The executor abstraction layer hides the critical parts of concurrent execution and the programmer only concentrates on the business logic implementation. In java executor framework all parallel works are considered as tasks instead of simple threads. So the application now deals simply with instances of **Runnable** (which is basically collections of tasks or parallel works) and then it is passed to an **Executor** to process. The **ExecutorService** interface extends the simplistic **Executor** interface. The **Java Executor framework** has life cycle methods to manage the entire concurrent execution flow.

The **Java Executor framework** creates tasks by using instances of **Runnable** or **Callable**. In case of Runnable, the `run ()` method does not return a value or throw any checked exception. But **Callable** is a more functional version in that area. It defines a `call ()` method that allows the return of some computed value which can be used in future processing and it also throws an exception if necessary.

The `FutureTask` class is another important component which is used to get future information about the processing. An instance of this class can wrap either a `Callable` or a `Runnable`. You can get an instance of this as the return value of submit () method of an `ExecutorService`. You can also manually wrap your task in a `FutureTask` before calling execute () method.

---

### Steps to implement the Java ThreadPoolExecutor.

- A **pool** of multiple threads is created.

- A **queue** is created holding all the tasks but these tasks are not yet assigned to threads from the pool.

- **Rejection handler** is used to handle the situation when one or more tasks are not able to assign in the queue. As per the default rejection policy, it will simply throw a RejectedExecutionException runtime exception, and the application can catch it or discard it



---

### Executor << Interface >>

```java
package java.util.concurrent;

public interface Executor {
	void execute(Runnable arg0);
}
```

An object that executes submitted Runnable tasks. This interface provides a way of decoupling task submission from the mechanics of how each task will be run, including details of thread use, scheduling, etc. An Executor is normally used instead of explicitly creating threads. For example, rather than invoking new Thread(new(RunnableTask())).start() for each of a set of tasks, you might use:

```java
 Executor executor = anExecutor;
 executor.execute(new RunnableTask1());
 executor.execute(new RunnableTask2());
 ...
``` 

### ExecutorService << Interface >>

```java
public interface ExecutorService
extends Executor
```

An Executor that provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.

An `ExecutorService` can be shut down, which will cause it to reject new tasks. Two different methods are provided for shutting down an `ExecutorService`. The `shutdown()` method will allow previously submitted tasks to execute before terminating, while the `shutdownNow()` method prevents waiting tasks from starting and attempts to stop currently executing tasks. Upon termination, an executor has no tasks actively executing, no tasks awaiting execution, and no new tasks can be submitted. An unused `ExecutorService` should be shut down to allow reclamation of its resources.
 
---

## Atomic operations

- `AtomicInteger` - AtomicInteger  provides you with int value that is updated atomically,
- `AtomicLong` - AtomicInteger  provides you with long value that is updated atomically, and
- `AtomicBoolean` - AtomicInteger  provides you with boolean value that is updated atomically.


---

## Locks (ReentrantLock)

`ReentrantLock` is a concrete implementation of `Lock` interface provided in Java concurrency package. `ReentrantLock` is mutual exclusive lock, similar to implicit locking provided by `synchronized` keyword in Java, with extended feature like fairness, which can be used to provide lock to longest waiting thread. 
Lock is acquired by `lock()` method and held by Thread until a call to `unlock()` method.


### Difference between ReentrantLock and Synchronized in Java





