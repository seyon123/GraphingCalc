package com.graphing.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphingCalc extends JFrame {

    private GraphCanvas canvas;
    private JLabel label1,label2;
    private JPanel mainPanel, northPanel, southPanel, graphPanel;
    private JButton submitButton, infoBtn, rtnBtn;
    private JComboBox  chooseFunction;
    private ImageIcon infoImg, returnImg;

    private String coef1,coef2,coef3,coef4;

    public static void main (String [] args) {
        new GraphingCalc();
    }

    public GraphingCalc() {
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

        canvas = new GraphCanvas();
        canvas.setSize(600, 200);
        canvas.setLocation(100, 100);
        canvas.setPreferredSize(new Dimension(600, 200));

        graphPanel = new JPanel();
        graphPanel.setSize(780,420);
        graphPanel.setLayout(new GridLayout(1,2));
        graphPanel.setOpaque(true);
        //graphPanel.add(canvas);

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

    private void mainScreen(){
        label1 = new JLabel("Choose Function Type:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        String[] functionList = {"-- Select Function --", "Polynomial", "Exponential",  "Logarithmic",};
        chooseFunction = new JComboBox(functionList);
        chooseFunction.addActionListener(new ButtonListener());
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(new Dimension(200, 30));
        chooseFunction.setOpaque(false);
        chooseFunction.grabFocus();

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
        mainPanel.add(Box.createRigidArea(new Dimension(820, 10)));
        mainPanel.add(chooseFunction);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 10)));
        mainPanel.add(submitButton);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 200)));
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        setTitle("Graphing Calculator");
        setSize(830,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void polynomialScreen(){

        JTextField c1 = new JTextField(2);
        coef1 = c1.getText();
        JTextField c2 = new JTextField(2);
        coef2 = c2.getText();
        JTextField c3 = new JTextField(2);
        coef3 = c3.getText();
        JTextField c4 = new JTextField(2);
        coef4 = c4.getText();
        JPanel type = new JPanel();
        type.add(new JLabel("Polynomial Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = "));
        input.add(c1);
        input.add(new JLabel("x"+ "³" + " + "));
        input.add(c2);
        input.add(new JLabel("x"+ "²" + " + "));
        input.add(c3);
        input.add(new JLabel("x" + " + "));
        input.add(c4);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 90)));
        mainPanel.add(type);
        mainPanel.add(input);
        mainPanel.add(canvas);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 10)));
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        setTitle("Graphing Calculator");
        setSize(830,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void exponentialScreen(){

        JTextField b = new JTextField(2);
        JPanel type = new JPanel();
        type.add(new JLabel("Exponential Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = "));
        input.add(b);
        input.add(new JLabel("ˣ        ex. (bˣ)"));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 90)));
        mainPanel.add(type);
        mainPanel.add(input);
        mainPanel.add(canvas);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 10)));
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        setTitle("Graphing Calculator");
        setSize(830,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void logarithmicScreen(){


        JTextField c = new JTextField(2);
        JTextField b = new JTextField("10", 2);
        JTextField i = new JTextField(3);
        JPanel type = new JPanel();
        type.add(new JLabel("Logarithmic Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = "));
        input.add(c);
        input.add(new JLabel("log("));
        input.add(i);
        input.add(new JLabel("x)              "));
        input.add(new JLabel("Input Base: "));
        input.add(b);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 90)));
        mainPanel.add(type);
        mainPanel.add(input);
        mainPanel.add(canvas);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 10)));
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        setTitle("Graphing Calculator");
        setSize(830,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton) {
                String function = (String) chooseFunction.getSelectedItem();
                switch (function) {
                    case "Polynomial":
                        polynomialScreen();
                        break;
                    case "Exponential":
                        exponentialScreen();
                        break;
                    case "Logarithmic":
                        logarithmicScreen();
                        break;
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
