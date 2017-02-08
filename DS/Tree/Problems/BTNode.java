class BTNode {
	public int data;
	public BTNode left;
	public BTNode right;

	public BTNode(int data) {
		this.data = data;
		left =  null;
		right = null;
	}

	public String toString() {
		//	return "BTNode [" + data + "]";

		if (this == null) {
			return "-1";
		} else {
			return "" + data ;
		}


	}
}
