# Graph

## Representations of graphs

Two standard ways to represent a graph G = (V,E): as a collection of adjacency lists or as an adjacency matrix.

Because the adjacency-list representation
provides a compact way to represent **sparse** graphs—those for which `|E|` is much
less than `|V|^2` - it is usually the method of choice. We may prefer an adjacency-matrix representation, however, when the
graph is **dense** - `|E|` is close to `|V|^2` -or when we need to be able to tell quickly
if there is an edge connecting two given vertices.

The **adjacency-list representation** of a graph `G = (V,E)` consists of an array
Adj of `|V|` lists, one for each vertex in `V` . For each `u ϵ V` , the adjacency list
`Adj[u]` contains all the vertices `v` such that there is an edge `(u,v) ϵ E`. That is,
`Adj[u]` consists of all the vertices adjacent to `u` in `G`. (Alternatively, it may contain
pointers to these vertices.)

If `G` is a directed graph, the sum of the lengths of all the adjacency lists is `|E|`,
since an edge of the form `(u,v)` is represented by having `v` appear in `Adj[u]`. If `G` is
an undirected graph, the sum of the lengths of all the adjacency lists is `2|E|`, since
if `(u,v)` is an undirected edge, then `u` appears in `v`’s adjacency list and vice versa.
For both directed and undirected graphs, the adjacency-list representation has the
desirable property that the amount of memory it requires is **`Θ(V+E)`**.

A potential disadvantage of the adjacency-list representation is that it provides
no quicker way to determine whether a given edge `(u,v)` is present in the graph
than to search for `v` in the adjacency list `Adj[u]`. An adjacency-matrix representation
of the graph remedies this disadvantage, but at the cost of using asymptotically
more memory.

## Breadth-first search

