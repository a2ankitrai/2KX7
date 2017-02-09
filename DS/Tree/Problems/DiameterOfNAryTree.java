import java.util.*;

class DiameterOfNAryTree {

	class Node {

		int data;
		List<Node> children = new ArrayList<Node>();
		int height;
	}

	int getMax(List<Node> nodeList){

		int max = 0 ;

		for(Node n : nodeList){
			if(n.height > max){
				max = n.height;
			}
		}
		return max;
	}

	int height(Node root) {

		if (root == null) {return 0;}

		return 1 + getMax(root.children);
	}

}