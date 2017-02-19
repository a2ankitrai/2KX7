package com.java.test;

import java.util.*;

public class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        
        if(s.length()== 0 ) {return true ;}
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =0 ;i < s.length(); i++){
            sb.append(s.charAt(i));
            if(wordDict.contains(sb.toString())){
                return wordBreak(s.substring(i+1),wordDict);
            }
        }
        return false;
        
    }
    
    public static void main(String[] args) {
		String s = "leetcode";
		String [] dict = {"leet","code"};
		
		System.out.println(wordBreak(s, Arrays.asList(dict)));
	}
}