# Analysis of Algorithms

## Analysis of Loops

- **O(1)**: Time complexity of a function (or set of statements) is considered as O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function.

- **O(n)**: Time Complexity of a loop is considered as O(n) if the loop variables is incremented / decremented by a constant amount.

- **O(n<sup>c</sup>)**: Time complexity of nested loops is equal to the number of times the innermost statement is executed. following sample loops have O(n2) time complexity.

	```java
	for (int i = 1; i <=n; i += c) {
	   for (int j = 1; j <=n; j += c) {
		  // some O(1) expressions
	   }
	}
	```
	
- **O(Logn)**: Time Complexity of a loop is considered as O(Logn) if the loop variables is divided / multiplied by a constant amount.	
	
	```java
	for (int i = 1; i <=n; i *= c) {
       // some O(1) expressions
	}
	
	for (int i = n; i > 0; i /= c) {
       // some O(1) expressions
	}
	```
	
- **O(LogLogn)**: Time Complexity of a loop is considered as O(LogLogn) if the loop variables is reduced / increased exponentially by a constant amount.	

	```java
		// Here c is a constant greater than 1   
	   for (int i = 2; i <=n; i = pow(i, c)) { 
		   // some O(1) expressions
		}
		
	   //Here fun is sqrt or cuberoot or any other constant root
	   for (int i = n; i > 0; i = fun(i)) { 
		   // some O(1) expressions
		}
	```
	
---

	
	