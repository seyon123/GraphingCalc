package com.graphing.calc;

import java.awt.*;
import java.awt.geom.GeneralPath;
import javax.swing.*;

public class GraphCanvas extends JComponent {
    public GraphCanvas() {

    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        int xPoints[] = {0, 100, 0, 100};
        int yPoints[] = {0, 50, 0, 50};
        GeneralPath poly = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
        poly.moveTo(xPoints[0], yPoints[0]);
        for (int i = 1; i < xPoints.length; i++) {
            poly.lineTo(xPoints[i], yPoints[i]);
        }
        g2.draw(poly);
    }
}
