# Linked List

A linked list is a data structure in which the objects are arranged in a linear order. Unlike an array, however, in which the linear order is determined by the array indices, the order in a linked list is determined by a pointer in each object.

[Singly Linked List](./LL/LinkedList.java)

[Doubly Linked List](./LL/DoublyLinkedList.java)

## Advantages over arrays:
- Dynamic size
- Ease of insertion/deletion

## Drawbacks:
- Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot do binary search with linked lists.
- Extra memory space for a pointer is required with each element of the list.
- Arrays have better cache locality that can make a pretty big difference in performance.

---

## Arbit

- Use case of circular linked list
	
	- In a timesharing environment, the operating system must maintain a list of present users and must alternately allow each user to use a small slice of CPU time, one user at a time. The operating system will pick a user, let him/her use a small amount of CPU time and then move on to the next user, etc.
		
	- Keeping track of whose turn it is in a multi-player board game. Put all the players in a circular linked list. After a player takes his turn, advance to the next player in the list. This will cause the program to cycle indefinitely among the players.	
 	

---

## Java Linked List

```java
public class LinkedList<E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, Serializable
```

Doubly-linked list implementation. Implements all optional list operations, and permits all elements (including null).

**Note that this implementation is not synchronized.** To make it thread safe the list should be "wrapped" using the `Collections.synchronizedList` method.

```java
List list = Collections.synchronizedList(new LinkedList(...));
```

The iterators returned by this class's iterator and listIterator methods are fail-fast: if the list is structurally modified at any time after the iterator is created, in any way except through the Iterator's own remove or add methods, the iterator will throw a `ConcurrentModificationException`. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

---

- Insertion and Deletion speed comparision in Singly Linked List Vs Doubly Linked List ?

## Problems on Linked List

G4G LL question 17 to start

- Merge two Sorted lists without any additional storage.
	[solution](../Problems/LinkedList/MergeSortedLists.java)
	
- Checking for cyclicity in a Linked List.
	[solution](../Problems/LinkedList/CheckingCycle.java)
	Actually, the pointers need not move one and two nodes at a time;it is only necessary that the pointers move at different rates.

- Swap nodes in a linked list without swapping data. [solution](./LL/SwapNodes.java)	

- Reverse a singly Linked List
	
	```java
	public void reverseLL() {
		Node currentNode = head, prevLink = null, nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevLink;
			prevLink = currentNode;
			currentNode = nextNode;
		}
		head = prevLink;
	}
	```
	
	
- Check for median of a circular linked list.	
	
- Check for starting node of overlapping lists	

