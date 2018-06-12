package com.graphing.calc;

public class Polynomial extends Equations {

    private int spacing, height, width, hMidpoint, vMidpoint;
    private int[] yPoints = new int [815];
    private int[] y2Points = new int [815];

    public Polynomial(int c1, int c2, int c3, int c4) {
        super(c1, c2, c3, c4, 0);
    }

    public Polynomial (){
        //default dimensions
        spacing = 40;
        height = 325;
        width = 815;
    }

    public Polynomial(int spaces, int high, int wide){
        spacing = spaces;
        height = high;
        width = wide;
    }

    public void plotPoints(double a, double b){
        //graphs in slope y intercept form
        for(int i = 0;i < width;i++){
            //finds the relative x coordinate based on the origin and spacing of the graph
            double x = (i - hMidpoint)/(double)spacing;
            double x2 = x - 1/(double)spacing;
            //transformations
            double xChange = a*x + b;
            double x2Change = a*x2 + b;
            //checks if the number is valid and then changes the coorinates back to terms of the graph
            if(!Double.isNaN(xChange) && !Double.isNaN(x2Change) && !Double.isInfinite(x2Change) && !Double.isInfinite(xChange)){
                int y = -(int)(xChange*spacing) + vMidpoint;
                int y2 = -(int)(x2Change*spacing) + vMidpoint;
                yPoints[i] = y;
                y2Points[i] = y2;
            }
        }
    }

    public void plotPoints(double a, double b, double c){
        //graphs in quadratic vertex form
        for(int i = 0;i < width;i++){
            //finds the relative x coordinate based on the origin and spacing of the graph
            double x = (i - hMidpoint)/(double)spacing;
            double x2 = x - 1/(double)spacing;
            double xChange = a*Math.pow(x - b, 2) + c;
            double x2Change = a*Math.pow(x2 - b, 2) + c;
            //checks if the number is valid and then changes the coorinates back to terms of the graph
            if(!Double.isNaN(xChange) && !Double.isNaN(x2Change) && !Double.isInfinite(x2Change) && !Double.isInfinite(xChange)){
                int y = -(int)(xChange*spacing) + vMidpoint;
                int y2 = -(int)(x2Change*spacing) + vMidpoint;
                yPoints[i] = y;
                y2Points[i] = y2;
            }
        }
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
