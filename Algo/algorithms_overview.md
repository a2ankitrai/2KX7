# Algorithm Design Canvas

The Algorithm Design Canvas captures our process for tackling algorithm design problems.It's the most convenient way to represent algorithmic thinking. Every algorithmic problem, big or small, easy or hard, should eventually end up as a completed canvas.

The Canvas contains 5 major areas: Constraints, Ideas, Complexities, Code, and Tests. 

## Constraints

The Constraints area is where you fill in all constraints of the problem. This includes things like how large the input array can be, can the input string contain unicode characters, is the robot allowed to make diagonal moves in the maze, can the graph have negative edges, etc.

Your very first task when analyzing an algorithm design problem is to uncover all its constraints and write them down.

[Common Constraints Handout](./Common_Constraints_Handout.md)

## Ideas

After identifying all constraints, go into idea generation. Typically during an interview discuss 1 to 3 ideas. Often times start with one, explain it to the interviewer, and then move on to a better idea.

Your next goal is to fill in a succinct description of your idea: short and sweet so that any interviewer is able to understand it.

## Complexities

Each idea has two corresponding Complexity areas: Time and Memory. For every algorithm you describe, you will need to be able to estimate its time and memory complexity.

If there are two different algorithms for the same problems and one of them is faster for small inputs but other is faster for the large inputs we can design an algorithm such that: Check the number of records. If it is small enough, run algorithm 1, otherwise run algorithm 2.Similar ideas are often used in praxis. As an example consider most of the sort() functions provided by various libraries. Often this function is an implementation of QuickSort with various improvements, such as:

- if the number of elements is too small, run InsertSort instead (as InsertSort is faster for small inputs)
- if the pivot choices lead to poor results, fall back to MergeSort

## Code

Never, ever jump straight into coding before having thought about and discussed constraints, ideas and complexities with your interviewer.
After you've identified the problem's constraints, discussed a few ideas, analyzed their complexities, and found one that both you and your interviewer think is worth being implemented, you finally go into writing code.

## Tests

Finally, you move on to writing test cases and testing your code. Many people completely ignore this step. This is not smart at all.
what makes for a good test case. If you were to compile an extensive set of tests for your solution, what should these be? Here is a good list to get you started.

- **Edge cases**: Remember that "Constraints" section that we filled in? It's going to come in very handy. Design cases that make sure the code works when the min and/or max values of the constraints are hit. This includes negative numbers, empty arrays, empty strings, etc.

- Cases where there's **no solution**: To make sure the code does the right thing (hopefully you know what it is)

- **Non-trivial functional tests**: these depend very much on the problem. They would test the internal logic of the solution to make sure the algorithm works correctly.

- **Randomized tests**: this makes sure your code works well in the "average" case, as opposed to only working well on human-generated tests (where there's inherent bias).

- **Load testing**: Test your code with as much data as allowed by the constraints. These test your code against being very slow or taking up too much memory.

Typically, we stay away from randomized tests and load tests during interviews, for obvious reasons. Instead, we like choosing a small-scale version of a non-trivial functional test, to make sure the code does the right thing. Then, we look at how the code would react to several edge cases, and finally think about whether the code would work well if no solution can be found.

This combination (non-trivial functional + edge + no solution) tends to be the most effective. For the amount of time it takes to design the tests and to run them on your code on a sheet of paper, it gives you the highest certainty in your code.