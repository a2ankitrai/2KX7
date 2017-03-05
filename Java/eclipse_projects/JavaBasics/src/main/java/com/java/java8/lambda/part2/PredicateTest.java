package com.java.java8.lambda.part2;

import java.util.function.Predicate;

public class PredicateTest {

	static boolean isThere(int[] arr, int key, Predicate<Integer> p){
		
		if(p.test(key)){return true;}
		
		return false;
	}
	
	public static void main(String[] args) {

		int[] nums = {1, 2, 3, 4, 5};
		int key = 9;
		
		boolean found = isThere(nums, key, p -> {
			for(int num : nums){
				if(num == key) return true;
			}
			return false;
		});
	
		System.out.println(found);
	}
	
}
