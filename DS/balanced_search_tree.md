# Balanced Search Tree
---

A search-tree data structure for which a height of O(lg n) is guaranteed when implementing a dynamic set of n items. 

## 2-3 Trees

---

## Red-Black Trees

Red-black trees are an evolution of binary search trees that aim to keep the tree balanced without affecting the complexity of the primitive operations. This is done by coloring each node in the tree with either red or black and preserving a set of properties that guarantee that the deepest path in the tree is not longer than twice the shortest one.

A red-black tree is a binary search tree which has the following red-black properties:

- Every node is either red or black.

- (**root property**) The root of the red-black tree is black.

- (**red property**) The children of a red node are black. 
	( implies that on any path from the root to a leaf, red nodes must not be adjacent. However, any number of black nodes may appear in a sequence.)

- (**black property**) For each node with at least one null child, the number of black nodes on the path from the root to the null child is the same.

- Every leaf (NULL) is black.


### Insertion

1. If empty tree
	```java
	if (root == null){
		n.color = BLACK;
		root = n;
	}	
	```
	
2. Node and parent are both red. Uncle of node is red - push blackness down from grandparent. (Or make the grandparent red.).   If the grandparent is root make it black again.

3. Node and parent are both red. Node is left child, parent is left. Can fix extra redness with a single rotation (right).

4. Node and parent are both red. Node is right child, parent is right child. Can fix extra redness with a single rotation (left). Pass the redness to parent new left child and make parent black.

5. Node and parent are both red. Node is left child, parent is right child. - rotate. (Single rotate right). This will give rise to case 4.

	 
[Animation](https://www.cs.usfca.edu/~galles/visualization/RedBlack.html)


---

## B-Trees

![B-Trees](./_image/B-Trees.png)

---

## AVL Tree

AVL tree is a self-balancing Binary Search Tree (BST) where the difference between heights of left and right subtrees cannot be more than one for all nodes.



---