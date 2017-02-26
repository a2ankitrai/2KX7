import java.util.*;

class DiagonalTraversal {

	public static void traverse(BTNode root) {

		if (root == null) return ;

		Queue<BTNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0 ; i < size ; i++) {
				BTNode temp = q.poll();
				while(temp != null){
					if(temp.left != null){
						q.offer(temp.left);
					}
					System.out.print(temp.data+" ");
					temp=temp.right;
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BTNode root = new BTNode(8);
		root.left = new BTNode(3);
		root.right = new BTNode(10);

		root.left.left = new BTNode(1);
		root.left.right = new BTNode(6);

		root.left.right.left = new BTNode(4);
		root.left.right.right = new BTNode(7);

		root.right.right = new BTNode(14);
		root.right.right.left = new BTNode(13);

		traverse(root);
	}

}