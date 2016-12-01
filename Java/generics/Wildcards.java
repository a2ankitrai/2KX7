import java.util.List;
import java.util.ArrayList;

class Wildcards {

	// Upper Bound
	public static double sumOfList(List<? extends Number> list) {
		double s = 0.0;
		for (Number n : list)
			s += n.doubleValue();
		return s;
	}

	// Lower Bound
	public static void addNumbers(List<? super Integer> list) {
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}

		System.out.println(list);
	}

	public static void main(String[] args) {
		List<Number> numList = new ArrayList<>();
		List<Object> objList = new ArrayList<>();

		addNumbers(numList);

		addNumbers(objList);

		List<Number> numList2 = new ArrayList<>();

		numList2.add(2);
		numList2.add(3);
		numList2.add(4);
		numList2.add(5);
		numList2.add(6);
		numList2.add(7);

		System.out.println("Generic sum " + sumOfList(numList2));
	}

}