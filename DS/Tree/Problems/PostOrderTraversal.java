import java.util.*;

class PostOrderTraversal {

	Node root;

	public void postOrderTraversalIterative() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}

		Stack<Node> s = new Stack<Node>();
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

	public void postOrderTraversalIterative2() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}

		Stack<Node> s = new Stack<Node>();
		String treeElements = "";
		Node prev = null;

		s.push(root);

		while (!s.empty()) {
			Node curr = s.peek();

			if (prev == null || prev.left == curr || prev.right == curr) {

				if (curr.left != null) {
					s.push(curr.left);
				} else if (curr.right != null) {
					s.push(curr.right);
				}
			} else if (prev == curr.left) {
				s.push(curr.right);
			} else {
				treeElements += curr.data + " ";
				s.pop();
			}

			prev = curr;
		}


		System.out.println(treeElements);
	}


	public void postOrderTraversalIterativeUsing2Stacks() {

		Stack<Node> s = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();
		String treeElements = "";
		s.push(root);

		while (!s.empty()) {
			Node curr = s.pop();
			if (curr.left != null) {
				s.push(curr.left);
			}
			if (curr.right != null) {
				s.push(curr.right);
			}
			output.push(curr);
		}

		while (!output.empty()) {
			treeElements += output.pop().data + " ";
		}

		System.out.println(treeElements);
	}


}