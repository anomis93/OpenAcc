package com.practice.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracesMatching {

	public static void main(String []arg) {
		
		Stack<String> stack = new Stack<String>();
		String s = "()";
		 int length = s.length();
	        if(length%2!=0)
	            System.out.println(false);
	        
	        int[] arr = new int[length];
	        int top = -1;
	        
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        map.put('(' ,-1);
	        map.put(')', 1);
	         map.put('{' ,-2);
	        map.put('}', 2);
	         map.put('[' ,-3);
	        map.put(']', 3);
	        
	        for(int i=0; i<length/2; i++){
	            int c = map.get(s.charAt(i));
	         
	            if((top < 0 && (c+arr[top+1])==0) || (top>=0 && (c+arr[top])==0)) {
	                arr[top]=0;
	                top--;
	            } else{
	                top++;
	                arr[top]=c;
	            }
	        }
        if(top==-1){
            System.out.println(true);
        }
        else {
        	System.out.println(false);
        }
	}
}
