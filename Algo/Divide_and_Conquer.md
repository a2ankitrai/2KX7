# Divide and Conquer


In divide-and-conquer, we solve a problem recursively, applying three steps at each level of the recursion:

**Divide** the problem into a number of subproblems that are smaller instances of the same problem.

**Conquer** the subproblems by solving them recursively. If the subproblem sizes are small enough, however, just solve the subproblems in a straightforward manner.

**Combine** the solutions to the subproblems into the solution for the original problem.

Recurrences go hand in hand with the divide-and-conquer paradigm, because they give us a natural way to characterize the running times of divide-and-conquer algorithms. A recurrence is an equation or inequality that describes a function in terms of its value on smaller inputs.

---

## The maximum-subarray problem


  Find a maximum subarray within an array of integers.
	
  The maximum-subarray problem is interesting only when the array contains some negative numbers. If all the array entries were nonnegative, then the maximum-subarray problem would present no challenge, since the entire array would give the greatest sum.
	
  **Code**
  
  
  [Maximum Sub Array](./DivideAndConquer/MaximumSubArray.java)