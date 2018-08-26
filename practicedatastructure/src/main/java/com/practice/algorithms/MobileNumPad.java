package com.practice.algorithms;
import java.util.ArrayList;
import java.util.List;

public class MobileNumPad {
	static String charmap[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public static void main(String []arg) {
		String digits = "23";
		List<String> res = new ArrayList<String>();
		res.add("");
		if (digits.matches("[2-9]+")) {
			for(int i=0; i<digits.length(); i++) {
				List<String> temp = new ArrayList<String>();
				String str = charmap[digits.charAt(i)-'0'];
				for(int j=0; j<str.length(); j++) {
					for(int k=0; k<res.size(); k++) {
						temp.add(res.get(k)+str.charAt(j));
					}
				}
				res = temp;
			}
		}
	}
		
}
