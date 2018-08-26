package com.practice.algorithms;

public class FindNOBinarySearch
{
	static int [] n = {8, 9, 10, 11, 1, 2, 3,5,7};
//	static int [] n = {18,19,20, 3, 5, 7, 8, 10, 11};
	static int val = 10;
	
    public static void main(String[]args)
    {
    	int finalValue = -1;
    	int pivot = getPivot(0, n.length-1);
    	System.out.println(pivot);
    	if (val >= n[pivot] && val <= n[n.length-1]) {
    		finalValue = getValue(pivot, n.length-1);
    	} else {
    		finalValue = getValue(0, pivot-1);
    	}
    	System.out.println(finalValue);
    }
    
    public static int getPivot(int i, int j) {
    	int mid = (i+j)/2;
    	System.out.println(i+","+mid+","+j+"#"+n[i]+","+n[mid]+","+n[j]);
    	if (i > j) {
    		return -1;
    	} else if (n[mid] > n[mid+1]) {
    		return mid+1;
    	} else if (n[i] < n[mid] && n[mid] > n[j]) {
    		return getPivot(mid+1, j);
    	} else {
    		return getPivot(i, mid);
    	}
   }
    
   public static int getValue(int i, int j) {
	   int mid = (i+j)/2;
	   System.out.println(i+","+mid+","+j+"#"+n[i]+","+n[mid]+","+n[j]);
	   if (i > j) {
		   return -1;
	   } else if (n[i] == val) {
		   return i;
	   } else if (n[j] == val) {
		   return j;
	   } else if (val <= n[mid]) {
		   return getValue(i, mid);
	   } else {
		   return getValue(mid+1, j);
	   }
   }
}

