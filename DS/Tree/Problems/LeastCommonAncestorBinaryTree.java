class Node {
	int data;
	Node left;
	Node right;

	public Node(int data){
		this.data = data;
	}
}

class BinaryTree {

	Node root;

	public Node leastcommonAncestor(Node node, int n1, int n2) {

		if (node == null) {
			return null;
		}

		if (node.data > n1 && node.data > n2 ) {
			return leastcommonAncestor(node.left, n1, n2);
		} else if (node.data < n1 && node.data < n2) {
			return leastcommonAncestor(node.right, n1, n2);
		}
		return node;
	}
}

public class LeastCommonAncestorBinaryTree {

	public static void main(String[] args) {
		// Let us construct the BST shown in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = tree.leastcommonAncestor(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);


        n1 = 14;
        n2 = 8;
        t = tree.leastcommonAncestor(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 10;
        n2 = 22;
        t = tree.leastcommonAncestor(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);


	}
}