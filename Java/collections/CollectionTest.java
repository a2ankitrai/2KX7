import java.util.*;


class CollectionTest{

	public static void main(String[] args) {
		

		// Without generics
		List<Student> myList = new ArrayList<>();

		Student s = new Student("Michael");
		Dog d = new Dog();
		Cat c = new Cat();

		myList.add(s);
		/*myList.add(d);
		myList.add(c);
		myList.add("JustAnotherString");
		myList.add(24);
*/
		for(Object o : myList){
			System.out.println(o); // toString()
		}


	}
}

class Student{

	String name;

	Student(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String toString(){
		return name;
	}
}

class Dog{

	public String toString(){
		return "kutta";
	}
}

class Cat{
	public String toString(){
		return "Bahaddur Billi";
	}
}