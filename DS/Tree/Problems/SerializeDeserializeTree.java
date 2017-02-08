import java.util.*;
import java.io.File;
import java.io.IOException;

class SerializeDeserializeTree {

	public List<BTNode> serializeTree(BTNode root) {

		if (root == null) {
			return null;
		}

		List<BTNode> list = new ArrayList<BTNode>();
		serializeTreeUtil(root, list);
		return list;
	}

	public void serializeTreeUtil(BTNode root, List<BTNode> list) {

		if (root == null) {
			list.add(null);
			return ;
		}

		list.add(root);
		serializeTreeUtil(root.left, list);
		serializeTreeUtil(root.right, list);
	}

	public void printList(List<BTNode> serializeTreeList) {
		for (BTNode node : serializeTreeList) {
			System.out.print(node + " ");
		}

	}

	public BTNode deSerializeTree(List<BTNode> list) {
		if (list == null) { return null; }

		BTNode root = null;
		root = deSerializeTreeUtil(root, list);
		return root;
	}

	public BTNode deSerializeTreeUtil(BTNode root, List<BTNode> list) {
		if (list.size() > 0) {
			root = list.get(0) ;
			list.remove(0);

			if(root == null){return root;}

			root.left = deSerializeTreeUtil(root.left, list);
			root.right = deSerializeTreeUtil(root.right, list);
		}
		return root;
	}

	void printInorder(BTNode node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) throws IOException {

		SerializeDeserializeTree sd = new SerializeDeserializeTree();

		BTNode root = new BTNode(20);
		root.left   = new BTNode(8);
		root.right  = new BTNode(22);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(12);
		root.left.right.left  = new BTNode(10);
		root.left.right.right = new BTNode(14);

		/*	File file = new File("ser.txt");
			file.createNewFile();*/

		System.out.println("Initial inorder:\n");
		sd.printInorder(root);
		List<BTNode> serializedTreeList = sd.serializeTree(root);
		
		System.out.println("\nSerialized Tree:\n");
		sd.printList(serializedTreeList);


		BTNode root2 = sd.deSerializeTree(serializedTreeList);
		System.out.println("\nAfter Deserialization inorder:\n");
		sd.printInorder(root2);



	}

}