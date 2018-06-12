package com.graphing.calc;

public class Logarithmic extends Equations {

    private int spacing, height, width, hMidpoint, vMidpoint;
    private int[] yPoints, y2Points;

    public Logarithmic(int c1, int b) {
        super(c1, 0, 0, 0, b);
    }

    public Logarithmic(int spaces, int high, int wide){
        spacing = spaces;
        height = high;
        width = wide;
    }

    public void plotPoints(double a, double b, double c, double d, double e){
        //graphs a logarithmic function
        for(int i = 0;i < width;i++){
            //finds the relative x coordinate based on the origin and spacing of the graph
            double x = (i - hMidpoint)/(double)spacing;
            double x2 = x - 1/(double)spacing;
            double xChange = a*((Math.log(c*(x+d)))/(Math.log(b))) + e;
            double x2Change = a*((Math.log(c*(x2+d)))/(Math.log(b))) + e;
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
