# Balanced Search Tree
---

A search-tree data structure for which a height of O(lg n) is guaranteed when implementing a dynamic set of n items. 

## 2-3 Trees

---

## Red-Black Trees

A red-black tree is a binary search tree which has the following red-black properties:

- Every node is either red or black.

- (**root property**) The root of the red-black tree is black.

- (**red property**) The children of a red node are black. ( implies that on any path from the root to a leaf, red nodes must not be adjacent. 
However, any number of black nodes may appear in a sequence.)

- (**black property**) For each node with at least one null child, the number of black nodes on the path from the root to the null child is the same.


- Every leaf (NULL) is black.


[Animation](https://www.cs.usfca.edu/~galles/visualization/RedBlack.html)


---

## B-Trees

![B-Trees](./_image/B-Trees.png)

---

## AVL Tree