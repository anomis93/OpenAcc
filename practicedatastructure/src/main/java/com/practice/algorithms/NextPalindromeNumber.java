package com.practice.algorithms;

/**
 * Created by chakrabo on 8/25/2018.
 */
public class NextPalindromeNumber {

    public static void main(String []args) { //Time complexity O(n)

        String input = "444333"; //2346432
        int length = input.length();

        int pointer1;
        int pointer2;
        boolean isEven = false;
        boolean isAllNine = true;
        boolean isfirstGreater = false;

        if (length%2 ==0){
            pointer1 = length/2-1;
            pointer2 = pointer1+1;
            isEven = true;
        } else {
            pointer1 = length/2;
            pointer2 = pointer1;
        }

        while (pointer1 > 0 || pointer2 < length) { // O(n/2)
            String value1 = input.charAt(pointer1) + "";
            String value2 = input.charAt(pointer2) + "";

            if (value1.equals(value2)) {
                if (value1.compareTo("9")!=0 || value2.compareTo("9")!=0)
                    isAllNine = false;
                pointer1--;
                pointer2++;
            } else {
                isAllNine = false;
                if (value1.compareTo(value2) > 0) {
                    isfirstGreater = true;
                }
                break;
            }
        }

        if (isAllNine) {
            String value = "1";
            for (int i=1; i<length; i++)
                value += "0";
            value += "1";
            System.out.println("next palindrome value : " + value);
        } else {
            String revValue = "";
            for (int i=length/2-1; i>=0; i--) //O(n/2)
                revValue += input.charAt(i)+"";

            if (isEven) {
                if (isfirstGreater) {
                    System.out.println("next palindrome value : " + input.substring(0, length/2)+revValue);
                } else {
                    int centerValue = Integer.parseInt(input.charAt(length/2-1)+"");
                    centerValue++;
                    System.out.println("next palindrome value : " + input.substring(0, length/2-1)+centerValue+centerValue+revValue.substring(1));
                }
            } else {
                if (isfirstGreater) {
                    System.out.println("next palindrome value : " + input.substring(0, length/2)+input.charAt(length/2)+revValue);
                } else {
                    int centerValue = Integer.parseInt(input.charAt(length/2)+"");
                    centerValue++;
                    System.out.println("next palindrome value : " + input.substring(0, length/2)+centerValue+revValue);
                }
            }
        }

    }
}
