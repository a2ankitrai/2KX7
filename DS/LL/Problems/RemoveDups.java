import java.util.*;
import java.util.LinkedList;

class RemoveDups {
	
	public static void removeDuplicates(LinkedList<Integer> list){
		HashSet<Integer> set = new HashSet<>();

		Iterator<Integer> it = list.listIterator();

		while (it.hasNext()) {
			Integer i = it.next();
			if(set.contains(i)){
				it.remove();
			}
			else{
				set.add(i);
			}
		}
	}


	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(6);

		removeDuplicates(list);

		System.out.println(list);
	}

}