import java.util.Stack;

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
		System.out.println(treeElements);
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


		BinaryTree bt = new BinaryTree(root);

		//		bt.preOrderTraversal();
		//		bt.preOrderTraversalRecursive(root);
		//		bt.inOrderTraversalRecursive(root);
		//		bt.postOrderTraversalRecursive(root);
		bt.inOrderTraversalIterative();
	}

}