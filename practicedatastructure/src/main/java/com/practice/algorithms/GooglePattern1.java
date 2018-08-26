package com.practice.algorithms;
import java.util.ArrayList;
import java.util.List;

public class GooglePattern1 {

	static String input = "a3[b2[c1[d]f]]e";
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		
		int j=0;
		int i=0;
		for(i=0; i<input.length(); i++) {
			j=i+2;
			if(input.charAt(i)=='[' && input.charAt(j)==']') {
				break;
			}
		}
		String res = "";
		while(i>=0 && j<input.length()) {
			char chari = input.charAt(i);
			char charj = input.charAt(j);
			
			if(chari=='[' && charj==']') {
				int val=input.charAt(i-1)-'0'-1;
				res = input.charAt(i+1)+res;
				String bak = res;
				while(val >0) {
					res += bak;
					val--;
				}
				i=i-3;
				j++;
				if(i<0)
					i=0;
			} else if(chari=='[' && charj!=']'){
				res = res+charj;
				j++;
			}else {
				res = chari+res+charj;
				i--;
				j++;
				if(i<0)
					i=0;
			}
		}
		System.out.println(res);
	}
}
