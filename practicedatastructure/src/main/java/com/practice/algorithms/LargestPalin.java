package com.practice.algorithms;
public class LargestPalin {

	static String val = "12345323";
	static String res="";
	public static void main(String []arg) {
		palin(0, val.length());
		System.out.println(res);
	}
	
	public static void palin(int index1, int index2) {
		
		if(index1>index2) {
			return;
		}else {
			String s = val.substring(index1, index2);
			int n=s.length();
			boolean test = true;
	        for(int i=0, j=n-1; i<n/2; i++){
	            if(s.charAt(i) != s.charAt(j--)){
	                test = false;
	                break;
	            }
	        }
	        
	        if(test && res.length() < s.length()) {
	        	res = s;
	        }
	        palin(index1, index2-1);
	        palin(index1+1, index2);
	      
		}
	}
}
