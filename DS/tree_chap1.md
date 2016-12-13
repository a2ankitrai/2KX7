 
# Trees 
Unlike Array and Linked List, which are linear data structures, tree is hierarchical (or non-linear) data structure.  

Saying that the structure of a tree is hierarchical means that things are ordered above or below other things. For example, the army is hierarchical, with generals above colonels, and colonels above lieutenants, etc.
  
- If we organize keys in form of a tree (with some ordering e.g., BST), we can search for a given key in moderate time (quicker than Linked List and slower than arrays). **Self-balancing search trees like AVL and Red-Black trees guarantee an upper bound of O(Logn) for search.**

- We can insert/delete keys in moderate time (quicker than Arrays and slower than Unordered Linked Lists). **Self-balancing search trees like AVL and Red-Black trees guarantee an upper bound of O(Logn) for insertion/deletion.**


## Binary Tree
In Binary Tree each node has zero child, one child or two children.

***Strict Binary Tree***:
If each node has exactly two children or no children.

___Full Binary Tree___: 
If each node has exactly two children and all leaf nodes are at same level.	

***Complete Binary Tree***: A Binary Tree is complete Binary Tree if all levels are completely filled except possibly the last level and the last level has all keys as left as possible.
If all leaf nodes are at height `h` or `h-1` and also without any missing number of sequence. 

```
               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40
	  
               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40
     /  \   /
    8   7  9 	  
	  
```
	
The depth of a node n is the number of nodes on the search path from the root to n,
not including n itself. The height of a binary tree is the maximum depth of any node
in that tree.	
	
	
## Binary tree implementation
```java
public class BinaryTree {

	public BTNode root;

	static class BTNode {
		public int data;
		public BTNode left;
		public BTNode right;

		public BTNode(int data) {
			this.data = data;
			left =  null;
			right = null;
		}
	}

	public BinaryTree(BTNode root) {
		this.root = root;
	}
}	
```	

## Why Trees?

- Trees (with some ordering e.g., BST) provide moderate access/search (quicker than Linked List and slower than arrays).
- Trees provide moderate insertion/deletion (quicker than Arrays and slower than Unordered Linked Lists).

## Tree applications

- Manipulate hierarchical data.
- Router algorithms.

## Tree Properties

- The maximum number of nodes at level ‘l’ of a binary tree is 2^(l-1). (Assuming root is at level 1)

- Maximum number of nodes in a binary tree of height ‘h’ is 2h – 1.

- In a Binary Tree with N nodes, minimum possible height or minimum number of levels is  Log(N+1)

- A Binary Tree with L leaves has at least   LogL + 1   levels 

---

# Diameter of a Binary Tree

The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. The diameter of a tree T is the largest of the following quantities:

- the diameter of T’s left subtree
- the diameter of T’s right subtree
- the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)

---

# Threaded Binary Tree

The idea of threaded binary trees is to make inorder traversal faster and do it without stack and without recursion. A binary tree is made threaded by making all right child pointers that would normally be NULL point to the inorder successor of the node (if it exists).

There are two types of threaded binary trees.

**Single Threaded:** Where a NULL right pointers is made to point to the inorder successor (if successor exists).

**Double Threaded:** Where both left and right NULL pointers are made to point to inorder predecessor and inorder successor respectively. The predecessor threads are useful for reverse inorder traversal and postorder traversal.

![threadedBT.png](./_image/threadedBT.png)

---

# Problems

- [Write a Program to Find the Maximum Depth or Height of a Tree](http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/)

- If you are given two traversal sequences, can you construct the binary tree?
	
	It depends on what traversals are given. If one of the traversal methods is Inorder then the tree can be constructed, otherwise not.
	
	
	