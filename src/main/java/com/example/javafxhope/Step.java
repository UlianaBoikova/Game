package com.example.javafxhope;

/**
 This class helps to use x, y coordinate
 */
public class Step {
    private int x;
    private int y;

    /**
     Controller of x-y coordinates
     @param x x-coordinate
     @param y y-coordinate
     */
    public Step(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     Gets x-coordinate.
     @return x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     Gets y-coordinate.
     @return y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     Sets x-coordinate.
     @param x x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     Sets y-coordinate.
     @param y y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     Returns Step as (x, y)
     @return "(x, y)"
     */
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}
