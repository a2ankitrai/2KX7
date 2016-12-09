# Heap
---

A Binary Heap is a Binary Tree with following properties.

1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to Min Heap.

**Why array based representation for Binary Heap?**

Since a Binary Heap is a Complete Binary Tree, it can be easily represented as array and array based representation is space efficient. If the parent node is stored at index `I`, the left child can be calculated by `2 * I + 1` and right child by `2 * I + 2` (assuming the indexing starts at 0).

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

## Priority Queue

??

### Applications of Priority Queue:

- CPU Scheduling
- Graph algorithms like **Dijkstra’s shortest path algorithm**, **Prim’s Minimum Spanning Tree**, etc

---

## Fibonacci Heap

??

---
# Java APIs

java.util.PriorityQueue<E> extends AbstractQueue<E> :  minHeap