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
	