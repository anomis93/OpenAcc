package com.practice.algorithms;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoArray {
	
	public static void main(String []arg) {
		
		int [] a = {5,15,7};
		int []b = {1, 4, 8, 10};
				
		List<Integer> res = new ArrayList<Integer>();
		
		int i=0;
		int j=0;
		while(i<a.length && j<b.length) {
			if(a[i] < b[j]) {
				res.add(a[i]);
				i++;
			} else {
				res.add(b[j]);
				j++;
			}
		}
		while(i<a.length) {
			res.add(a[i]);
			i++;
		}
		while(j<b.length) {
			res.add(b[j]);
			j++;
		}
		int med = 0;
		if(res.size() %2==0) {
			med = res.get(res.size()/2) + res.get((res.size()/2)-1); 
		}else {
			med = res.get(res.size()/2);
		}
		System.out.println(res);
		System.out.println(med);
	}

}
