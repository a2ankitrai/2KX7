import java.util.*;

class PrintRootToLeafPath {

	public static void printPath(Node root) {

		int[] path = new int[1000];
		printPathRecurs(root, path, 0);
	}

	public static void printPathRecurs(Node node, int[] path, int pathLen) {

		if (node == null) {
			return;
		}

		path[pathLen++] = node.data;

		if (node.left == null && node.right == null) {
			printArray(path, pathLen);
		} else {
			printPathRecurs(node.left, path, pathLen);
			printPathRecurs(node.right, path, pathLen);
		}

	}

	public static void printArray(int[] path, int length) {
		for (int i = 0 ; i < length; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	public static List<String> printAllPaths(Node root) {
		List<String> list = new ArrayList<>();

		if (root == null) return list;

		String path = root.data + " -> ";

		if (root.left != null) {
			printAllPaths(root.left, path, list);
		}

		if (root.right != null) {
			printAllPaths(root.right, path, list);
		}
		return list;
	}

	private static void printAllPaths(Node node, String path, List<String> list) {
		if (node.left == null && node.right == null) {
			list.add(path + node.data);
			return ;
		}

		if(node.left != null){
			printAllPaths(node.left,path+node.data+" -> ",list);
		}

		if(node.right != null){
			printAllPaths(node.right,path+node.data+" -> ",list);
		}

	}


	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		tree.root.right.right = new Node(6);

		// printPath(tree.root);

		List<String> list = printAllPaths(tree.root);

		for(String s : list){
			System.out.println(s);
		}
	}
}