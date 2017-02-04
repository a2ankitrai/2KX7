import java.util.*;
import java.util.Map.Entry;

class Node extends BTNode {
	int hd;
	public Node left;
	public Node right;


	public Node(int data) {
		super(data);
		hd = Integer.MAX_VALUE;
	}
}

class BottomViewOfBinaryTree {

	public static void printLeaves(Node root) {

		if (root == null) {return ;}
		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		} else {
			printLeaves(root.left);
			printLeaves(root.right);
		}
	}


	public static void bottomView(Node root) {

		if (root == null) {return ;}

		int hd = 0;

		Map<Integer, Node> map = new TreeMap<>();

		Queue<Node> q = new LinkedList<>();
		root.hd = 0 ;

		q.offer(root);

		while (!q.isEmpty()) {
			Node temp = q.poll();

			map.put(temp.hd, temp);

			if (temp.left != null) {
				temp.left.hd = temp.hd - 1 ;
				q.offer(temp.left);
			}

			if (temp.right != null) {
				temp.right.hd = temp.hd + 1;
				q.offer(temp.right);
			}
		}

		// Extract the entries of map into a set to traverse
		// an iterator over that.
		Set<Entry<Integer, Node>> set = map.entrySet();

		// Make an iterator
		Iterator<Entry<Integer, Node>> iterator = set.iterator();

		// Traverse the map elements using the iterator.
		while (iterator.hasNext()) {
			Map.Entry<Integer, Node> me = iterator.next();
			System.out.print(me.getValue().data + " ");
		}

	}

	public static void main(String[] args) {

		Node root = new Node(20);

		root.left = new Node(8);
		root.right = new Node(22);

		root.left.left = new Node(5);
		root.left.right = new Node(3);

		root.right.right = new Node(25);

		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		//	printLeaves(root);

		bottomView(root);

	}
}