# Backtracking

Backtracking a problem solving approach which is closest to the brute force method. Only difference between brute force algorithm and backtracking algorithm is that backtracking discards partial solution as soon as possible without following them till end.

Tree diagrams can be used to design backtracking algorithms.

## Recursion

**Structure of a Recursive Method**

```
recursiveMethod(parameters) {
	if (stopping condition) {
		// handle the base case
	} else {
		// recursive case:
		// possibly do something here
		recursiveMethod(modified parameters);
		// possibly do something here
	}
}
```

- There can be multiple base cases and recursive cases.
- When we make the recursive call, we typically use parameters that bring us closer to a base case.

---

**Thinking Recursively**

- When solving a problem using recursion, ask yourself these
questions:
	1. How can I break this problem down into one or more
	smaller subproblems?
		- make recursive method calls to solve the subproblems
	2. What are the base cases?
		- i.e., which subproblems are small enough to solve directly?
	3. Do I need to combine the solutions to the subproblems?
		- If so, how should I do so?
		
---

**Processing a String Recursively**

- A string is a recursive data structure. It is either:
	- empty ("")
	- a single character, followed by a string
- Thus, we can easily use recursion to process a string.
	- process one or two of the characters
	- make a recursive call to process the rest of the string
- Example: print a string vertically, one character per line:

```java
public static void printVertical(String str) {
	if (str == null || str.equals("")) {
		return;
	}
	System.out.println(str.charAt(0)); // first char
	printVertical(str.substring(1)); // rest of string
}		
```		
		
---

## Recursive Backtracking: the n-Queens Problem		
	
- Consider one row at a time. Within the row, consider one column at a time, looking for a “safe” column to place a queen.	

**Queen Attacks**

- Same row (row num same as queen's position)
- Same column (column num same as queen's position)		
- on left diagonal
	- calculate left diagonal value as `row - column` 
	- all position for which this value is same as the current queen's `row - column` value, they can be attacked.
- on right diagonal
	- calculate right diagonal value as `row + column` 
	- all position for which this value is same as the current queen's `row + column` value, they can be attacked.		
	
---
	
- The N-Queen problem is solved column wise.
- Start with 0<sup>th</sup> column and iterate from 0 to N rows checking for safe position
- If safe position found, place the queen and check with the next column recursively.
- If above recursion reach `column = N` the problem is solved.
- if safe position for further queens could not be found then remove the currently placed queen and continue with next iteration.
- if iteration has reached it's end and still the inner recursive funtion returned true then no solution exists.	
	
[code](./backtracking/NQueensProblem.java)
		