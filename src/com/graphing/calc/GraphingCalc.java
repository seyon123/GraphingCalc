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

        JLabel logo = new JLabel();
        ImageIcon img = new ImageIcon("GraphingCalculator-Banner.png");
        logo.setIcon(img);
        logo.setBounds(0, 0, 800, 200);
        logo.setAlignmentX(CENTER_ALIGNMENT);

        JLabel label1 = new JLabel("Choose a Function:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        String[] functionList = {"-- None --", "Polynomial", "Exponential",  "Logarithmic",};
        chooseFunction = new JComboBox(functionList);
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(chooseFunction.getPreferredSize());

        submitButton = new JButton("Submit");
        submitButton.setMaximumSize(new Dimension(100, 30));
        submitButton.setAlignmentX(CENTER_ALIGNMENT);

        JLabel label2 = new JLabel("Created By: Seyon Rajagopal and Jacky Ly");
        label2.setAlignmentX(LEFT_ALIGNMENT);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(logo);
        mainPanel.add(Box.createRigidArea(new Dimension(800, 20)));
        mainPanel.add(label1);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(chooseFunction);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(submitButton);
        mainPanel.add(Box.createRigidArea(new Dimension(800, 220)));
        mainPanel.add(label2);

        setContentPane(mainPanel);
        setTitle("Graphing Calculator");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //prompts the user whether they are sure before closing
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to exit?", "Graphing Calculator", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
