## Code problems

Tom Loves Travelling

DESCRIPTION

Tom likes travelling. He enjoys watching the long road while driving his car.
Tom wants to travel to some of the cities along the roads. A road can connect two cities or the same city (self-loop). There can be multiple roads between two cities. There are N cities and M roads in Tom’s country. He wants to travel through all the roads in his country exactly once as travelling through the same road may become boring. He can visit a city any number of times.

You are given the map of the country and you have to tell Tom whether it's possible for him to travel through all the roads exactly once. He may travel the roads in any order and he can start his journey from any city. Note that he has to return back to the city from which he started his journey.

Input 
The 1st line contains T, the number of test cases.
The 2nd line will contain two space separated integers N and M.
Then follows M lines with each line containing two space separated integers u and v denoting that there exists a road between city u and v.

Output
For each test case, print the “YES” if its possible and “NO” (without quotes) otherwise.

Constraints
1 <= T <= 50
1 <= N <= 105 
1 <= M <= 105  
1 <= u, v <= N

Sample test cases

Input
1
2 3
1 1
1 2
1 2

Output 
YES

Explanation
The path which he can follows is 1 ->(edge 1) -> 1 -> (edge 2) -> 2 -> (edge 3) -> 1. So he can return back to where he started and can travel all roads exactly once. There can be multiple valid paths he can use.

Input 
1
2 2
1 1
1 2

Output 
NO

Explanation
No matter whatever starting point he chooses, he cannot return back to his starting point after travelling through all the roads exactly once.

SAMPLE TESTCASES
Testcase #1
INPUT
1
2 2
1 1
1 2


OUTPUT
NO

---


Matrix Again
subject Codingcasino 50 points
DESCRIPTION
Given a N x M matrix with entry either 0 or 1. We are interested in calculating the area of a rectangle with all 1’s only. There are two type of operations define as, 
Type 1: In this, you are allowed to swap any pair of columns any number of times.
Type 2: In this, you are allowed to swap any pair of rows, any number of times. 

You have to answer Q query, of type “A operation_type”, i.e. can we find the area of a rectangle equal to “A” using operation type “operation_type”?
See example for clarification.

Input 
The 1st line will contain N and M, the number of rows and columns respectively.
Following N line will contain M entries denoting matrix[i][j].
The N+2th line contains Q, the number of queries.
Next, Q line contains “A operation_type”, A denote required area and operation_type denote the type of operation allow.

Note: 
Each query’s operation is independent of other query’s operation i.e the matrix will remain same after each query, swap operation does not change the matrix permanently.

Output 
For each query output 1 if it is possible to find the required area of a rectangle using operation_type else output 0 on a new line.

Constraints
1 <= N, M <= 103  
matrix[i][j] is either 0 or 1
1<= Q <=106  
1<= A <=106  
operation_type is either 1 or 2

Sample Test Cases

Input
4 4
1 0 1 0
0 1 1 1
1 0 0 1
1 0 1 1
4
4 1
3 1
4 2
5 2

Output
1
1
1
0

Explanation ﻿

fig.png 10.93 KB
﻿In the first query, we have to find a rectangle of area 4 such that it’s all entry is 1. Using operation type 1, we can achieve this by swapping column number 2 with column number 4. So, the output is 1.
In the second query, we can get area equal to 3 without swapping any column. So, the output 1.
In the third query, we have to find a rectangle of area 4 such that it’s all entry is 1. Using operation type 2, we can achieve this by swapping row number 3 with row number 4. So, the output is 1.
In the fourth query, we can not find any rectangle of area 5. So the output is 0.
SAMPLE TESTCASES
Testcase #1
INPUT
OUTPUT
4 4
1 0 1 0
0 1 1 1
1 0 0 1
1 0 1 1
4
4 1
3 1
4 2
5 2