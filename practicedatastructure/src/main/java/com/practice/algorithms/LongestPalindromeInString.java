package com.practice.algorithms;

/**
 * Created by chakrabo on 8/25/2018.
 */
public class LongestPalindromeInString {
    public static void main(String arg[]){

        String str = "todayannnnabuygrapes";
        int length = str.length()-1;
        int ans = 0,left = 0,mid = 0,right = 0;

        if(length == 0)
            ans = 1;
        else if(length < 2){
            if(str.charAt(0) == str.charAt(1)){
                ans = 2;
            }
        }

        while(length >= 2){

            if(mid+1 > length)
                break;
            if((left < 0 || right > length) || (left >= 0 && right <= length && str.charAt(left) != str.charAt(right))){
                int temp = right - left - 2;
                if(temp > ans)
                    ans = temp;
                mid++;
                left = mid;
                right = mid;
            }
            if(left >= 0 && right <= length && str.charAt(left) == str.charAt(right)){
                right++;
                if(right <= length&&str.charAt(left) != str.charAt(right))
                    left--;

            }
        }
        System.out.println("MaxPalindromSize:"+(ans < 2 ?ans : ans + 1));
    }

}
