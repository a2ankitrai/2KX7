# Dynamic Programming

Dynamic programming, like the divide-and-conquer method, solves problems by
combining the solutions to subproblems. (“Programming” in this context refers
to a tabular method, not to writing computer code.)

Dynamic programming applies when the subproblems overlap—that is, when subproblems share subsubproblems.

A dynamic-programming algorithm solves each
subsubproblem just once and then saves its answer in a table, thereby avoiding the
work of recomputing the answer every time it solves each subsubproblem.

When developing a dynamic-programming algorithm, we follow a sequence of
four steps:

1. Characterize the structure of an optimal solution.
2. Recursively define the value of an optimal solution.
3. Compute the value of an optimal solution, typically in a bottom-up fashion.
4. Construct an optimal solution from computed information.

---

Is the optimal solution to a given input depends on the optimal solution of its subproblems ? Yes... Bingo ! its DP :)