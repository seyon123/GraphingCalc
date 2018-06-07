package com.graphing.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;


public class GraphingCalc extends JFrame {

    private JPanel mainPanel;
    private JButton submitButton, infobtn;
    private JComboBox  chooseFunction;

    public static void main (String [] args) {
        new GraphingCalc();
    }

    public GraphingCalc(){

        JLabel label1 = new JLabel("Choose Function Type:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        ImageIcon infoimg = new ImageIcon("info-button.png");
        infobtn = new JButton(infoimg);
        infobtn.setAlignmentX(LEFT_ALIGNMENT);

        String[] functionList = {"-- None --", "Polynomial", "Exponential",  "Logarithmic",};
        chooseFunction = new JComboBox(functionList);
        chooseFunction.addActionListener(new ButtonListener());
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(chooseFunction.getPreferredSize());

        submitButton = new JButton("Enter");
        submitButton.addActionListener(new ButtonListener());
        submitButton.setMaximumSize(new Dimension(100, 30));
        submitButton.setAlignmentX(CENTER_ALIGNMENT);

        JLabel label2 = new JLabel("Created By: Seyon Rajagopal and Jacky Ly");
        label2.setOpaque(true);
        label2.setBackground(Color.WHITE);;
        label2.setAlignmentY(BOTTOM_ALIGNMENT);
        label2.setAlignmentX(CENTER_ALIGNMENT);

        mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(infobtn);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 220)));
        mainPanel.add(label1);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(chooseFunction);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(submitButton);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 220)));
        mainPanel.add(label2);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        add(mainPanel);
        setLayout(new FlowLayout());
        setTitle("Graphing Calculator");
        setSize(820,600);
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
            if(e.getSource() == submitButton ){
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
            if (e.getSource() == infobtn) {
                mainPanel.setVisible(false);
            }
    }
}
