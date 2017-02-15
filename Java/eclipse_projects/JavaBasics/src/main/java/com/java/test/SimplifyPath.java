

package com.java.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {

	public static String simplifyPath(String path) {
		   //     String res = "/";
		        
		        String[] paths = path.split("/");
		        Deque<String> s = new LinkedList<String>();
		        
		        for(String p : paths){
		            if( p.equals("..") && !s.isEmpty()){
		                    s.pop();
		            }
		            else if( !p.equals(".") && !p.equals("..") && !p.equals("")){
		                s.push(p);
		            }
		        }
		         String res = "";
		    for (String dir : s) res = "/" + dir + res;
		    return res.isEmpty() ? "/" : res;
		      /*
		        while(!s.isEmpty()){
		            String th = s.pop();
		            res +=th+"/";
		        }
		        return res;*/
		    }
	
	
	public static void main(String[] args) {
		String input = "/abc/...";
		
		System.out.println(simplifyPath(input));
	}
}
