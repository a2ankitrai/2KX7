import java.util.*;

class ConstructTreeFrmPreOrderTraversal {

	class Index {
		int index = 0;
	}

	public BTNode makeTree(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}

		Index preIndex = new Index();

		return makeTreeAux(a, preIndex, 0, a.length - 1, a.length);
	}


	public BTNode makeTreeAux(int[] a, Index preIndex, int low, int high, int size) {

		if (preIndex.index >= size || low > high) {
			return null;
		}

		BTNode root = new BTNode(a[preIndex.index]);

		preIndex.index = preIndex.index + 1;


		if (low == high) {return root;}

		int i;
		for (i = low; i <= high; ++i) {
			if (a[i] > root.data) {
				break;
			}
		}

		root.left = makeTreeAux(a, preIndex, preIndex.index, i - 1, size);
		root.right = makeTreeAux(a, preIndex, i, high, size);

		return root;
	}

	public BTNode constructTreeFromStack(int[] a) {

		if (a == null || a.length == 0) {
			return null;
		}

		BTNode root = new BTNode(a[0]);

		Stack<BTNode> s = new Stack<BTNode>();
		s.push(root);

		for (int i = 1; i < a.length; i++) {
			BTNode temp = null;

			while (!s.isEmpty() && a[i] > s.peek().data) {
				temp = s.pop();
			}

			if (temp != null) {
				temp.right = new BTNode(a[i]);
				s.push(temp.right);
			} else {
				temp = s.peek();
				temp.left = new BTNode(a[i]);
				s.push(temp.left);
			}
		}
		return root;
	}


	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	void printInorder(BTNode node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {


		int[] a = new int[] {10, 5, 1, 7, 40, 50};

		ConstructTreeFrmPreOrderTraversal ct = new ConstructTreeFrmPreOrderTraversal();

		BTNode root = ct.makeTree(a);

		BTNode root2 = ct.constructTreeFromStack(a);

		ct.printInorder(root2);

	}
}