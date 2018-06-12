package com.graphing.calc;

import java.awt.*;
import javax.swing.*;

public class GraphCanvas extends JPanel {

    private GraphLayout graph = new GraphLayout();

    public GraphCanvas() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.drawGrid(g);
        g.setColor(Color.red);
    }
}
