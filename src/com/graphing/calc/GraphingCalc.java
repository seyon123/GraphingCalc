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
    private JButton enterButton, infoBtn, rtnBtn, ftnSubmit, clrBtn;
    private JTextField c1, c2, c3, c4, c5, b;
    private JComboBox  chooseFunction;
    private ImageIcon infoImg, returnImg;

    private Polynomial poly = new Polynomial();
    private Exponential expo = new Exponential();
    private Logarithmic log = new Logarithmic();

    public String parentFunction, searchValue, coef1, coef2, coef3, coef4, coef5, base;

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

        clrBtn = new JButton("Clear");
        clrBtn.addActionListener(new ButtonListener());

        submitPanel = new JPanel();
        submitPanel.add(ftnSubmit);
        submitPanel.add(clrBtn);

        northPanel = new JPanel(new BorderLayout());
        northPanel.add(infoBtn, BorderLayout.EAST);
        northPanel.setOpaque(false);

        southPanel = new JPanel(new BorderLayout());
        southPanel.add(label2,BorderLayout.EAST);
        southPanel.add(rtnBtn, BorderLayout.WEST);
        southPanel.setOpaque(true);

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

        String[] functionList = {"-- Select Function --", "Linear", "Quadratic", "Exponential", "Logarithmic",};
        chooseFunction = new JComboBox<>(functionList);
        chooseFunction.addActionListener(new ButtonListener());
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(new Dimension(200, 30));
        chooseFunction.setOpaque(false);
        chooseFunction.grabFocus();

        enterButton = new JButton("Enter");
        enterButton.addActionListener(new ButtonListener());
        enterButton.setMaximumSize(new Dimension(100, 30));
        enterButton.setAlignmentX(CENTER_ALIGNMENT);

        rtnBtn.setVisible(false);

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
        mainPanel.add(enterButton);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 220)));
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

    private void linearScreen() {

        c1 = new JTextField(2);
        c2 = new JTextField(2);
        JPanel type = new JPanel();
        type.add(new JLabel("Linear Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = ax + b"));
        JPanel coefs = new JPanel();
        coefs.add(new JLabel("a: "));
        coefs.add(c1);
        coefs.add(new JLabel("b: "));
        coefs.add(c2);

        rtnBtn.setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(820, 600);
        mainPanel.setBackground(new Color(0, 0, 0, 0));
        mainPanel.add(northPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(820, 90)));
        mainPanel.add(type);
        mainPanel.add(input);
        mainPanel.add(coefs);
        mainPanel.add(submitPanel);
        mainPanel.add(southPanel);

        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(mainPanel);
        setTitle("Graphing Calculator");
        setSize(830, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void quadraticScreen() {

        c1 = new JTextField(2);
        c2 = new JTextField(2);
        c3 = new JTextField(2);
        JPanel type = new JPanel();
        type.add(new JLabel("Quadratic Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = ax^2 + bx + c"));
        JPanel coefs = new JPanel();
        coefs.add(new JLabel("a: "));
        coefs.add(c1);
        coefs.add(new JLabel("b: "));
        coefs.add(c2);
        coefs.add(new JLabel("c: "));
        coefs.add(c3);

        rtnBtn.setVisible(true);

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

        b = new JTextField(2);
        JPanel type = new JPanel();
        type.add(new JLabel("Exponential Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = a^x"));
        JPanel coefs = new JPanel();
        coefs.add(new JLabel("a: "));
        coefs.add(b);

        rtnBtn.setVisible(true);

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

        c1 = new JTextField(2);
        c2 = new JTextField(2);
        c3 = new JTextField(2);
        c4 = new JTextField(2);
        c5 = new JTextField(2);
        JPanel type = new JPanel();
        type.add(new JLabel("Logarithmic Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = a(log b(c(x + d)))+e"));
        JPanel coefs = new JPanel();
        coefs.add(new JLabel("a: "));
        coefs.add(c1);
        coefs.add(new JLabel("b: "));
        coefs.add(c2);
        coefs.add(new JLabel("c: "));
        coefs.add(c3);
        coefs.add(new JLabel("d: "));
        coefs.add(c4);
        coefs.add(new JLabel("e: "));
        coefs.add(c5);

        rtnBtn.setVisible(true);

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
            if (e.getSource() == enterButton) {
                parentFunction = (String) chooseFunction.getSelectedItem();
                assert parentFunction != null;
                switch (parentFunction) {
                    case "Linear":
                        linearScreen();
                        break;
                    case "Quadratic":
                        quadraticScreen();
                        break;
                    case "Exponential":
                        exponentialScreen();
                        break;
                    case "Logarithmic":
                        logarithmicScreen();
                        break;
                    default:
                        setExtendedState(JFrame.ICONIFIED);
                        setExtendedState(JFrame.NORMAL);
                        break;
                }
            }
            else if (e.getSource() == infoBtn) {
                Glossary dictionary = null;
                try {
                    dictionary = new Glossary();
                } catch (IOException e1) {
                    //e1.printStackTrace();
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
                    //el.printStackTrace();
                }
            }
            else if(e.getSource() == rtnBtn) {
                dispose();
                new GraphingCalc();
            }
            else if (e.getSource() == ftnSubmit) {
                if (parentFunction.equals("Linear")) {
                    coef1 = c1.getText();
                    coef2 = c2.getText();
                    if (!coef1.equals("") && !coef2.equals("")) {
                        canvas = new GraphCanvas(parentFunction, coef1, coef2);
                        canvas.setSize(400, 300);
                        canvas.setPreferredSize(new Dimension(400, 300));
                        mainPanel.add(canvas);
                    } else
                        JOptionPane.showMessageDialog(null, "Please input coefficients of the function!", "No Coefficients", JOptionPane.ERROR_MESSAGE);
                    int count = 0;
                    if (count < poly.getWidth()) {
                        count++;
                        canvas.repaint();
                    }
                }
                else if (parentFunction.equals("Quadratic")) {
                    coef1 = c1.getText();
                    coef2 = c2.getText();
                    coef3 = c3.getText();
                    if (!coef1.equals("") && !coef2.equals("") && !coef3.equals("")) {
                        canvas = new GraphCanvas(parentFunction, coef1, coef2, coef3);
                        canvas.setSize(400, 300);
                        canvas.setPreferredSize(new Dimension(400, 300));
                        mainPanel.add(canvas);
                    } else
                        JOptionPane.showMessageDialog(null, "Please input coefficients of the function!", "No Coefficients", JOptionPane.ERROR_MESSAGE);
                    int count = 0;
                    if (count < poly.getWidth()) {
                        count++;
                        canvas.repaint();
                    }
                }
                else if (parentFunction.equals("Exponential")) {
                    base = b.getText();
                    if (!base.equals("")) {
                        canvas = new GraphCanvas(parentFunction, base);
                        canvas.setSize(400, 300);
                        canvas.setPreferredSize(new Dimension(400, 300));
                        mainPanel.add(canvas);
                    } else
                        JOptionPane.showMessageDialog(null, "Please input coefficients of the function!", "No Coefficients", JOptionPane.ERROR_MESSAGE);
                    int count = 0;
                    if (count < expo.getWidth()) {
                        count++;
                        canvas.repaint();
                    }
                }
                else if (parentFunction.equals("Logarithmic")) {
                    coef1 = c1.getText();
                    coef2 = c2.getText();
                    coef3 = c3.getText();
                    coef4 = c4.getText();
                    coef5 = c5.getText();
                    if (!coef1.equals("") && !coef2.equals("") && !coef3.equals("") && !coef4.equals("") && !coef5.equals("")) {
                        canvas = new GraphCanvas(parentFunction, coef1, coef2, coef3, coef4, coef5);
                        canvas.setSize(400, 300);
                        canvas.setPreferredSize(new Dimension(400, 300));
                        mainPanel.add(canvas);
                    } else
                        JOptionPane.showMessageDialog(null, "Please input coefficients of the function!", "No Coefficients", JOptionPane.ERROR_MESSAGE);
                    int count = 0;
                    if (count < log.getWidth()) {
                        count++;
                        canvas.repaint();
                    }
                }
                setExtendedState(JFrame.ICONIFIED);
                setExtendedState(JFrame.NORMAL);
            }
            else if (e.getSource() == clrBtn) {
                switch (parentFunction) {
                    case "Linear":
                        linearScreen();
                        break;
                    case "Quadratic":
                        quadraticScreen();
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
        }
    }
}
