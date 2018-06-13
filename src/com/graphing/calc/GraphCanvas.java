package com.graphing.calc;

import java.awt.*;
import javax.swing.*;

public class GraphCanvas extends JPanel {

    private Exponential expo = new Exponential();
    private Polynomial poly = new Polynomial();
    private Logarithmic log = new Logarithmic();
    private String parentFunction;
    private int coef1, coef2, coef3, coef4, coef5, base;

    public GraphCanvas() {
        repaint();
    }

    // constructor for exponential function
    public GraphCanvas(String function, String b) {
        parentFunction = function;
        base = Integer.parseInt(b);
        repaint();
    }

    // constructor for linear function
    public GraphCanvas(String function, String c1, String c2) {
        parentFunction = function;
        coef1 = Integer.parseInt(c1);
        coef2 = Integer.parseInt(c2);
        repaint();
    }

    // constructor for quadratic function
    public GraphCanvas(String function, String c1, String c2, String c3) {
        parentFunction = function;
        coef1 = Integer.parseInt(c1);
        coef2 = Integer.parseInt(c2);
        coef3 = Integer.parseInt(c3);
        repaint();
    }

    // constructor for logarithmic function
    public GraphCanvas(String function, String c1, String c2, String c3, String c4, String c5) {
        parentFunction = function;
        coef1 = Integer.parseInt(c1);
        coef2 = Integer.parseInt(c2);
        coef3 = Integer.parseInt(c3);
        coef4 = Integer.parseInt(c4);
        coef5 = Integer.parseInt(c5);
        repaint();
    }

    // generate graph and grid
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Linear Function
        if(parentFunction.equals("Linear")) {
            poly.drawGrid(g); // generate grid
            g.setColor(Color.red); //set line color to red
            poly.plotPoints(coef1, coef2); // calculate points on the graph
            // draw graph onto the grid
            for (int i = 0; i < poly.getWidth(); i++) {
                if ((poly.getyPoints(i) > 0 && poly.getyPoints(i) < poly.getHeight()) && (poly.gety2Points(i) > 0 && poly.gety2Points(i) < poly.getHeight())) {
                    g.drawLine(i, poly.getyPoints(i), i - 1, poly.gety2Points(i));
                }
            }
        }

        // Quadratic Function
        else if(parentFunction.equals("Quadratic")) {
            poly.drawGrid(g); // draw grid
            g.setColor(Color.red); // set line color to red
            poly.plotPoints(coef1, coef2, coef3); // calculate points on the graph
            // draw graph onto the grid
            for (int i = 0; i < poly.getWidth(); i++) {
                if ((poly.getyPoints(i) > 0 && poly.getyPoints(i) < poly.getHeight()) && (poly.gety2Points(i) > 0 && poly.gety2Points(i) < poly.getHeight())) {
                    g.drawLine(i, poly.getyPoints(i), i - 1, poly.gety2Points(i));
                }
            }
        }

        // Exponential Function
        else if(parentFunction.equals("Exponential")) {
            expo.drawGrid(g); // draw grid
            g.setColor(Color.red); // set line color to red
            expo.plotPoints(base); // calculate points on the graph
            // draw graph onto the grid
            for (int i = 0; i < expo.getWidth(); i++) {
                if ((expo.getyPoints(i) > 0 && expo.getyPoints(i) < expo.getHeight()) && (expo.gety2Points(i) > 0 && expo.gety2Points(i) < expo.getHeight())) {
                    g.drawLine(i, expo.getyPoints(i), i - 1, expo.gety2Points(i));
                }
            }
        }

        // Logarithmic Function
        else if(parentFunction.equals("Logarithmic")) {
            log.drawGrid(g); // draw grid
            g.setColor(Color.red); // set line color to red
            log.plotPoints(coef1, coef2, coef3, coef4, coef5); // calculate points on the graph
            // draw graph onto the grid
            for (int i = 0; i < log.getWidth(); i++) {
                if ((log.getyPoints(i) > 0 && log.getyPoints(i) < log.getHeight()) && (log.gety2Points(i) > 0 && log.gety2Points(i) < log.getHeight())) {
                    g.drawLine(i, log.getyPoints(i), i - 1, log.gety2Points(i));
                }
            }
        }
    }
}
