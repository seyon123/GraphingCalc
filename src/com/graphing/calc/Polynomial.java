package com.graphing.calc;

public class Polynomial extends Equations {

    private int coef1, coef2, coef3, coef4;

    public Polynomial(int c1, int c2, int c3, int c4) {
        coef1 = c1;
        coef2 = c2;
        coef3 = c3;
        coef4 = c4;
    }

    public Polynomial() {
        coef1 = 0;
        coef2 = 0;
        coef3 = 0;
        coef4 = 0;
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

}
