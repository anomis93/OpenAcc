package com.practice.algorithms;
public class JumpGame {

	public static void main(String[] args) {
		int []input = {1,2,3};
		int res = jump(input);
		System.out.println(res);
	}
	
	public static int jump(int []input) {
		int lastIndex = input.length-1;
		int i=1;
		int count=0;
	
		while(i<lastIndex) {
			int val = input[i-1];
			if(val >= lastIndex) {
				count++;
				return count;
			} else {
				int max = val;
				for(int j=i; j < val; j++) {
					if(input[j-1] > max)
						max = input[j-1];
				}
				count++;
			}
			i = i+count;
		}
		return count;
	}

}
