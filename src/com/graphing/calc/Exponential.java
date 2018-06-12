package com.graphing.calc;

public class Exponential extends Equations {

    private int spacing, height, width, hMidpoint, vMidpoint;
    private int[] yPoints, y2Points;

    public Exponential(int b) {
        super(0, 0, 0, 0, b);
        spacing = 50;
        width = 400;
        height = 325;
        yPoints = new int[400];
        y2Points = new int[400];
    }

    public Exponential(int spaces, int high, int wide){
        spacing = spaces;
        height = high;
        width = wide;
    }

    public void plotPoints(double a){
        //graphs in exponential form
        for(int i = 0;i < width;i++){
            //finds the relative x coordinate based on the origin and spacing of the graph
            double x = (i - hMidpoint)/(double)spacing;
            double x2 = x - 1/(double)spacing;
            double xChange = Math.pow(a, x);
            double x2Change = Math.pow(a, x2);
            //checks if the number is valid and then changes the coordinates back to terms of the graph
            if(!Double.isNaN(xChange) && !Double.isNaN(x2Change) && !Double.isInfinite(x2Change) && !Double.isInfinite(xChange)){
                int y = -(int)(xChange*spacing) + vMidpoint;
                int y2 = -(int)(x2Change*spacing) + vMidpoint;
                yPoints[i] = y;
                y2Points[i] = y2;
            }
        }
    }
}
