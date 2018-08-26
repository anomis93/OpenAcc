package com.practice.algorithms;
//public class ReverseNumber {
//
//	public static void main(String[] args) {	
//		int x = 120;
//		int bak = x;
//		int rev = 0;
//		
//		if(x < 0)
//			x = x*-1;
//		
//		while(x > 0) {
//			int rem = x%10;
//			rev = rev *10 +rem;
//			x = x/10;
//		}
//        if(bak <0)
//            rev = rev*-1;
//		if(rev < bak)
//			System.out.println(0);
//		else
//			System.out.println(rev);
//	}
//
//}

public class ReverseNumber {
	public static void main(String []arg) {
		int res=testStrToInt();
		System.out.println(res);
	}
	
	public static int testStrToInt() {
		String str = "2147483648";
		int res = 0;
		int i=0;
		int multiplier = 1;
		int bak=0;
        boolean isNoSeen = false;
        boolean isPlusMinusSeen = false;
        boolean overflow=false;
		
		for(; i<str.length(); i++) {
            char c = str.charAt(i);
			int asciiVal = (int)c;
            if (asciiVal >=48 && asciiVal <=57) {
                isNoSeen = true;
			    int temp = asciiVal - 48;
                bak = bak *10;
                bak = bak /10;
                if (bak != res) {
                    overflow = true;
                    break;
                }
			    res = res*10 +temp;
                bak = res;
            } else{
                if (isNoSeen)
                    break;
                else {
                	 if (asciiVal!=32 && c!='-' && c!='+') {
                         return 0;
                     } else
                    if(isPlusMinusSeen && (c=='-' || c=='+'))
                        return 0;
                    else if(c=='-') {
                        multiplier = -1;
                        isPlusMinusSeen = true;
                    } else if(c=='+')
                        isPlusMinusSeen = true; 
                }
             
            }
		}
		if (overflow && multiplier ==1)
			return Integer.MAX_VALUE;
		else if (overflow && multiplier ==-1)
            return Integer.MIN_VALUE;
		res = res*multiplier;
	
        return res;
	}
}
