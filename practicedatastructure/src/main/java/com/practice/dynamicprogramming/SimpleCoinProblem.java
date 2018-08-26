package com.practice.dynamicprogramming;

/**
 * Created by chakrabo on 8/25/2018.
 */
public class SimpleCoinProblem {

    public static void main(String []arg) {
        int []coins = {9,6,5,1}; //11
        int V = 11;

//        int res = minCoins(coins, coins.length, V);
        int res2 = minCoinsDynamic(coins, coins.length, V);
//        System.out.println("output is  : " +res);
        System.out.println("Output 2 is : " +res2);

    }
    //Using brute force
    public static int minCoins(int coins[], int m, int V) {
        if (V==0) return 0;

        int res = Integer.MAX_VALUE;

        for (int i=0 ; i<m; i++) {
            if (coins[i] <= V) {
                int sub_res = minCoins(coins, m, V-coins[i]);

                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
                    res = sub_res + 1;
                }
            }
        }
        return res;
    }
    //Dynamic programming
    public static int minCoinsDynamic(int []coins, int m, int V) {
        int table [] = new int[V+1];
        table[0] = 0;
        //Initializing table from 1 to V with max value
        for (int i=1; i<=V; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for (int i=1; i<=V; i++) {
            for (int j=0; j<m; j++) {
                if(coins[j] <= i) {
                    int sub_res = table[i-coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res+1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[V];
    }
}
