import java.util.*;

class LCABinaryTree {

	public static boolean printAncestorsFunc(BTNode root, int target, Stack<BTNode> stack) {

		if (root == null) {
			return false;
		}

		if (root.data == target) {
			stack.push(root);
			return true;
		}

		if (printAncestorsFunc(root.left, target, stack) ||
		        printAncestorsFunc(root.right, target, stack)) {
			stack.push(root);
			return true;
		}

		return false;
	}

	public static BTNode findLCA(BTNode root, int n1, int n2) {
		Stack<BTNode> s1 = new Stack<>();
		Stack<BTNode> s2 = new Stack<>();
		boolean b1 = printAncestorsFunc(root, n1, s1);
		boolean b2 = printAncestorsFunc(root, n2, s2);

//		System.out.println(s1);
//		System.out.println(s2);
		BTNode lca = null;
		if (b1 && b2) {
			while (!s1.isEmpty() && !s2.isEmpty()) {
				BTNode t1 = s1.pop();
				BTNode t2 = s2.pop();


//				System.out.println("t1: " + t1);
//				System.out.println("t2: " + t2);

				if (t1 == t2) {
					lca = t1;
				} else {
					break;
				}
			}
		} else return null;
		return lca;
	}

	public static void main(String[] args) {

		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);

		System.out.println("LCA(4, 5) = " + findLCA(root, 4, 5));
		System.out.println("LCA(4, 6) = " + findLCA(root, 4, 6));
		System.out.println("LCA(3, 4) = " + findLCA(root, 3, 4));
		System.out.println("LCA(2, 4) = " + findLCA(root, 2, 4));

	}
}