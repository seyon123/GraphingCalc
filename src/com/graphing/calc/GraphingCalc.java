package com.graphing.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class GraphingCalc extends JFrame {

    private GraphCanvas canvas;
    private JLabel label1,label2;
    private JPanel mainPanel, northPanel, southPanel;
    private JButton submitButton, infoBtn, rtnBtn;
    private JComboBox  chooseFunction;
    private ImageIcon infoImg, returnImg;

    public static void main (String [] args) {
        new GraphingCalc();
    }

    public GraphingCalc(){
        label2 = new JLabel("Created By: Seyon Rajagopal and Jacky Ly ");
        label2.setOpaque(true);
        label2.setBackground(Color.WHITE);

        infoImg = new ImageIcon("info-button.png");
        infoBtn = new JButton(infoImg);
        infoBtn.addActionListener(new ButtonListener());
        infoBtn.setAlignmentX(RIGHT_ALIGNMENT);

        returnImg = new ImageIcon("rtnButton.png");
        rtnBtn = new JButton(returnImg);
        rtnBtn.addActionListener(new ButtonListener());

        northPanel = new JPanel(new BorderLayout());
        northPanel.add(infoBtn, BorderLayout.EAST);
        northPanel.setOpaque(false);

        southPanel = new JPanel(new BorderLayout());
        southPanel.add(label2,BorderLayout.EAST);
        southPanel.add(rtnBtn, BorderLayout.WEST);
        southPanel.setOpaque(false);

        mainScreen();

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

    public void mainScreen(){
        label1 = new JLabel("Choose Function Type:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        String[] functionList = {"-- None --", "Polynomial", "Exponential",  "Logarithmic",};
        chooseFunction = new JComboBox(functionList);
        chooseFunction.addActionListener(new ButtonListener());
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(chooseFunction.getPreferredSize());

        submitButton = new JButton("Enter");
        submitButton.addActionListener(new ButtonListener());
        submitButton.setMaximumSize(new Dimension(100, 30));
        submitButton.setAlignmentX(CENTER_ALIGNMENT);

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

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        setTitle("Graphing Calculator");
        setSize(835,600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void polynomialScreen(){

        canvas = new GraphCanvas();
        canvas.setSize(600, 200);
        canvas.setLocation(100, 100);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        add(canvas);
        setTitle("Graphing Calculator");
        setSize(835,600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void exponentialScreen(){

        canvas = new GraphCanvas();
        canvas.setSize(600, 200);
        canvas.setLocation(100, 100);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        add(canvas);
        setTitle("Graphing Calculator");
        setSize(835,600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void logarithmicScreen(){
        
        canvas = new GraphCanvas();
        canvas.setSize(600, 200);
        canvas.setLocation(100, 100);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        add(canvas);
        setTitle("Graphing Calculator");
        setSize(835,600);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton) {
                String function = (String) chooseFunction.getSelectedItem();
                if (function.equals("Polynomial")) {
                    polynomialScreen();
                } else if (function.equals("Exponential")) {
                    exponentialScreen();
                } else if (function.equals("Logarithmic")) {
                    logarithmicScreen();
                }
            }
            else if (e.getSource() == infoBtn) {
                Glossary dictionary = new Glossary();
                ImageIcon searchIcon = new ImageIcon("active-search.png");
                String searchValue = JOptionPane.showInputDialog(null, "Search for what you need help with:", "Glossary", JOptionPane.QUESTION_MESSAGE);
                searchValue = searchValue.toLowerCase();
                if (!searchValue.equals("") && dictionary.checkWord(searchValue))
                    JOptionPane.showMessageDialog(null, dictionary.defineWord(searchValue), "Definition: " + searchValue, JOptionPane.INFORMATION_MESSAGE, searchIcon);
                else
                    JOptionPane.showMessageDialog(null, "The word '" + searchValue + "' was not found in the dictionary!", "Graphing Calculator", JOptionPane.WARNING_MESSAGE, searchIcon);
            }
            else if(e.getSource() == rtnBtn){
                dispose();
                new GraphingCalc();
            }
        }
    }
}
