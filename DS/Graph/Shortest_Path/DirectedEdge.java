class DirectedEdge {

	private int v;
	private int w;
	private double weight;

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public String toString() {
		return v + " ->" + w + "  " + String.format("%5.2f", weight);
	}

	public static void main(String[] args) {
		DirectedEdge d = new DirectedEdge(1,2,2.5);
		System.out.println(d);
	}
}