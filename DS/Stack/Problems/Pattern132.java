import java.util.*;

class Pattern132 {

	// Just covering continuous case. fail
	static boolean isPattern132(int[] a) {

		if (a == null || a.length < 3) {return false;}

		Stack<Integer> s = new Stack<>();
		s.push(a[0]);
		s.push(a[1]);

		for (int i = 2 ; i < a.length; i++) {

			int t = a[i];

			int s2 = s.pop();
			int s1 = s.pop();

			if (s1 < t && t < s2) {
				return true;
			} else {
				s.push(s1);
				s.push(s2);
				s.push(t);
			}

		}
		return false;
	}

	static class Pair {
		int min;
		int max;

		Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	static boolean find132Pattern(int[] a) {

		Stack<Pair> stack = new Stack<>();

		for (int n : a) {

			if (stack.isEmpty() ||  n < stack.peek().min) {
				stack.push(new Pair(n, n));
			} else if (n > stack.peek().min) {
				Pair last = stack.pop();
				if (n < last.max) {return true;}
				else {
					last.max = n;
					while (!stack.isEmpty() && n >= stack.peek().max) {
						stack.pop();
					}
					// At this time, n < stack.peek().max (if stack not empty)
					if (!stack.isEmpty() && stack.peek().min < n) return true;
					stack.push(last);
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {

		int[] a = {1, 2, 3, 4};
		int[] b = {3, 1, 4, 2};
		int[] c = { -1, 3, 2, 0};
		int[] d = { -1, 3, 4, 0};

		System.out.println("a: " + isPattern132(a));
		System.out.println("b: " + isPattern132(b));
		System.out.println("c: " + isPattern132(c));
		System.out.println("d: " + find132Pattern(d));


	}

}