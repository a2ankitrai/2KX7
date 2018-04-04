import java.util.*;

class HashSetTest{

	public static void main(String[] args) {
		
		Set<Integer> mySet = new HashSet<>();

		for(int i = 0 ; i< 100 ; i++){
			mySet.add(i);
		}

		//for(String s : mySet){

		//	System.out.println(s);	
		//} 

		Iterator<Integer> it = mySet.iterator();

		while(it.hasNext()){

			System.out.print(it.next() + " ");
		}

	}
}