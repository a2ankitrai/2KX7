
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

the height of a node in a heap to be the number of edges on the longest simple downward path from the node to a leaf, and we define the height of the heap to be the height of its root. Since a heap of n elements is based on a complete binary tree, its height is \theta (lg n)