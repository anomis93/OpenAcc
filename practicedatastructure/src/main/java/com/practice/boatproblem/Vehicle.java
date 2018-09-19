package com.practice.boatproblem;

/**
 * Created by chakrabo on 9/19/2018.
 */
public abstract class Vehicle {

    protected int x;
    protected int y;

    protected String direction;
    protected int noOfStepsToMove;

    public abstract void moveFront();

    public abstract void moveBack();

    public abstract void turnRight();

    public abstract void turnLeft();

}
