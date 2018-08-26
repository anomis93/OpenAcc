package com.practice.algorithms;

public class DynamicCopying {

	static int noOfSteps = 0;
	static int noOfChar=1;
	static int copyCount=0;
	public static void main(String []arg) {
		int res = minSteps(1);
		System.out.println(res);
	}
	
	public static int minSteps(int n) {
	       
        if(n > 0) {
            while(noOfChar <=n) {
                if(noOfChar+copyCount <= n){
                    copyCount = noOfChar;
                } else{
                    noOfChar += copyCount;
                }
           
                noOfSteps++;
            }
        }
        return noOfSteps;
    }
}
