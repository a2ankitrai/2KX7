
import java.util.*;

class LinkedHashSetTest{

	public static void main(String[] args) {
		
		LinkedHashSet<String> ls = new LinkedHashSet<>();

		ls.add("q");
		ls.add("w");
		ls.add("e");
		ls.add("r");
		ls.add("t");
		ls.add("y");

		System.out.println("LinkedHashSet");

		for(String s : ls){
			System.out.print(s+" ");
		}
		

		System.out.println();

		System.out.println("HashSet");
		Set<String> ls2 = new HashSet<>();
		ls2.add("q");
		ls2.add("w");
		ls2.add("e");
		ls2.add("r");
		ls2.add("t");
		ls2.add("y");

		for(String s : ls2){
			System.out.print(s+" ");
		}

		
		System.out.println();
	}
}