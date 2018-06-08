package com.graphing.calc;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GraphCanvas extends Canvas {
    public GraphCanvas() {

    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g);

        int xPoints[] = {0, 100, 0, 100};
        int yPoints[] = {0, 50, 0, 50};
        GeneralPath poly = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
        poly.moveTo(xPoints[0], yPoints[0]);
        for (int i = 1; i < xPoints.length; i++) {
            poly.lineTo(xPoints[i], yPoints[i]);
        }
        g2.setColor(Color.BLACK);
        g2.draw(poly);
    }
}
