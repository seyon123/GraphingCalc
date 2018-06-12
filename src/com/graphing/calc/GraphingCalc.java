package com.graphing.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GraphingCalc extends JFrame {

    private GraphCanvas canvas;
    private JLabel label1,label2;
    private JPanel mainPanel, northPanel, southPanel, submitPanel;
    private JButton submitButton, infoBtn, rtnBtn, ftnSubmit;
    private JComboBox  chooseFunction;
    private ImageIcon infoImg, returnImg;

    private String searchValue, coef1, coef2, coef3, coef4, coef5;

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

        ftnSubmit = new JButton("Submit");
        ftnSubmit.addActionListener(new ButtonListener());

        submitPanel = new JPanel();
        submitPanel.add(ftnSubmit);

        northPanel = new JPanel(new BorderLayout());
        northPanel.add(infoBtn, BorderLayout.EAST);
        northPanel.setOpaque(false);

        southPanel = new JPanel(new BorderLayout());
        southPanel.add(label2,BorderLayout.EAST);
        southPanel.add(rtnBtn, BorderLayout.WEST);
        southPanel.setOpaque(true);

        canvas = new GraphCanvas();
        canvas.setSize(400, 300);
        canvas.setPreferredSize(new Dimension(400, 300));

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

    public static void main(String[] args) {
        new GraphingCalc();
    }

    private void mainScreen(){
        label1 = new JLabel("Choose Function Type:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        String[] functionList = {"-- Select Function --", "Polynomial", "Exponential",  "Logarithmic",};
        chooseFunction = new JComboBox<>(functionList);
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
        mainPanel.add(Box.createRigidArea(new Dimension(820, 210)));
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        setTitle("Graphing Calculator");
        setSize(825,600);
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
        input.add(new JLabel("f(x) = ax^3 + bx^2 + cx + d"));
        JPanel coefs = new JPanel();
        coefs.add(new JLabel("a"));
        coefs.add(c1);
        coefs.add(new JLabel("b"));
        coefs.add(c2);
        coefs.add(new JLabel("c"));
        coefs.add(c3);
        coefs.add(new JLabel("d"));
        coefs.add(c4);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 90)));
        mainPanel.add(type);
        mainPanel.add(input);
        mainPanel.add(submitPanel);
        mainPanel.add(canvas);
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
        input.add(new JLabel("f(x) = a^x"));
        JPanel coefs = new JPanel();
        coefs.add(new JLabel("a"));
        coefs.add(b);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 90)));
        mainPanel.add(type);
        mainPanel.add(input);
        mainPanel.add(coefs);
        mainPanel.add(submitPanel);
        mainPanel.add(canvas);
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

        JTextField c1 = new JTextField(2);
        coef1 = c1.getText();
        JTextField c2 = new JTextField(2);
        coef2 = c2.getText();
        JTextField c3 = new JTextField(2);
        coef3 = c3.getText();
        JTextField c4 = new JTextField(2);
        coef4 = c4.getText();
        JTextField c5 = new JTextField(2);
        coef5 = c5.getText();
        JTextField bs = new JTextField("10", 2);
        JPanel type = new JPanel();
        type.add(new JLabel("Logarithmic Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = a(log b(c(x + d)))+e"));
        JPanel coefs = new JPanel();
        coefs.add(new JLabel("a"));
        coefs.add(c1);
        coefs.add(new JLabel("b"));
        coefs.add(c2);
        coefs.add(new JLabel("c"));
        coefs.add(c3);
        coefs.add(new JLabel("d"));
        coefs.add(c4);
        coefs.add(new JLabel("e"));
        coefs.add(c5);
        input.add(new JLabel("      Input Base: "));
        input.add(bs);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820,600);
        mainPanel.setBackground(new Color(0,0,0,0));
        mainPanel.add(northPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 90)));
        mainPanel.add(type);
        mainPanel.add(input);
        mainPanel.add(coefs);
        mainPanel.add(submitPanel);
        mainPanel.add(canvas);
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
                assert function != null;
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
                        default:
                            break;
                }
            }
            else if (e.getSource() == infoBtn) {
                Glossary dictionary = null;
                try {
                    dictionary = new Glossary();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ImageIcon searchIcon = new ImageIcon("active-search.png");
                searchValue = (String) JOptionPane.showInputDialog(null, "Search for what you need help with:", "Glossary", JOptionPane.INFORMATION_MESSAGE, searchIcon, null, null);
                try {
                    if (!searchValue.equals("")) {
                        assert dictionary != null;
                        searchValue = searchValue.toLowerCase();
                        if (dictionary.checkWord(searchValue))
                            JOptionPane.showMessageDialog(null, "<html><body><p style='width:300px;'>" + dictionary.defineWord(searchValue) + "</p></body></html>", "Definition: " + searchValue, JOptionPane.INFORMATION_MESSAGE, searchIcon);
                        else
                            JOptionPane.showMessageDialog(null, "The word '" + searchValue + "' was not found in the dictionary!", "Glossary", JOptionPane.WARNING_MESSAGE, searchIcon);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a search term!", "Glossary", JOptionPane.ERROR_MESSAGE, searchIcon);
                    }
                } catch (NullPointerException el) {
                    el.printStackTrace();
                }
            }
            else if(e.getSource() == rtnBtn) {
                dispose();
                new GraphingCalc();
            }
//            else if(e.getSource() == ftnSubmit) {
//
//            }
        }
    }
}
