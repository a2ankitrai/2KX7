class MorrisTraversal {

	static class Node {

		int val;
		Node left;
		Node right;

		Node(int val) { this.val = val; }
	}

	Node root;

	void morrisInorder() {

		if (root == null) return ;

		Node pre = null, curr = null;

		curr = root;

		while (curr != null) {
			if (curr.left == null) {
				System.out.print(curr.val + " ");
				curr = curr.right;
			} else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr) {
					pre = pre.right;
				}

				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					pre.right = null;
					System.out.print(curr.val + " ");
					curr = curr.right;
				}
			}
		}
	}

	void morrisPreOrder(Node node) {
		while(node != null){

			if(node.left == null){
				System.out.print(node.val + " ");
				node = node.right;
			}
			else {
				Node inPre = node.left;		
				while(inPre.right != null && inPre.right != node){
					inPre = inPre.right;
				}

				if(inPre.right == null){
					System.out.print(node.val+ " ");					
					inPre.right = node;
					node = node.left;
				}
				else {
					inPre.right = null;
					node = node.right;
				}
			}
		}
	}

	public static void main(String[] args) {

		MorrisTraversal mt = new MorrisTraversal();

		mt.root = new Node(1);
		mt.root.left = new Node(2);
		mt.root.right = new Node(3);
		mt.root.left.left = new Node(4);
		mt.root.left.right = new Node(5);

		mt.morrisInorder();
		System.out.println();
		mt.morrisPreOrder(mt.root);
	}

}