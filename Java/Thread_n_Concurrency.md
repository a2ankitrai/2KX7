# Threads and Concurrency
---

## Thread Implementation

By extending the Thread class or implmenting the Runnable interface. In both cases need to implement the run() method

## Sleep, Yield and Join

---

## Synchronized

---

## Waiting and Notifying


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

## Deadlocks
