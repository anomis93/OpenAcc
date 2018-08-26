package com.practice.algorithms;
public class Palindrome {

	public static void main(String[] args) {

		int palindromeNumber = 1000000001;
		int reversedNumber = reverseNumber(palindromeNumber);
		System.out.println("reversedNumber "+ reversedNumber);
		if(reversedNumber == palindromeNumber)
		{
			System.out.println("The Number is palindrome");
		}else {
			System.out.println("The Number is NOT palindrome");
		}
		
	}
	
	
	
	
	static int reverseNumber(int number) {
		
		
		//int remainder = number % 10;
		//number = number/10;
		int reversedNumber = 0;
		int backNumber = number;
		
		while(backNumber > reversedNumber) {
			int remainder = number % 10;
			number = number/10;
			
			reversedNumber = (reversedNumber*10 + remainder);
			//System.out.println("remainder "+ remainder);
			//System.out.println("number "+ number);
			//System.out.println("reversedNumber "+ reversedNumber);
			

		}
		return reversedNumber;
		
	}

}


 
