package com.graphing.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GraphingCalc extends JFrame {

    private JButton submitButton;
    private JComboBox  chooseFunction;

    public static void main (String [] args) {
        new GraphingCalc();
    }

    public GraphingCalc(){
        JPanel mainPanel = new JPanel();

        JLabel label1 = new JLabel("Choose a Function:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        String[] functionList = {"-- None --", "Polynomial", "Exponential",  "Logarithmic",};
        chooseFunction = new JComboBox(functionList);
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(chooseFunction.getPreferredSize());

        submitButton = new JButton("Submit");
        submitButton.setMaximumSize(new Dimension(100, 30));
        submitButton.setAlignmentX(CENTER_ALIGNMENT);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createRigidArea(new Dimension(800, 240)));
        mainPanel.add(label1);
        mainPanel.add(chooseFunction);
        mainPanel.add(submitButton);

        setContentPane(mainPanel);
        setTitle("Graphing Calculator");
        setSize(800,600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
