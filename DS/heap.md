# Heap
---

A Binary Heap is a Binary Tree with following properties.

1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to Min Heap.

**Why array based representation for Binary Heap?**

Since a Binary Heap is a Complete Binary Tree, it can be easily represented as array and array based representation is space efficient. If the parent node is stored at index `I`, the left child can be calculated by `2 * I + 1` and right child by `2 * I + 2` (assuming the indexing starts at 0).

## Heap-ordered binary tree
- Key in nodes
- Parent's key no smaller than children's key

## Array representation

- Indices start at 1
- Take nodes in level order
- No explicit links needed!

## Binary Heap properties

- Largest key is a[1], which is the root of the binary tree
- Can use array indices to move through tree
	- Parent of node at `k` is at `k/2`
	- Children of node at `k` are at `2k` and `2k+1`
	
---

## Heap operations complexities

- **Get Top Priority Element (Get minimum or maximum)** - O(1)

- **Insert an element** - O(Logn)

- **Remove top priority element** - O(Logn)

- **Decrease Key** - O(Logn)

---

## Binary heap considerations

### Immutability of keys
- Assumption: client does not change the keys while they're on the PQ
- Best practice: use immuatable keys


---

## Priority Queue

Data structure implementation for min heap or max heap. Can be used when input n is very large and only k top elements needs to be processed.


### Priority Queue client example

Find the largest M items in a stream of N items


### Applications of Priority Queue:

- Event-driven simulation [Customers in a line, colliding particles ]
- Numerical computation [reducing round-off error]
- Data compression [Huffman codes]
- CPU Scheduling
- Graph algorithms [**Dijkstra’s shortest path algorithm**, **Prim’s Minimum Spanning Tree**]
- Statistics [maintain largest M values in a sequence]
- Operating Systems [load balancing, interrupt handling]
- Spam filtering [Bayesian spam filter]

---


## Applications of Heaps:

- Heap Sort: Heap Sort uses Binary Heap to sort an array in O(nLogn) time.

- Priority Queue: Priority queues can be efficiently implemented using Binary Heap because it supports insert(), delete() and extractmax(), decreaseKey() 	operations in O(logn) time. Binomoial Heap and Fibonacci Heap are variations of Binary Heap. These variations perform union also efficiently.

- Graph Algorithms: The priority queues are especially used in Graph Algorithms like Dijkstra’s Shortest Path and Prim’s Minimum Spanning Tree.

- Many problems can be efficiently solved using Heaps. See following for example.

- K’th Largest Element in an array.

- Sort an almost sorted array

- Merge K Sorted Arrays.

---

**why is Binary Heap Preferred over BST for Priority Queue?**

- Since Binary Heap is implemented using arrays, there is always better locality of reference and operations are more cache friendly.

- Although operations are of same time complexity, constants in Binary Search Tree are higher.

- We can build a Binary Heap in O(n) time. Self Balancing BSTs require O(nLogn) time to construct.

- Binary Heap doesn’t require extra space for pointers.

- Binary Heap is easier to implement.

- There are variations of Binary Heap like Fibonacci Heap that can support insert and decrease-key in Θ(1) time

---

# Procedure for Heap Sort

- Build a max heap of the input array elements.

```java
public void buildMaxHeap(int[] a) {
		heapsize = a.length;
		for (int i = (a.length / 2) - 1; i >= 0; i--) {
			maxHeapify(a, i);
		}
	}
```

- After the max heap is built, Keep extract the root element (max element) and replacing it with the last element. Decrease the heap size by 1 and again call the maxHeapify procedure. Keep Repeating this process for the size of the input array. The resultant array will be sorted.

 

---

## Time Complexity of building a heap

Consider the following algorithm for building a Heap of an input array A.
```
BUILD-HEAP(A) 
    heapsize := size(A); 
    for i := floor(heapsize/2) downto 1 
        do HEAPIFY(A, i); 
    end for 
END
```
What is the worst case time complexity of the above algo?

Although the worst case complexity looks like O(nLogn), upper bound of time complexity is O(n).


--- 


## Fibonacci Heap

??

---
# Java APIs

java.util.PriorityQueue<E> extends AbstractQueue<E> :  minHeap