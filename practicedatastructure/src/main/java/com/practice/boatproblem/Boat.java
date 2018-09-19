package com.practice.boatproblem;

/**
 * Created by chakrabo on 9/19/2018.
 */
public class Boat extends Vehicle {


    public Boat(int x, int y, String direction, int noOfStepsToMove) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.noOfStepsToMove = noOfStepsToMove;
    }

    public void moveFront() {
        if (direction.equals("N")) {
            y += noOfStepsToMove;
        } else if (direction.equals("S")) {
            y -= noOfStepsToMove;
        } else if (direction.equals("E")) {
            x += noOfStepsToMove;
        } else {
            x -= noOfStepsToMove;
        }
    }

    public void moveBack() {
        if (direction.equals("N")) {
            y -= noOfStepsToMove;
        } else if (direction.equals("S")) {
            y += noOfStepsToMove;
        } else if (direction.equals("E")) {
            x -= noOfStepsToMove;
        } else {
            x += noOfStepsToMove;
        }
    }

    public void turnRight() {
        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("S")) {
            direction = "W";
        } else if (direction.equals("E")) {
            direction = "S";
        } else {
            direction = "N";
        }
    }

    public void turnLeft() {
        if (direction.equals("N")) {
            direction = "W";
        } else if (direction.equals("S")) {
            direction = "E";
        } else if (direction.equals("E")) {
            direction = "N";
        } else {
            direction = "S";
        }
    }

    public String getCurrentLocation() {
        return x+","+y;
    }

    public void moves(char[] movements) {
        for (char c : movements) {
            if(c == 'f') {
                moveFront();
            } else if (c == 'b') {
                moveBack();
            } else if (c == 'l') {
                turnLeft();
            } else {
                turnRight();
            }
        }
    }
}
