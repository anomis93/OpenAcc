package com.practice.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagram {

	public static void main(String[] args) {

		int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
		String []input = {"aes", "eas", "tan", "rat", "sae", "atr"};
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		
		for(String s : input) {
			int key = 1;
			for(int i=0; i<s.length(); i++) {
				int ascii = s.charAt(i)-'a';
				key = key*prime[ascii];
			}
			if(map.containsKey(key)) {
				List<String> list = map.get(key);
				list.add(s);
			} else {
				List<String> list = new LinkedList<String>();
				list.add(s);
				map.put(key, list);
			}
		}
		
		List<List<String>> res = new ArrayList<List<String>>();
		res.addAll(map.values());
		System.out.println(res);
	}

}
