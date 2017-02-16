# Binary tree traversals

**Preorder**: Each node is processed before (pre) either of its sub-trees.  
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

Push the root node on stack. While the stack is not empty; pop the stack. Push the right child (if not null) of popped element to the stack. Push the left child(if not null) of popped element to the stack.

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

Post-order traversal is useful in some types of tree operations:

- Tree deletion. In order to free up allocated memory of all nodes in a tree, the nodes must be deleted in the order where the current node can only be deleted when both of its left and right subtrees are deleted.

- Evaluating post-fix notation.

Push the root node on to a stack. Peek the top element. If its left and right child are null the pop the element otherwise push the right child to the stack and deleting the right child link followed by pushing the left child and deleting the link.

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

The above algorithm modifies the tree by deleting left and right references to a node. We can avoid this by maintaining a previous variable for detecting the previously visited node

```java
public void postOrderTraversalIterative2() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}

		Stack<BTNode> s = new Stack<BTNode>();
		String treeElements = "";
		BTNode prev = null;

		s.push(root);

		while (!s.empty()) {
			BTNode curr = s.peek();
			// we are traversing down the tree
			if (prev == null || prev.left == curr || prev.right == curr) {

				if (curr.left != null) {
					s.push(curr.left);
				} else if (curr.right != null) {
					s.push(curr.right);
				}
			} else if (prev == curr.left) {
				if(curr.right != null){// we are traversing up the tree from the left
					s.push(curr.right);	
				}				 	
			} else {
				treeElements += curr.data + " "; // we are traversing up the tree from the right when `prev == curr.right`
				s.pop();
			}

			prev = curr;
		}

		System.out.println(treeElements);
	}
```

An alternative solution is to use two stacks. It is doing a reversed pre-order traversal. That is, the order of traversal is a node, then its right child followed by its left child. This yields post-order traversal in reversed order. Using a second stack, we could reverse it back to the correct order.


```java
public void postOrderTraversalIterativeUsing2Stacks() {

		Stack<BTNode> s = new Stack<BTNode>();
		Stack<BTNode> output = new Stack<BTNode>();
		String treeElements = "";
		s.push(root);

		while(!s.empty()){
			BTNode curr = s.pop();
			if(curr.left!=null){
				s.push(curr.left);
			}
			if(curr.right!=null){
				s.push(curr.right);
			}
			output.push(curr);
		}

		while(!output.empty()){
			treeElements += output.pop().data + " ";
		}

		System.out.println(treeElements);
	}
```

**Traversal Uses**

*Use of Pre-Order:*

- Pre-order traversal is used to create a copy of the tree.
- Pre-order traversal is also used to get prefix expression on of an expression tree. 

*Use of Post-Order :*

- Postorder traversal is used to delete the tree.
- Postorder traversal is also useful to get the postfix expression of an expression tree. 

e.g. Parse Tree

```
    *
   / \
  +   \
 / \   \
A   B   C
```
You could serialize it as * + A B C by walking it in prefix order, or as A B + C * by walking it in postfix order. 


*In Order*

- If you know that the tree has an inherent sequence in the nodes, and you want to flatten the tree back into its original sequence, than an in-order traversal should be used. The tree would be flattened in the same way it was created. A pre-order or post-order traversal might not unwind the tree back into the sequence which was used to create it.

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
		public static void levelOrder(Node root) {

			if (root ==  null) return ;

			Queue<Node> q = new LinkedList<>();

			q.offer(root);

			while (!q.isEmpty()) {

				int size = q.size();

				for (int i = 0; i < size ; i++) {
					Node cur = q.poll();
					System.out.print(cur.data + " ");
					if (cur.left != null) q.add(cur.left);
					if (cur.right != null) q.add(cur.right);
				}
				System.out.println();
			}
		}
	```

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
	
--- 

## BFS

```java
public void bfs() {
		if (root == null) {
			System.out.println("Empty tree");
			return;
		}

		StringBuilder sb = new StringBuilder();
		Queue<BTNode> q = new LinkedList<BTNode>();

		q.offer(root);

		while (!q.isEmpty()) {
			BTNode temp = q.poll();
			sb.append(temp.data + " ");
			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
		System.out.println(sb);
	}
```	
	