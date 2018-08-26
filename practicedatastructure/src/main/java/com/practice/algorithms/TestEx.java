package com.practice.algorithms;
public class TestEx {

	public static void main(String []arg) {
		try {
			int x = 1/0;
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
