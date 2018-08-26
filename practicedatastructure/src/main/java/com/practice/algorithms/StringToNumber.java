package com.practice.algorithms;
public class StringToNumber {

	public static void main(String[] args) {
		String str = "2147483648";
		int res = 0;
		char firstChar = '\0';
		int i=0;
		for(; i<str.length(); i++) {
			firstChar = str.charAt(i);
			int asciiVal = (int)firstChar;
			if((asciiVal >= 48 && asciiVal <=57) || asciiVal==43 || asciiVal==45) {
				break;
			}
		}
		if(firstChar == '-' || firstChar == '+')
			i++;
		str = str.substring(i, str.length());
		
		boolean isOverflow = false;
		int bakRes = 0;
		for(int index = 0; index < str.length() ; index++) {
			int asciiVal = (int)str.charAt(index);
			if(asciiVal < 48 || asciiVal > 57) {
				break;
			} else {
				int temp = asciiVal - 48;
				res = res *10 + temp;
				int temp3 = res-temp;
				System.out.println(res+","+temp+" ## "+temp3);
				int temp2 = (res-temp)/10;
				System.out.println(temp2);
				if (bakRes != temp2) {
					isOverflow = true;
					break;
				}
				bakRes = res;
			}
		}
		if(firstChar == '-' && isOverflow) {
			res =-2147483648;
		}else if(firstChar == '-') {
			res = res * -1;
		}else if(isOverflow) {
			res = 2147483647;
		}
		System.out.println(res);
	}

}
