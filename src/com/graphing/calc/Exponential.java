package com.graphing.calc;

import java.awt.*;

public class Exponential extends Equations {

    private int spacing, height, width, hMidpoint, vMidpoint;
    private int[] yPoints = new int [2000];
    private int[] y2Points = new int [2000];

    public Exponential(int c1, int c2, int c3, int c4) {
        super(c1, c2, c3, c4, 0);
    }

    // set initial values
    public Exponential (){
        spacing = 30;
        height = 325;
        width = 815;
    }

    // constructor with values
    public Exponential(int spaces, int high, int wide){
        spacing = spaces;
        height = high;
        width = wide;
    }

    // get values
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

    // set values
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

    // calculate points
    public void plotPoints(double a){
        for(int i = 0;i < width; i++){
            //calculate x coordinate based spacing of graph
            double x = (i - hMidpoint)/(double)spacing;
            double x2 = x - 1/(double)spacing;
            double xChange = Math.pow(a, x);
            double x2Change = Math.pow(a, x2);

            // change coordinates in terms of the graph
            if(!Double.isNaN(xChange) && !Double.isNaN(x2Change) && !Double.isInfinite(x2Change) && !Double.isInfinite(xChange)){
                int y = -(int)(xChange*spacing) + vMidpoint;
                int y2 = -(int)(x2Change*spacing) + vMidpoint;
                yPoints[i] = y;
                y2Points[i] = y2;
            }
        }
    }

    // generate grid
    public void drawGrid(Graphics g){
        // calculate vertical and horizontal lines needed
        int vlines = width/spacing;
        int hlines = height/spacing;
        if (vlines % 2 != 0){
            vlines++;
        }
        if (hlines % 2 != 0){
            hlines++;
        }
        int hcount = 0, vcount = 0, i;
        for(i = 0; i < height; i = i + spacing){
            // horizontal line
            g.drawLine(0, i, width, i);
            g.drawString(Integer.toString(-(hcount - hlines/2)), width/2 + 10, i);
            // make middle line more visible
            if(hlines == hcount*2){
                vMidpoint = i;
                g.drawLine(0, i+1, width, i+1);
                g.drawLine(0, i-1, width, i-1);
            }
            hcount++;
        }
        for(i = 0;i < width;i = i+spacing){
            // vertical line
            g.drawLine(i, 0, i, height);
            g.drawString(Integer.toString(vcount - vlines/2), i, height/2 + 20);
            if(vlines == vcount*2){
                // make middle line more visible
                hMidpoint = i;
                g.drawLine(i+1, 0, i+1, height);
                g.drawLine(i-1, 0, i-1, height);
            }
            vcount++;
        }
    }

    public String toString() {
        return super.toString();
    }
}
