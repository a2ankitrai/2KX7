
if you are required to find a path of any sort, it is usually a graph problem.

what components a graph consists of. In fact there are only two, nodes and edges. A node (or vertex) is a discrete position in the graph. An edge (or connection) is a link between two vertices that can be either directed or undirected and may have a cost associated with it. An undirected edge means that there is no restriction on the direction you can travel along the edge.

An easy way to think about edges and vertices is that edges are a function of two vertices that returns a cost.

the mathematical description of graphs, a graph G = {V, E} is defined as a set of vertices, V, and a collection of edges (which is not necessarily a set), E. An edge can then be defined as (u, v) where u and v are elements of V.

Order – The number of vertices in a graph
Size – The number of edges in a graph

An example of one of the simplest types of graphs is a singly linked list! 

***Cost Function:***

```
cost(X, Y) := if (X.link = Y) return 1;
           else if (X = Y) return 0;
           else "Not possible"
```
This cost function represents the fact that we can only move directly to the link node from our current node. 

A more formal definition of a tree is that it is a connected acyclic graph. This simply means that there are no cycles in the graph and every node is connected to at least one other node in the graph.

## Basic methods for searching graphs

There are two methods for searching graphs that are extremely prevalent, the Depth First Search and the Breadth First Search.

The depth first search is well geared towards problems where we want to find any solution to the problem (not necessarily the shortest path), or to visit all of the nodes in the graph.

A classic application of the depth first search; the flood-fill. The flood-fill operation will be familiar to anyone who has used a graphic painting application. The concept is to fill a bounded region with a single color, without leaking outside the boundaries.

