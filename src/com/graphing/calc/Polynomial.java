package com.graphing.calc;

import java.awt.*;

public class Polynomial extends Equations {

    private int spacing, height, width, hMidpoint, vMidpoint;
    private int[] yPoints = new int [2000];
    private int[] y2Points = new int [2000];

    public Polynomial(int c1, int c2, int c3, int c4) {
        super(c1, c2, c3, c4, 0);
    }

    public Polynomial (){
        //default dimensions
        spacing = 30;
        height = 325;
        width = 815;
    }

    public Polynomial(int spaces, int high, int wide){
        spacing = spaces;
        height = high;
        width = wide;
    }

    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
    public int getyPoints(int i){
        return yPoints[i];
    }
    public int gety2Points(int i){
        return y2Points[i];
    }

    public void setHeight(int heightin){
        if(heightin > 0){
            height = heightin;
        }
    }
    public void setSpacing(int spacingin){
        if(spacingin > 20){
            spacing = spacingin;
        }
    }
    public void setWidth(int widthin){
        if(widthin > 0){
            width = widthin;
        }
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


    public void drawGrid(Graphics g){
        //determines necessary amount of lines
        int vlines = width/spacing;
        int hlines = height/spacing;
        if (vlines % 2 != 0){
            vlines++;
        }
        if (hlines % 2 != 0){
            hlines++;
        }
        int hcount = 0, vcount = 0, i;
        for(i = 0;i < height;i = i+spacing){
            //draws horizontal line
            g.drawLine(0, i, width, i);
            g.drawString(Integer.toString(-(hcount - hlines/2)), width/2 + 10, i);
            if(hlines == hcount*2){
                //if the line is in the middle then make it appear thicker as an axis
                vMidpoint = i;
                g.drawLine(0, i+1, width, i+1);
                g.drawLine(0, i-1, width, i-1);
            }
            hcount++;
        }
        for(i = 0;i < width;i = i+spacing){
            //draws vertical line
            g.drawLine(i, 0, i, height);
            g.drawString(Integer.toString(vcount - vlines/2), i, height/2 + 20);
            if(vlines == vcount*2){
                //if the line is in the middle make it appear thicker as an axis
                hMidpoint = i;
                g.drawLine(i+1, 0, i+1, height);
                g.drawLine(i-1, 0, i-1, height);
            }
            vcount++;
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
