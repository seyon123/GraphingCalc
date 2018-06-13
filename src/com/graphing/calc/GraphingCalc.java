package com.graphing.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GraphingCalc extends JFrame {

    //initializing variables
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
        //Creates label that contains author info
        label2 = new JLabel("Created By: Seyon Rajagopal and Jacky Ly ");
        label2.setOpaque(true);
        label2.setBackground(Color.WHITE);

        //Creates a button for information/search
        infoImg = new ImageIcon("info-button.png");
        infoBtn = new JButton(infoImg);
        infoBtn.addActionListener(new ButtonListener());
        infoBtn.setAlignmentX(RIGHT_ALIGNMENT);

        //Creates a button to return to home screen
        returnImg = new ImageIcon("rtnButton.png");
        rtnBtn = new JButton(returnImg);
        rtnBtn.addActionListener(new ButtonListener());

        //Creates a button to graph the function
        ftnSubmit = new JButton("Graph");
        ftnSubmit.addActionListener(new ButtonListener());

        //Creates a button to clear the graph
        clrBtn = new JButton("Clear");
        clrBtn.addActionListener(new ButtonListener());

        //Panel that contains both the graph and clear buttons
        submitPanel = new JPanel();
        submitPanel.add(ftnSubmit);
        submitPanel.add(clrBtn);

        //Panel that contains the info button
        northPanel = new JPanel(new BorderLayout());
        northPanel.add(infoBtn, BorderLayout.EAST);
        northPanel.setOpaque(false);

        //Panel that contains the return button and the author information
        southPanel = new JPanel(new BorderLayout());
        southPanel.add(label2,BorderLayout.EAST);
        southPanel.add(rtnBtn, BorderLayout.WEST);
        southPanel.setOpaque(true);

        //Calls mainScreen method
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

    //main
    public static void main(String[] args) {
        new GraphingCalc();
    }

    // Method for the main Scrren shown on start-up
    private void mainScreen(){
        //label that says function type
        label1 = new JLabel("Choose Function Type:");
        label1.setAlignmentX(CENTER_ALIGNMENT);

        //dropdown mwnu of all functions
        String[] functionList = {"-- Select Function --", "Linear", "Quadratic", "Exponential", "Logarithmic",};
        chooseFunction = new JComboBox<>(functionList);
        chooseFunction.addActionListener(new ButtonListener());
        chooseFunction.setPreferredSize(new Dimension(200, 30));
        chooseFunction.setMaximumSize(new Dimension(200, 30));
        chooseFunction.setOpaque(false);
        chooseFunction.grabFocus();

        //Enter button that selects the function
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new ButtonListener());
        enterButton.setMaximumSize(new Dimension(100, 30));
        enterButton.setAlignmentX(CENTER_ALIGNMENT);

        //sets return button not visible on main screen
        rtnBtn.setVisible(false);

        //main panel that contains the rest of the components
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

        //properties of JFrame
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

    //Method for the screen with a linear function
    private void linearScreen() {

        //components where properties of the linear function is inputted
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

        // changes text  of a label and sets return button to visible
        rtnBtn.setVisible(true);
        label2.setText("*Please click 'Clear' before entering a new set of data");

        //main panel that contains the rest of the components
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

        //properties of JFrame
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

    //Method for the screen with a quadratic function
    private void quadraticScreen() {

        //components where properties of the quadratic function is inputted
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

        // changes text  of a label and sets return button to visible
        rtnBtn.setVisible(true);
        label2.setText("*Please click 'Clear' before entering a new set of data");

        //main panel that contains the rest of the components
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

        //properties of JFrame
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

    //Method for the screen with a exponential function
    private void exponentialScreen(){

        //components where properties of the exponential function is inputted
        b = new JTextField(2);
        JPanel type = new JPanel();
        type.add(new JLabel("Exponential Function:"));
        JPanel input = new JPanel();
        input.add(new JLabel("f(x) = a^x"));
        JPanel coefs = new JPanel();
        coefs.add(new JLabel("a: "));
        coefs.add(b);

        // changes text  of a label and sets return button to visible
        rtnBtn.setVisible(true);
        label2.setText("*Please click 'Clear' before entering a new set of data");

        //main panel that contains the rest of the components
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

        //properties of JFrame
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

    //Method for the screen with a logarithmic function
    private void logarithmicScreen(){

        //components where properties of the logarithmic function is inputted
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

        // changes text  of a label and sets return button to visible
        rtnBtn.setVisible(true);
        label2.setText("*Please click 'Clear' before entering a new set of data");

        //main panel that contains the rest of the components
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

        //properties of JFrame
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

    //Action Listeners
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //when enter button is clicked switches screens based on selection
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
            //when info button is clicked calls glossary class
            else if (e.getSource() == infoBtn) {
                Glossary dictionary = null;
                try {
                    dictionary = new Glossary();
                } catch (IOException e1) {
                    //e1.printStackTrace();
                }
                //Dialog box for seaching text
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
            //when return button is clicked  program is closed and relaunched
            else if(e.getSource() == rtnBtn) {
                dispose();
                new GraphingCalc();
            }
            //when function and parameters are submitted its classes are called and graph is grawn
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
                    for (int i = 0; i < poly.getWidth(); i++) {
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
                    for (int i = 0; i < poly.getWidth(); i++) {
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
                    for (int i = 0; i < expo.getWidth(); i++) {
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
                    for (int i = 0; i < log.getWidth(); i++) {
                        canvas.repaint();
                    }
                }
                setExtendedState(JFrame.ICONIFIED);
                setExtendedState(JFrame.NORMAL);
            }
            //when clear button  is pressed, resets the screen
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
