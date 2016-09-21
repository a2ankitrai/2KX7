
# The Common Constraints Handout

## Strings, Arrays and Numbers

- How many elements can be in the array?

- How large can each element be? If it’s a string, how long? If it’s a number, what is
the minimum and maximum value?

- What is in each element? If it’s a number, is it an integer or a floating point? If it’s
a string, is it single-byte or multibyte (unicode)?

- If the problem involves finding a subsequence, does “subsequence” mean that the
elements must be adjacent, or is there no such requirement?

- Does the array contain unique numbers or can they be repeated (this is sometimes
relevant)?

## Grids/Mazes

- For problems where some actor (e.g. a robot) is moving in a grid or maze, what
moves are allowed? Can the robot move diagonally (hence 8 valid moves), or only
horizontally/vertically (hence only 4 valid moves)?

- Are all cells in the grid allowed, or can there be obstacles?

- If the actor is trying to get from cell A to cell B, are cells A and B guaranteed to be
different from each other?

- If the actor is trying to get from cell A to cell B, is it guaranteed that there’s a path
between the two cells?

## Graphs

- How many nodes can the graph have?

- How many edges can the graph have?

- If the edges have weights, what is the range for the weights?

- Can there be loops in the graph? Can there be negative-sum loops in the graph?

- Is the graph directed or undirected?

- Does the graph have multiple edges and/or self-loops?

## Return Values

- What should my method return? For example, if I’m trying to find the longest
subsequence of increasing numbers in an array, should I return the length, the
start index, or both?

- If there are multiple solutions to the problem, which one should be returned?

- If it should return multiple values, do you have any preference on what to return?
E.g. should it return an object, a tuple, an array, or pass the output parameters as
input references?

- What should I do/return if the input is invalid / does not match the constraints?
Options may be to do nothing (always assume the input is correct), raise an
exception, or return some specific value.

- In problems where you’re supposed to find something (e.g. a number in an array),
what should be returned if the element is not present?