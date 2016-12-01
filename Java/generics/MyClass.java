class MyClass<X> {
	
	<T> MyClass(T t){
		System.out.println("inside contructor : "+ t);
	}	
 

	public static void main(String[] args) {
		MyClass<Integer> m = new MyClass<>("asdas");
	}
}