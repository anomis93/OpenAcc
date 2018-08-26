package com.practice.algorithms;
import java.util.ArrayList;
import java.util.List;

public class Permutation {
	static String s = "1122";
	static List<String> res = new ArrayList<String>();
	public static void main(String []arg) {
		
	permutation(s);
		System.out.println(res);
	}
	
	public static void permutation(String s) {
		if(res.contains(s)) {
			return;
		} else {
			res.add(s);
			for(int i=0 ;i<s.length(); i++) {
				char []ch = s.toCharArray();
				
				if(i==s.length()-1) {
					char temp = ch[0];
					ch[0] = ch[ch.length-1];
					ch[ch.length-1] = temp;
				} else {
					char temp = ch[i];
					ch[i] = ch[i+1];
					ch[i+1] = temp;
				}
				s = new String(ch);
				permutation(s);
			}
		}
	}
}
