# Stacks and Queues

Stacks and queues are dynamic sets in which the element removed from the set
by the DELETE operation is prespecified. In a stack, the element deleted from
the set is the one most recently inserted: the stack implements a last-in, first-out,
or LIFO, policy. Similarly, in a queue, the element deleted is always the one that
has been in the set for the longest time: the queue implements a first-in, first-out,
or FIFO, policy.

## Applications of stack:

- Balancing of symbols

- Infix to Postfix /Prefix conversion

- Redo-undo features at many places like editors, photoshop.

- Forward and backward feature in web browsers
 
- Used in many algorithms like Tower of Hanoi, tree traversals, stock span problem, histogram problem.

- Other applications can be Backtracking, Knight tour problem, rat in a maze, N queen problem and sudoku solver

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

## Problems

- stack with max operation. Design a stack that supports a max operation.All operations must be 0(1) time. You can use 0(n) additional space, beyond what is required for the elements themselves.

