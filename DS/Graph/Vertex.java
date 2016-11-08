
public class Vertex {

	public enum Color {
		WHITE, GRAY, BLACK
	}

	Color color;
	int distance;
	Vertex parent;
	String name;
	int discoveryTime;
	int FinishedTime;

	public Vertex(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object v) {

		if (v == this) {
			return true;
		}
		
		if(!(v instanceof Vertex)){
			return false;
		}
		
		Vertex vertex = (Vertex) v;

		if (this.name.equals(vertex.name)) {
			return true;
		} else {
			return false;
		}
	}

}