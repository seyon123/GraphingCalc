package com.graphing.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class GraphingCalc extends JFrame {

    private GraphCanvas canvas;
    private JLabel label1;
    private JPanel mainPanel, polynomialPanel, exponentialPanel, logarithmicPanel;
    private JButton submitButton, infoBtn, rtnBtn;
    private JComboBox  chooseFunction;

    public static void main (String [] args) {
        new GraphingCalc();
    }

    public GraphingCalc(){

        label1 = new JLabel("Choose Function Type:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        JLabel label2 = new JLabel("Created By: Seyon Rajagopal and Jacky Ly ");
        label2.setOpaque(true);
        label2.setBackground(Color.WHITE);

        ImageIcon infoImg = new ImageIcon("info-button.png");
        infoBtn = new JButton(infoImg);
        infoBtn.addActionListener(new ButtonListener());
        infoBtn.setAlignmentX(RIGHT_ALIGNMENT);

        ImageIcon returnImg = new ImageIcon("rtnButton.png");
        rtnBtn = new JButton(returnImg);
        rtnBtn.addActionListener(new ButtonListener());

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(infoBtn, BorderLayout.EAST);
        northPanel.setOpaque(false);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(label2,BorderLayout.EAST);
        southPanel.add(rtnBtn, BorderLayout.WEST);
        southPanel.setOpaque(false);

        String[] functionList = {"-- None --", "Polynomial", "Exponential",  "Logarithmic",};
        chooseFunction = new JComboBox(functionList);
        chooseFunction.addActionListener(new ButtonListener());
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(chooseFunction.getPreferredSize());

        submitButton = new JButton("Enter");
        submitButton.addActionListener(new ButtonListener());
        submitButton.setMaximumSize(new Dimension(100, 30));
        submitButton.setAlignmentX(CENTER_ALIGNMENT);

        canvas = new GraphCanvas();
        canvas.setSize(600, 200);
        canvas.setLocation(100, 100);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 205)));
        mainPanel.add(label1);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(chooseFunction);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(submitButton);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 190)));
        mainPanel.add(southPanel);

//        polynomialPanel = new JPanel();
//        polynomialPanel.setLayout(new BoxLayout(polynomialPanel, BoxLayout.Y_AXIS));
//        polynomialPanel.setSize(820,600);
//        polynomialPanel.setBackground(new Color(0,0,0,0));
//        polynomialPanel.add(northPanel);
//        polynomialPanel.add(Box.createRigidArea(new Dimension(820, 205)));
//        polynomialPanel.add(southPanel);
//
//        exponentialPanel = new JPanel();
//        exponentialPanel.setLayout(new BoxLayout(exponentialPanel, BoxLayout.Y_AXIS));
//        exponentialPanel.setSize(820,600);
//        exponentialPanel.setBackground(new Color(0,0,0,0));
//        exponentialPanel.add(northPanel);
//        exponentialPanel.add(Box.createRigidArea(new Dimension(820, 205)));
//        exponentialPanel.add(southPanel);
//
//        logarithmicPanel = new JPanel();
//        logarithmicPanel.setLayout(new BoxLayout(logarithmicPanel, BoxLayout.Y_AXIS));
//        logarithmicPanel.setSize(820,600);
//        logarithmicPanel.setBackground(new Color(0,0,0,0));
//        logarithmicPanel.add(northPanel);
//        logarithmicPanel.add(Box.createRigidArea(new Dimension(820, 205)));
//        logarithmicPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        //add(canvas);
        setTitle("Graphing Calculator");
        setSize(835,600);
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
            if (e.getSource() == submitButton) {
                String function = (String) chooseFunction.getSelectedItem();
                if (function.equals("Polynomial")) {
                    label1.setVisible(false);
                    chooseFunction.setVisible(false);
                    submitButton.setVisible(false);
                } else if (function.equals("Exponential")) {
                    label1.setVisible(false);
                    chooseFunction.setVisible(false);
                    submitButton.setVisible(false);
                } else if (function.equals("Logarithmic")) {
                    label1.setVisible(false);
                    chooseFunction.setVisible(false);
                    submitButton.setVisible(false);
                }
            }
            else if (e.getSource() == infoBtn) {
                Glossary dictionary = new Glossary();
                String searchValue = JOptionPane.showInputDialog(null, "Search for what you need help with:", "Graphing Calculator", JOptionPane.INFORMATION_MESSAGE);
                searchValue = searchValue.toLowerCase();
                if (!searchValue.equals("") && dictionary.checkWord(searchValue))
                    JOptionPane.showMessageDialog(null, dictionary.defineWord(searchValue), "Graphing Calculator", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "The word '" + searchValue + "' was not found in the dictionary!", "Graphing Calculator", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(e.getSource() == rtnBtn){
                dispose();
                new GraphingCalc();
            }
        }
    }
}
