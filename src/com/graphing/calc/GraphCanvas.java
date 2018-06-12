package com.graphing.calc;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import javax.swing.*;

public class GraphCanvas extends JPanel {

    private GraphLayout graph = new GraphLayout();
    private Polynomial poly = new Polynomial();
    private String parentFunction;
    private int coef1, coef2;

    public GraphCanvas() {
        repaint();
    }

    public GraphCanvas(String function, String c1, String c2) {
        parentFunction = function;
        coef1 = Integer.parseInt(c1);
        coef2 = Integer.parseInt(c2);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.drawGrid(g);
        g.setColor(Color.red);
        if(parentFunction.equals("Linear")) {
            poly.plotPoints(coef1, coef2);
            for (int i = 0; i < poly.getWidth(); i++) {
                if ((poly.getyPoints(i) > 0 && poly.getyPoints(i) < poly.getHeight()) && (poly.gety2Points(i) > 0 && poly.gety2Points(i) < poly.getHeight())) {
                    g.drawLine(i, poly.getyPoints(i), i - 1, poly.gety2Points(i));
                }
            }
        }
    }
}
