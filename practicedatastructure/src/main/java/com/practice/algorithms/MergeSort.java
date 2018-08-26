package com.practice.algorithms;

/**
 * Created by chakrabo on 8/25/2018.
 */
public class MergeSort {
    static int [] input = {4,7,3,10,5,2};
    public static void main(String arg[]) {
        int numberOfElement = input.length-1;
        int [] res = mergeSort(0, numberOfElement/2, numberOfElement);

        for (int i=0; i<res.length; i++)
            System.out.println(res[i]);
    }

    public static int[] mergeSort(int i, int mid, int j) {
        if (i==j) {
            int [] value = new int[1];
            value[0] = input[i];
            return value;
        } else {
            int temp = (i+mid)/2;
            int temp2 = (temp+1+j)/2;

            int val1[] = mergeSort(i, temp, mid);
            int val2[] = mergeSort(mid+1, temp2, j);
            return merge(val1, val2);
        }
    }

    public static int[] merge(int []arr1, int []arr2) {
        int [] mergeArray = new int[arr1.length+arr2.length];

        if (arr1.length < arr2.length) {
            int []temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        int insertCount = -1;
        for(int i=0; i<arr1.length;i++) {
            for(int j=0; j<arr2.length; j++) {
                if (arr1[i] == -1 || arr2[j] == -1)
                    continue;
                if (arr1[i] < arr2[j]){
                    mergeArray[++insertCount] = arr1[i];
                    arr1[i] = -1;
                } else {
                    mergeArray[++insertCount] = arr2[j];
                    arr2[j] = -1;
                }
            }
            if (arr1[i] > -1)
                mergeArray[++insertCount] = arr1[i];
            if (i == arr1.length-1 && arr2[arr2.length-1] > -1) {
                mergeArray[++insertCount] = arr2[arr2.length-1];
            }
        }

        return mergeArray;
    }
}
