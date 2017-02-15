# Array

Array elements are being stored in contiguous locations in memory.

- Accessing random elements is an array is possible.

- Array do not require additional memory space for storing pointers/references for the next elements.	Therefore, Arrays are space efficient.

- Arrays have better cache locality that can make a pretty big difference in performance.

**If the size is known in advance array should be preferred over ArrayList or Linkedlist.**

## Problems

- Given an array A[] and a number x, check for pair in A[] with sum as x. 
	[solution](./Array/Problems/PairSum.java)
	
- Find the Number Occurring Odd Number of Times. Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times	[solution](./Array/Problems/OddOccurance.java)

- String handling problems: Reverse string, reverse every word in a string.

- Given an array, find the index of first occurrence of a number ‘x’. First, I gave O(n) solution, after that he asked to optimize it and find it in less than O(n).
