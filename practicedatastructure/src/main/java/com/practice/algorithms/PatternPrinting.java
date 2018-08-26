package com.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chakrabo on 8/25/2018.
 */
//4444444
//4333334
//4322234
//4321234
//4322234
//4333334
//4444444
public class PatternPrinting {

    public static void main(String []arg) {

        int n = 4;
        int substractedValue = 0;
        int value = (n/2+n+1);
        int loopCount = value * value;

        Map<Integer, Integer> boundary = new HashMap<Integer, Integer>();
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        boundary.put(0, n);

        int j = 0;
        for (int i=0; i<loopCount; i++) {
            if (i == value) {
                System.out.println();
                j = 0;

            } else {
                System.out.print(boundary.get(substractedValue));
                j++;
            }
        }
    }
}
