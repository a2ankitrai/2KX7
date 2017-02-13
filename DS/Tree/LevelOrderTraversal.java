import java.util.*;

class LevelOrderTraversal {

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

	public static void main(String[] args) {
		
		Node root = new Node(1);

		//Level 1 - nodes
		Node l1e1 = new Node(2);
		Node l1e2 = new Node(3);

		root.left = l1e1;
		root.right = l1e2;

		//-------------------------------------------
		//Level 2 - nodes
		Node l2e1 = new Node(4);
		Node l2e2 = new Node(5);
		Node l2e3 = new Node(6);
		Node l2e4 = new Node(7);

		l1e1.left = l2e1;
		l1e1.right = l2e2;
		l1e2.left = l2e3;
		l1e2.right = l2e4;

		//-------------------------------------------
		//Level 3 - nodes

		Node l3e1 = new Node(8);
		Node l3e2 = new Node(9);
		l2e1.left = l3e1;
		l2e1.right = l3e2;

		//-------------------------------------------
		//Level 4 - nodes
		Node l4e1 = new Node(10);
		l3e1.right = l4e1;


		levelOrder(root);
	}

}