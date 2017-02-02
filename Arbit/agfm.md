# AGFM

- What would an API look like for the interactions between a plane and air traffic control.

- Design a single machine, single user system for hotel table reservations.
	- Constraints: assume 16 tables with capacity 4, 16 tables with capacity 8. Can book for just 1 hr. Max 2 months in advance.
	- Which classes, which data-stuctures?
	- What happens when a party of 16 requests for a table. You can join tables which are next to each other. Implement this.

---	
	
- Design a deck of cards.
	- Now assume 10 million users are using this card deck.	

approach: 
Deck class. Card class. Suit enum. Value Enum. Card contains Value and Suit enums. Deck contains an array of 52 cards. Constructor of Deck initializes 52 card class.

Card should expose comparable interface.

Deck should expose Shuffle and iterator interface.

Some considerations: Should Deck be singleton? Should Deck be made generic to accept different types of cards? Should Desk be made threadsafe?		
	
---
	
- Given a binary tree, print all the leaf nodes.
	- Now, print all the left most nodes, and all right most nodes ( assume there is a triangle around the binary tree, so all nodes which falls on that triangle , print them in clockwise ordering).	
	
- Given an array which contains series of 0s and series of 1s, find the index where 1s start.
	- How would you test this method?
	- Assume input array has infinite length, how will you find the index in O(logn) time?	
	
- Design (and draw an infrastructure diagram for) a system in which speed detection cameras upload snapshots for each vehicle (with a license plate ID, timestamp, and location included) and the system is queried to return all the speeders for a given location and date range. No implementation required.  	

- Sort a set of linked nodes
- Determine if a string has balanced brackets.
- Write code for a simple implementation of a hash map.  

- Given a graph of social network like facebook, write a program to determine how many Ads needs to be pushed to reach entire network. 

- Given an unsorted array, find kth minimum element. They need best solution. Sorting array is nlogn complexity . They dont agree for it.  

- Find maximum subregion of 1's in Binary number Matrix  

- Advantages of singly linked lists over doubly linked list

- how to find the sum from root to leaf of a binary tree

- how to find the median of a stream of millions of numbers

---

## Set 2

- Find sum of all numbers that are formed from root to leaf path (code) expected time complexity O(n)
- Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. For example : ABC -> A BC, AB C, ABC, A B C
- Preorder traversal without using recursion.

- There is a 12 km road and a contractor who is in-charge of repairing it. Contractor updates you about the work which is done in patches. Like “Road between 3.2 km to 7.9 km repaired ”, “Road between 1.21 km to 3.2 km repaired”. You have a manager who enquires about the longest continuous patch so far. It was a long discussion and I gave solution in O(nlogn) where n is the number of updates by the contractor.

- Find median of an unsorted array. (code)
- A stream of characters is coming, at any moment you have to tell ‘k’ elements closest to a given number (code)
- Design data structure that supports insert(), remove(), find-max(), delete-max() operations. All operations should run in O(1) time.
- Check whether given link list represents palindrome.

---

# Set 3

- Find the diameter of a tree
- Print all anagrams pair in separate line

- Find the next larger element in a BST, given key might not be in the BST. O(logn) time and O(1) space.
- Delete all nodes on a DLL whose data is a multiple of 5. O(n) time
- Given n-ary tree, print the nodes in level-order zig-zag manner. O(n) time
- Given a BST find the number of pair of nodes which sum upto a given value. O(n) time, O(1) space.
- Given a 2D plane and n points, find the line which passes through maximum number of lines.
- If a/b is recurring like 10/3 print 10/3 as 3.(3), 16/6 as 2.(6).

**Round 2**

1. Explain caching, implement LRU caching.
2. Explain working of DNS, implement domain search in DNS.
3. What is hashing. Implement domain search using hashing.
4. Given a string of alphabet of at most 5 characters. Write a function which returns a unique number for each string with O(1) space.


1. Clone a linked list having an arbit pointer.
2. You are given deque(), enque(), isEmpty() function for queue, implement push(), pop(), min() functions of stack. O(1) time was required for min().
3. Convert a binary tree to a DLL such that a next node for DLL is selected in a top down order in zig-zag manner. O(n) space was allowed, but not O(2n).



## HR

- Describe a project in your career in which you have made substantial impact to your company

