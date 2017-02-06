/*Construct Binary Tree from given Parent Array representation
Given an array that represents a tree in such a way that array indexes are values
in tree nodes and array values give the parent node of that particular index (or node).
The value of the root node index would always be -1 as there is no parent for root.
Construct the standard linked representation of given Binary Tree*/

import java.util.*;

class ConstructTreeFromParentTreeArray {

	public BTNode treeFromParentArray(int[] a) {

		int rootNodeData = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == -1) {
				rootNodeData = i;
			}
		}

		BTNode root = new BTNode(rootNodeData);


		return treeFromParentArrayUtil(root, a);
	}

	private List<Integer> searchIndex(int[] a, int val) {
		List<Integer> indexes = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == val) {
				indexes.add(i);
			}
		}
		return indexes;
	}

	private int searchValue(int[] a, int index) {

		int val = Integer.MIN_VALUE;

		try {
			val = a[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Bad index");
		}
		return val;

	}

	public BTNode treeFromParentArrayUtil(BTNode root, int[] a) {

		if (root == null) {return root;}

		List<Integer> indexes = searchIndex(a, root.data);
		int size = indexes.size();

		switch (size) {
		case 0 : return root;
		case 1:
			BTNode childNode = new BTNode(indexes.get(0));
			root.left = treeFromParentArrayUtil(childNode, a);
			break;
		case 2:
			int data1 = indexes.get(0);
			int data2  = indexes.get(1);
			BTNode childNode1 = new BTNode(data1); 	//1
			BTNode childNode2 = new BTNode(data2);	//2

			root.left = treeFromParentArrayUtil(childNode1, a);
			root.right = treeFromParentArrayUtil(childNode2, a);
			break;
		}

		return root;
	}

	// A utility function to print inorder traversal of a Binary Tree
	void printInorder(BTNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	void createNode(int parent[], int i, BTNode created[], BTNode root) {
		// If this node is already created
		if (created[i] != null)
			return;

		// Create a new node and set created[i]
		created[i] = new BTNode(i);

		// If 'i' is root, change root pointer and return
		if (parent[i] == -1) {
			root = created[i];
			return;
		}

		// If parent is not created, then create parent first
		if (created[parent[i]] == null)
			createNode(parent, parent[i], created, root);

		// Find parent pointer
		BTNode p = created[parent[i]];

		// If this is first child of parent
		if (p.left == null)
			p.left = created[i];
		else // If second child

			p.right = created[i];
	}

	/* Creates tree from parent[0..n-1] and returns root of
	   the created tree */
	BTNode createTree(int parent[], int n) {
		// Create an array created[] to keep track
		// of created nodes, initialize all entries
		// as NULL
		BTNode root = null;

		BTNode[] created = new BTNode[n];
		for (int i = 0; i < n; i++)
			created[i] = null;

		for (int i = 0; i < n; i++)
			createNode(parent, i, created, root);

		return root;
	}


	public static void main(String[] args) {

		ConstructTreeFromParentTreeArray ct = new ConstructTreeFromParentTreeArray();

		int[] a = {1, 5, 5, 2, 2, -1, 3};
		int[] b = { -1, 0, 0, 1, 1, 3, 5};


		BTNode root = ct.treeFromParentArray(a);
	//	BTNode root = ct.createTree(a,a.length);	
		ct.printInorder(root);
		System.out.println();
		BTNode root2 = ct.treeFromParentArray(b);
		ct.printInorder(root2);

	}

}