package com.graphing.calc;

import java.util.*;

public class Glossary {

    private ArrayList<String> glossary;

    public Glossary() {
        glossary = new ArrayList<>();
        glossary.add("function");
        glossary.add("The function is a general relation between a set of input values (domain) and corresponding set of output values (co-domain)." +
                "\nIt relates each element of a set (domain) with exactly one element of another set (co-domain)." +
                "\n\nThere are two important rules for a relation between input and output sets to be a function:" +
                "\nEvery element in domain must have a corresponding value in codomain." +
                "\nA function is single valued. It can't give two or more output values for the same input.");
        glossary.add("polynomial");
        glossary.add("A polynomial function has the form, where are real numbers and n is a non negative integer." +
                "\nIn other words, a polynomial is the sum of one or more monomials with real coefficients and non negative integer exponents." +
                "\nThe degree of the polynomial function is the highest value for n where an is not equal to 0.");
    }

    public String defineWord(String word) {
        int pos = glossary.indexOf(word) + 1;
        return glossary.get(pos);
    }

    public boolean checkWord(String word) {
        return glossary.contains(word);
    }

    public String toString(String word) {
        return word + ": " + defineWord(word);
    }
}
