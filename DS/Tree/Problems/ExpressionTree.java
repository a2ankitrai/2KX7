import java.util.*;

class ExpressionTree {

	class Node {

		char value;
		Node left;
		Node right;

		Node(char value) {
			this.value = value;
		}
	}

	boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^')
			return true;
		return false;
	}

	public Node createTree(String postFix) {

		char[] c = postFix.toCharArray();
		Stack<Node> s = new Stack<>();


		for (int i = 0 ; i < c.length; i++) {
			if (!isOperator(c[i])) {
				Node t = new Node(c[i]);
				s.push(t);
			} else {
				Node t1 = s.pop();
				Node t2 = s.pop();

				Node op = new Node(c[i]);

				op.left = t2;
				op.right = t1;
				s.push(op);
			}
		}

		Node root = s.pop();
		return root;
	}

	void inorder(Node t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.value + " ");
			inorder(t.right);
		}
	}

	public static void main(String[] args) {

		ExpressionTree et = new ExpressionTree();
		String postfix = "ab+ef*g*-";
		Node root = et.createTree(postfix);
		et.inorder(root);

	}
}