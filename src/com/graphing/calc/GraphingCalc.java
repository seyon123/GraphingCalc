package com.graphing.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GraphingCalc extends JFrame {

    private JPanel mainPanel;
    private JButton submitButton;
    private JComboBox  chooseFunction;

    public static void main (String [] args) {
        new GraphingCalc();
    }

    public GraphingCalc(){
        mainPanel = new JPanel();

        JLabel logo = new JLabel();
        ImageIcon img = new ImageIcon("GraphingCalculator-Banner.png");
        logo.setIcon(img);
        logo.setBounds(0, 0, 800, 200);
        logo.setAlignmentX(CENTER_ALIGNMENT);

        JLabel label1 = new JLabel("Choose a Function:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        String[] functionList = {"-- None --", "Polynomial", "Exponential",  "Logarithmic",};
        chooseFunction = new JComboBox(functionList);
        chooseFunction.addActionListener(new ButtonListener());
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(chooseFunction.getPreferredSize());

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ButtonListener());
        submitButton.setMaximumSize(new Dimension(100, 30));
        submitButton.setAlignmentX(CENTER_ALIGNMENT);

        JLabel label2 = new JLabel("Created By: Seyon Rajagopal and Jacky Ly");
        label2.setAlignmentY(BOTTOM_ALIGNMENT);

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
        setResizable(true);
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

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == chooseFunction ){
                String function = (String) chooseFunction.getSelectedItem();
                if (function.equals("Polynomial")){
                    mainPanel.setVisible(false);
                }
                else if(function.equals("Exponential")){
                    mainPanel.setVisible(false);
                }
                else if(function.equals("Logarithmic")){
                    mainPanel.setVisible(false);
                }
            }
        }
    }
}
