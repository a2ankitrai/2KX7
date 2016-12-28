# Searching

## Binary Search

## Implementation code

??


## Problems on binary search

??


---

# Sorting

A **stable sort** is one that's guaranteed not to reorder elements with identical keys.

## Insertion sort

- Insertion sort is an efficient algorithm for **sorting a small number of elements**. 

- The algorithm sorts the input numbers in place: it rearranges the numbers within the array A, with at most a constant number of them stored outside the array at any time.

```java
public void insertSort(int[] a) {
	int key;

	for (int i = 1; i < a.length; i++) {
		key = a[i];
		int j = i - 1;
		while (j >= 0 && a[j] < key) {
			a[j + 1] = a[j];
			j = j - 1;
		}
		a[j + 1] = key;
	}

}
```


Running time: **O(n<sup>2</sup>)**

 
[java code](./sorting/InsertionSort.java)
   
---
## MergeSort

When you need a stable, O(N log N) sort, this is about your only option. The only downsides to it are that it uses O(N) auxiliary space and has a slightly larger constant than a quick sort.

Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. The `merge()` function is used for merging two halves. 

```java

// initially p = 0; r = a.length -1;
public int[] mergeSort(int a[], int p , int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, (q + 1), r);
			merge(a, p, q, r);
		}
		return a;
	}
	
public void merge(int a[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q ;

		int[] auxLeft = new int[n1];
		int[]  auxRight = new int [n2];

		for (int i = 0; i < n1; i++) {
			auxLeft[i] = a[p + i];
		}

		for (int j = 0; j < n2; j++) {
			auxRight[j] = a[q + 1 + j];
		}

		/*int i = 0, j = 0;
		int k = p;

		while (i < n1 && j < n2) {
			if (auxLeft[i] <= auxRight[j]) {
				a[k] = auxLeft[i];
				i++;
			} else {
				a[k] = auxRight[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			a[k] = auxLeft[i];
			i++;
			k++;
		}

		while (j < n2) {
			a[k] = auxRight[j];
			j++;
			k++;
		}
		*/

		for (int k = p, i = 0, j = 0; k <= r; k++) {
			if (i < n1 && j < n2) {
				if (auxLeft[i] <= auxRight[j]) {
					a[k] = auxLeft[i];
					i++;
				} else {
					a[k] = auxRight[j];
					j++;
				}
			} else if (i < n1 && j >= n2) {
				a[k] = auxLeft[i];
				i++;
			} else if (i >= n1 && j < n2) {
				a[k] = auxRight[j];
				j++;
			}
		}

	}	
```

### Application of Merge Sort

- **Merge Sort is useful for sorting linked lists in O(N Log<sub>2</sub> N) time**. In case of linked lists the case is different mainly due to difference in memory allocation of arrays and linked lists. Unlike arrays, linked list nodes may not be adjacent in memory. Unlike array, in linked list, we can insert items in the middle in O(1) extra space and O(1) time. Therefore merge operation of merge sort can be implemented without extra space for linked lists.


---

## QuickSort

QuickSort works by partitioning the input array into 3 arrays. We choose the last element of the array as the pivot element and then we scan from the 0<sup>th</sup> element to the last but one element. While scanning if the element is smaller than the pivot it is being kept in the first array and if the element is larger than the pivot it is being kept in the second array. Finally the pivot element is replaced with the first element of the second array (i.e. array of the elements larger than the pivot element). The pivot is now at its correct position in the finally sorted array. 

We repeat this procedure both to left and right arrays of the pivot.

The Worst case running time is n<sup>2</sup> and the average case is O(n * log n).

```java
public void sort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			sort(a, p, q - 1);
			sort(a, q + 1, r);
		}
	}

public int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp2 = a[i + 1];
		a[i + 1] = a[r];
		a[r] = temp2;
		return i + 1;
	}
```

[java code](./sorting/QuickSort.java)

To DO
----

- Randomized version of Quicksort? Picking a random element rather than the last.

- Quicksort variation for duplicate elements in input


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

---

## Counting Sort

Linear sorting algorithm that can sort in O(n) time. It has a condition that the input is in range of [0-K] where K is some integer.

