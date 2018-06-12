package com.graphing.calc;

public class Equations {
    protected int coef1, coef2, coef3, coef4, base;

    public Equations() {
        coef1 = 0;
        coef2 = 0;
        coef3 = 0;
        coef4 = 0;
        base = 0;
    }

    public Equations(int c1, int c2, int c3, int c4, int b) {
        coef1 = c1;
        coef2 = c2;
        coef3 = c3;
        coef4 = c4;
        base = b;

    }

    public void setCoef1(int c1) {
        coef1 = c1;
    }

    public void setCoef2(int c2) {
        coef2 = c2;
    }

    public void setCoef3(int c3) {
        coef3 = c3;
    }

    public void setCoef4(int c4) {
        coef4 = c4;
    }

    public void setBase(int b) {
        base = b;
    }

    public int getCoef1() {
        return coef1;
    }

    public int getCoef2() {

        return coef2;
    }

    public int getCoef3() {
        return coef3;
    }

    public int getCoef4() {
        return coef4;
    }

    public int getBase() {
        return base;
    }

    public String toString() {
        return "Coefficient 1: " + coef1 + "Coefficient 2: " + coef2 + "Coefficient 3: " + coef3 + "Coefficient 4: " + coef4 + "Base: " + base;
    }
}
