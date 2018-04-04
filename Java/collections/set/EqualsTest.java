
import java.util.*;

class EqualsTest {

	public static void main(String[] args) {
		

		Student s1 = new Student("June", 123);
		Student s2 = new Student("June", 123);
		Student s3 = new Student("Michael", 125);
		Student s4 = new Student("Sexcy", 126);


		Set<Student> mySet = new HashSet<>();

		mySet.add(s1);
		mySet.add(s2);
		mySet.add(s3);
		mySet.add(s4);

		for(Student student : mySet){
			System.out.println(student);
		}

	}

}


class Student{

	String name;
	int rollNo;

	Student(String name, int rollNo){

		this.name = name;
		this.rollNo = rollNo;
	}

	public String toString(){
		return name + ": "+rollNo;
	}

	public int hashcode(){
		
		int hash = 0 ;

		for(int i = 0 ; i < this.name.length(); i++){

		 	hash += this.name.charAt(i);
		}
		return hash;

	}

	public boolean equals(Object o){

		Student anotherStudent = (Student)o;
		if(anotherStudent.name.equals(this.name)){
			return true;
		}
		else return false;
	}


}


















