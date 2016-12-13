# Searching

## Binary Search

## Implementation code

??


## Problems on binary search

??


---

# Sorting

## Insertion sort
insertion sort is an efficient algorithm for sorting a small number of elements. The algorithm sorts the input numbers in place: it rearranges the numbers within the array A, with at most a constant number of them stored outside the array at any time.
 
   [java code](./sorting/InsertionSort.java)
   
---

## Heapsort

Running time: `O(n * log n)`

The (binary) heap data structure is an array object that we can view as a nearly [complete binary tree](./../DS/Tree/tree_chap1.md). The tree is completely
filled on all levels except possibly the lowest, which is filled from the left up to a point. An array A that represents a heap is an object with two attributes:
A:length, which (as usual) gives the number of elements in the array, and A:heap-size, which represents how many elements in the heap are stored within
array A. That is, although A[1...A:length] may contain numbers, only the elements in A[1...A:heap-size], where 0 <= A:heap-size <= A:length, are valid elements of the heap.
	
**Heap features**
 - The minimum and maximum number of elements in a heap of height h are between 2^h and (2^(h+1) - 1) respectively.
 - With the array representation for storing an n-element heap, the leaves are the nodes indexed by [n/2]+1, [n/2]+2 ,...,n.
	
[heapsort java code](./sorting/HeapSort.java)	

---

## QuickSort

QuickSort works by partitioning the input array into 3 arrays. We choose the last element of the array as the pivot element and then we scan from the 0th element to the last but one element. While scanning if the element is smaller than the pivot it is being kept in the first array and if the element is larger than the pivot it is being kept in the second array. Finally the pivot element is replaced with the first element of the second array (i.e. array of the elements larger than the pivot element). The pivot is now at its correct position in the finally sorted array. 

We repeat this procedure both to left and right arrays of the pivot.

The Worst case running time is n^2 and the average case is O(n * log n).

[java code](./sorting/QuickSort.java)

To DO
----

- Randomized version of Quicksort? Picking a random element rather than the last.

- Quicksort variation for duplicate elements in input

---

## Counting Sort

Linear sorting algorithm that can sort in O(n) time. It has a condition that the input is in range of [0-K] where K is some integer.

