package com.practice.algorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberToString {
	
	public static void main(String []arg) {
		int number = 10300;
		String []list1 = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
				"ten","eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String []list2 = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		
		int divisor = 1;
		int count = 0;
		for(int bakNumber = number; bakNumber/10 > 0; bakNumber = bakNumber/10) {
			divisor *= 10;
			count++;
		}
		System.out.println(number/divisor + ", "+count);
		String result = "";
		
		int temp = 0;
		if(number/100000 > 0) {
			temp = number/100000;
			result += list1[temp-1] +" lakh ";
			number = number % 100000;
		} 
		if (number /1000 > 0) {
			temp = number/1000;
			if (temp <20)
				result += list1[temp-1];
			else {
				result += list2[(temp/10)-2];
				if (temp %10 > 0)
					result += " "+list1[(temp%10)-1];
			}
			result += " thousand ";
			number = number % 1000;
		}
		if (number /100 > 0) {
			temp = number/100;
			result += list1[temp-1] + " hundred ";
			number = number%100;
		}
		if (number>20) {
			result += list2[(number/10)-2]+" ";
			if (number %10 >0) {
				result += list1[(number%10)-1]+" ";
			}
		} else if (number > 0){
			result += list1[number-1]+" ";
		}
		
		System.out.println(result);
	}

}
