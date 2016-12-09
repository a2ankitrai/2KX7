# Stacks and Queues

Stacks and queues are dynamic sets in which the element removed from the set by the DELETE operation is prespecified. In a stack, the element deleted from the set is the one most recently inserted: the stack implements a **last-in, first-out**, or **LIFO**, policy. 

Similarly, in a queue, the element deleted is always the one that has been in the set for the longest time: the queue implements a **first-in, first-out**,or **FIFO**, policy.

## Applications of stack:

- Balancing of symbols

- Infix to Postfix /Prefix conversion

- Redo-undo features at many places like editors, photoshop.

- Forward and backward feature in web browsers
 
- Used in many algorithms like Tower of Hanoi, tree traversals, stock span problem, histogram problem.

- Other applications can be Backtracking, Knight tour problem, rat in a maze, N queen problem and sudoku solver

--- 

## Applications of Queue:

Queue is used when things don’t have to be processed immediately, but have to be processed in First-In First-Out order like Breadth First Search. This property of Queue makes it also useful in following kind of scenarios. 

- When a resource is shared among multiple consumers. Examples include CPU scheduling, Disk Scheduling.

- When data is transferred asynchronously (data not necessarily received at same rate as sent) between two processes. Examples include IO Buffers, pipes, file IO, etc.

---

## Double-ended queue (dequeue)	

A double-ended queue (dequeue or deque) is an abstract data type that generalizes a queue, that supports element insertion and removal at both ends.

### Applications of Deque:

Since Deque supports both stack and queue operations, it can be used as both. The Deque data structure supports clockwise and anticlockwise rotations in O(1) time which can be useful in certain applications.

Also, the problems where elements need to be removed and or added both ends can be efficiently solved using Deque.

Summary of Deque methods

||**First Element (Head)**||	**Last Element (Tail)**||
|:-:|:-------------------:|:--------------------:|
||*Throws exception*	|*Special value*	|*Throws exception*	|*Special value*|
|**Insert**		|addFirst(e)	|offerFirst(e)	|addLast(e)		|offerLast(e)|
|**Remove**		|removeFirst()	|pollFirst()	|removeLast()	|pollLast()|
|**Examine**	|getFirst()	|peekFirst()  	|getLast() 		|peekLast()|



In java the general-purpose implementations include `LinkedList` and `ArrayDeque` classes. The `ArrayDeque` class is the resizable array implementation of the Deque interface, whereas the `LinkedList` class is the list implementation.

Most ArrayDeque operations run in amortized constant time. Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), and the bulk operations, all of which run in linear time.

The iterators returned by this class's iterator method are fail-fast: If the deque is modified at any time after the iterator is created, in any way except through the iterator's own remove method, the iterator will generally throw a ConcurrentModificationException. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

### Difference between ArrayDeque and LinkedList implementation

- The LinkedList implementation is more flexible than the ArrayDeque implementation. LinkedList implements all optional list operations. null elements are allowed in the LinkedList implementation but not in the ArrayDeque implementation.

- In terms of efficiency, ArrayDeque is more efficient than the LinkedList for add and remove operation at both ends. The best operation in a LinkedList implementation is removing the current element during the iteration. LinkedList implementations are not ideal structures to iterate.

---

## My implementations

- ArrayList - ??
- LinkedList - ??

---


## Questions and Answers

### Show how to implement a queue using two stacks. Analyze the running time of the queue operations.

Let the two stacks be `A` and `B`.

`ENQUEUE` pushes elements on `B`. `DEQUEUE` pops elements from `A`. If `A` is empty, the contents of `B` are transfered to `A` by popping them out of `B` and pushing them to `A`. That way they appear in reverse order and are popped in the original.

A `DEQUEUE` operation can perform in Θ(n) time, but that will happen only when `A` is empty. If many `ENQUEUE`s and `DEQUEUE`s are performed, the total time will be linear to the number of elements, not to the largest length of the queue.

### Show how to implement a stack using two queues. Analyze the running time of the stack operations.

We have two queues and mark one of them as active. `PUSH` queues an element on the active queue. `POP` should dequeue all but one element of the active queue and queue them on the inactive. The roles of the queues are then reversed, and the final element left in the (now) inactive queue is returned.

The `PUSH` operation is Θ(1), but the `POP` operation is Θ(n) where n is the number of elements in the stack.

---

## Stack Problems

- stack with max operation. Design a stack that supports a max operation.All operations must be 0(1) time. You can use 0(n) additional space, beyond what is required for the elements themselves.

---

## Queue Problems
