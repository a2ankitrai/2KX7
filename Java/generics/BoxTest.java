class Box<T> {

	private T t;

	public void set(T t) {this.t = t;}
	public T get() {return t;}

	public <U extends Number> void inspect(U u) {
		System.out.println("T: " + t.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}
}

public class BoxTest {

	public static void main(String[] args) {

		/*
		In Java SE 7 and later, you can replace the type arguments required to invoke the constructor of a generic class with an empty set of type arguments (<>) as long as the compiler can determine, or infer, the type arguments from the context.
		*/
		Box<Integer> b1 = new Box<>();
		b1.set(2);

		Box<String> b2 = new Box<>();
		b2.set("Hello");

		System.out.println("b1: " + b1.get());

		System.out.println("b2: " + b2.get());

		//b2.inspect("s");
		b2.inspect(4);
	}
}