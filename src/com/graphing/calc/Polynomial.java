package com.graphing.calc;

public class Polynomial extends Equations {

    public Polynomial(int c1, int c2, int c3, int c4) {
        super(c1, c2, c3, c4, 0);
    }

    public Polynomial() {

    }

    public int highestDegree() {
        return 3;
    }

    public String Symmetry() {
        return "neither";
    }


    public String toString() {
        return super.toString();
    }
}
