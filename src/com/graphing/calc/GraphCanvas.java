package com.graphing.calc;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GraphCanvas extends JComponent {
    public GraphCanvas() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0,0,getWidth(),getHeight());

        int points [][] = new int [2][5];
        points[0][0] = 0;
        points[1][0] = 0;
        points[0][1] = 50;
        points[1][1] = 50;
        points[0][2] = 100;
        points[1][2] = 0;
        points[0][3] = 150;
        points[1][3] = 50;
        points[0][4] = 200;
        points[1][4] = 0;
        //int points [][] = {{0, 0}, {50, 50}, {100, 0}, {150, 50}, {200, 0}};
        //int xPoints[] = {0, 50, 100, 150, 200};
        //int yPoints[] = {0, 50, 0, 50, 0};
        GeneralPath poly = new GeneralPath(GeneralPath.WIND_EVEN_ODD, points[0].length);
        poly.moveTo(points[0][0], points[1][0]);
        for (int i = 1; i < points[0].length; i++) {
            poly.lineTo(points[0][i], points[1][i]);
        }
        g2.setColor(Color.BLACK);
        g2.draw(poly);
    }
}
