import java.util.Stack;
import java.util.*;

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

	public void preOrderTraversalRecursive(BTNode root) {
		if (root != null) {
			System.out.print(root.data + " --> ");
			preOrderTraversalRecursive(root.left);
			preOrderTraversalRecursive(root.right);
		}
	}

	public void inOrderTraversalRecursive(BTNode root) {
		if (root != null) {
			inOrderTraversalRecursive(root.left);
			System.out.print(root.data + " --> ");
			inOrderTraversalRecursive(root.right);
		}
	}

	public void postOrderTraversalRecursive(BTNode root) {
		if (root != null) {
			postOrderTraversalRecursive(root.left);
			postOrderTraversalRecursive(root.right);
			System.out.print(root.data + " --> ");
		}
	}

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

	public void inOrderTraversalIterative() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}
		BTNode curr = root;
		Stack<BTNode> s = new Stack<BTNode>();
		String treeElements = "";
		boolean done =  false;

		/*while (!done) {
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
		}*/

		while (curr != null) {
			s.push(curr);
			curr = curr.left;
		}

		while (s.empty()) {
			curr = s.pop();
			treeElements += " --> " + curr.data;
			if (curr.right != null) {
				curr = curr.right;
			}

			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
		}

		System.out.println(treeElements);
	}

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


	/* computes number of nodes in tree */
	int size(BTNode node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	public int max(BTNode root) {
		BTNode node = root;

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int res = node.data;
		int leftMax = max(node.left);
		int rightMax = max(node.right);

		if (res < leftMax) {
			res = leftMax;
		}
		if (res < rightMax) {
			res = rightMax;
		}

		return res;
	}

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

	public void levelOrderTraversalReverse() {
		if (root == null) {
			return;
		}

		Stack<BTNode> s = new Stack<BTNode>();
		Queue<BTNode> q = new LinkedList<BTNode>();

		q.offer(root);
		while (!q.isEmpty()) {
			BTNode temp = q.poll();

			if (temp.right != null) {
				q.offer(temp.right);
			}
			if (temp.left != null) {
				q.offer(temp.left);
			}
			s.push(temp);
		}
		while (!s.empty()) {
			System.out.print("-> " + s.pop().data);
		}
	}

	// Not working ...
	public void trueLevelOrderTraversal() {
		if (root == null)
			return;

		Queue<BTNode> q = new LinkedList<BTNode>();
		q.offer(root);
		int level = 1 ;
		while (!q.isEmpty()) {
			BTNode temp = q.poll();
			System.out.println("Level " + level + ": " + temp.data);
			if (temp.left != null) {
				q.offer(temp.left);
				level++;
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}

		}

	}

	/*The function Compute the "height" of a tree. Height is the
	 number f nodes along the longest path from the root node
	 down to the farthest leaf node.*/
	static int height(BTNode node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

		/* If tree is not empty then height = 1 + max of left
		   height and right heights */
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	/* Method to calculate the diameter and return it to main */
	int diameter(BTNode root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = height(root.left);
		int rheight = height(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);

		/* Return max of following three
		  1) Diameter of left subtree
		 2) Diameter of right subtree
		 3) Height of left subtree + height of right subtree + 1 */
		return Math.max(lheight + rheight + 1,
		                Math.max(ldiameter, rdiameter));

	}

	/* A wrapper over diameter(Node root) */
	int diameter() {
		return diameter(root);
	}

	public static void main(String[] args) {
		BTNode root = new BTNode(1);

		//Level 1 - nodes
		BTNode l1e1 = new BTNode(2);
		BTNode l1e2 = new BTNode(3);

		root.left = l1e1;
		root.right = l1e2;

		//-------------------------------------------
		//Level 2 - nodes
		BTNode l2e1 = new BTNode(4);
		BTNode l2e2 = new BTNode(5);
		BTNode l2e3 = new BTNode(6);
		BTNode l2e4 = new BTNode(7);

		l1e1.left = l2e1;
		l1e1.right = l2e2;
		l1e2.left = l2e3;
		l1e2.right = l2e4;

		//-------------------------------------------
		//Level 3 - nodes

		BTNode l3e1 = new BTNode(8);
		BTNode l3e2 = new BTNode(9);
		l2e1.left = l3e1;
		l2e1.right = l3e2;
		
		//-------------------------------------------
		//Level 4 - nodes		
		BTNode l4e1 = new BTNode(10);
		l3e1.right = l4e1;


		BinaryTree bt = new BinaryTree(root);

		//		bt.preOrderTraversal();
		//		bt.preOrderTraversalRecursive(root);
		//	bt.inOrderTraversalRecursive(root);
		//		bt.postOrderTraversalRecursive(root);
		//		bt.postOrderTraversalIterative();
		//		bt.levelOrderTraversalReverse();
		// 		bt.trueLevelOrderTraversal();

		//		System.out.println(bt.max(root));
		// 		bt.bfs();

		System.out.println(bt.diameter());
	}

}