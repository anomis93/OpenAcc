package com.practice.boatproblem;

/**
 * Created by chakrabo on 9/19/2018.
 */
public class BoatProblem {

    static int noOfSteps = 1;
    public static void main(String arg[]) {

        char movements[] = {'f','r','b','b','l'};
        testBoatProblem(0,0,"S", movements);
    }

    public static void testBoatProblem(int x, int y, String direction, char[] movements) {
        Boat boat = new Boat(x, y, direction, noOfSteps);
        boat.moves(movements);
        System.out.println(boat.getCurrentLocation());
    }
}
