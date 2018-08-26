package com.practice.algorithms;
public class ZigZag {

	public static void main(String []arg) {
		String input = "AB";
		int num = 1;
		int length = input.length();
		int colnum = (length/num)*2;
		char arr[][]=new char[num][colnum];
		int row=0;
		int col=0;
		boolean rowIncreament = true;
		
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (row < num-1 && rowIncreament) {
				arr[row][col] = c;
				row++;
			} else if(row > 0){
				arr[row][col] = c;
				rowIncreament = false;
				col++;
				row--;
				
			} else {
				rowIncreament = true;
				arr[row][col] = c;
				row++;
			}
		}
		String res = "";
		for(int i=0; i<num; i++) {
			for(int j=0; j<colnum; j++) {
				res += arr[i][j];
				res = res.trim();
			}
		}
		System.out.println(res);
	}
}
