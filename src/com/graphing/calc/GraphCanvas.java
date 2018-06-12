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

        int count = 0;
        for(int i = 0; i < count; i++){
            if((graph.getyPoints(i) > 0 && graph.getyPoints(i) < graph.getHeight()) && (graph.gety2Points(i) > 0 && graph.gety2Points(i) < graph.getHeight())){
                g.drawLine(i, graph.getyPoints(i), i - 1, graph.gety2Points(i));
            }
        }
    }
}
