
# Stacks and Queues

Stacks and queues are dynamic sets in which the element removed from the set
by the DELETE operation is prespecified. In a stack, the element deleted from
the set is the one most recently inserted: the stack implements a last-in, first-out,
or LIFO, policy. Similarly, in a queue, the element deleted is always the one that
has been in the set for the longest time: the queue implements a first-in, first-out,
or FIFO, policy.


## Questions and Answers

> Show how to implement a queue using two stacks. Analyze the running time of the queue operations.

Let the two stacks be `A` and `B`.

`ENQUEUE` pushes elements on `B`. `DEQUEUE` pops elements from `A`. If `A` is empty, the contents of `B` are transfered to `A` by popping them out of `B` and pushing them to `A`. That way they appear in reverse order and are popped in the original.

A `DEQUEUE` operation can perform in Θ(n) time, but that will happen only when `A` is empty. If many `ENQUEUE`s and `DEQUEUE`s are performed, the total time will be linear to the number of elements, not to the largest length of the queue.