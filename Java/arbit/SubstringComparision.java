import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class SubstringComparision
{

	 public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        
        List<String> substringList = new ArrayList<>();

        for (int i = 0 ; i < s.length() - k + 1; i++){

        	String substring = s.substring(i, i+k);

        	substringList.add(substring);
        }
        /*
        for(String sub : substringList) {
        	System.out.println(sub);
        }*/

        /*
			looping and comparing 
        */
		/*
        smallest = substringList.get(0);
        largest = substringList.get(0);

        for(int i = 1 ; i<substringList.size() ; i++){

        	if(smallest.compareTo(substringList.get(i)) > 0){
        		smallest = substringList.get(i);
        	}

        	if(largest.compareTo(substringList.get(i)) < 0){
        		largest = substringList.get(i);
        	}
        }
        */

        Collections.sort(substringList);

        smallest = substringList.get(0);
        largest = substringList.get( substringList.size() - 1);

  
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
    	
    	String s = "welcometojava";
    	int k = 3;

    	System.out.println(getSmallestAndLargest(s,k));

    }

}