/**
* Level order traversal in spiral form
* Write a function to print spiral order traversal of a tree
*/
import java.util.*;

class SpiralPrint {

	public static void iterativeSpiral(BTNode root) {

		if (root == null) {
			return ;
		}

		// Use two stacks
	}

	public static void main(String[] args) {

		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(7);
		root.left.right = new BTNode(6);
		root.right.left = new BTNode(5);
		root.right.right = new BTNode(4);

		iterativeSpiral(root);

	}

}