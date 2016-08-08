 
#Trees 
Unlike Array and Linked List, which are linear data structures, tree is hierarchical (or non-linear) data structure.  

Saying that the structure of a tree is hierarchical means that things are ordered above or below other things. For example, the army is hierarchical, with generals above colonels, and colonels above lieutenants, etc.
  
- If we organize keys in form of a tree (with some ordering e.g., BST), we can search for a given key in moderate time (quicker than Linked List and slower than arrays). **Self-balancing search trees like AVL and Red-Black trees guarantee an upper bound of O(Logn) for search.**

- We can insert/delete keys in moderate time (quicker than Arrays and slower than Unordered Linked Lists). **Self-balancing search trees like AVL and Red-Black trees guarantee an upper bound of O(Logn) for insertion/deletion.**


### Binary Tree
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

## Binary tree traversals
**Preorder**: Each node is preocessed before (pre) either of its sub-trees.  
_Recursive approach_
```java
public void preOrderTraversalRecursive(BTNode root) {
		if (root != null) {
			System.out.print(root.data + " --> ");
			preOrderTraversalRecursive(root.left);
			preOrderTraversalRecursive(root.right);
		}
	}
```

_Iterative approach_  
This code works but it is heavily under optimal. This was your 1st attempt.
```java
public void preOrderTraversal() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}
		String treeElements = "";
		BTNode temp = root;

		Stack<BTNode> s = new Stack<BTNode>();

		while (temp != null || !s.empty()) {

			if (temp == null) {
				temp = s.pop();
			}
			System.out.println(treeElements);
			treeElements += temp.data + " --> ";
			if (temp.right != null) {
				s.push(temp.right);
			}
			temp = temp.left;
		}

		System.out.println(treeElements);
	}
```

A more optimal code
```java
public void preOrderTraversal() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}
		String treeElements = "";

		Stack<BTNode> s = new Stack<BTNode>();
		s.push(root);
		while (!s.empty()) {
			BTNode temp = s.pop();
			treeElements += temp.data + " --> ";
			if (temp.right != null) {
				s.push(temp.right);
			}
			if (temp.left != null) {
				s.push(temp.left);
			}
		}
		System.out.println(treeElements);
	}
```

**Inorder Iterative Traversal**
```java
public void inOrderTraversalIterative() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}
		BTNode curr = root;
		Stack<BTNode> s = new Stack<BTNode>();
		String treeElements = "";
		boolean done =  false;

		while (!done) {
			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				if (s.empty()) {
					done = true;
				} else {
					curr = s.pop();
					treeElements += " --> " + curr.data;
					curr = curr.right;
				}
			}
		}
		System.out.println(treeElements);
	}
```

**Postorder Traversal of Binary tree**  
There is one more approach other than below but this one is optimal
```java
public void postOrderTraversalIterative() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}

		Stack<BTNode> s = new Stack<BTNode>();
		String treeElements = "";
		s.push(root);

		while (!s.empty()) {
			BTNode curr = s.peek();
			if (curr.left == null && curr.right == null) {
				treeElements += " -> " + curr.data;
				s.pop();
			} else {
				if (curr.right != null ) {
					s.push(curr.right);
					curr.right = null;
				}
				if (curr.left != null) {
					s.push(curr.left);
					curr.left = null;
				}
			}
		}
		System.out.println(treeElements);
	}
```  


**Level Order Traversal (also Line by Line)**

- ***Simple***
	
	```java
	public void myLevelOrderTraversal() {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.offer(root);
		ArrayList<Integer> res = new ArrayList<Integer>();

		while (!q.isEmpty()) {
			BTNode temp = q.poll();
			res.add(temp.data);
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);
		}

		for (int data : res) {
			System.out.print(data + " -> ");
		}

	}
	```

- ***Line By Line***

  ```java
  int height(BTNode root) {
		if (root == null)
			return 0;
		else {
			/* compute  height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else return (rheight + 1);
		}
	}

	public void myLevelOrderLineByLine() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			System.out.println("Level " + i + ": ");
			printGivenLevel(root, i);
			System.out.println("\n");
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel (BTNode root , int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
	```