package com.graphing.calc;

import java.util.*;

public class Glossary {

    private ArrayList<String> glossary;

    public Glossary() {
        glossary = new ArrayList<>();
        glossary.add("Polynomial");
        glossary.add("A polynomial function has the form , where are real numbers and n is a nonnegative integer. In other words, a polynomial is the sum of one or more monomials with real coefficients and nonnegative integer exponents. The degree of the polynomial function is the highest value for n where an is not equal to 0.");

    }

    private String defineWord(String word) {
        int pos = glossary.indexOf(word) + 1;
        return glossary.get(pos);
    }

    public String checkWord(String word) {
        if (glossary.contains(word)) {
            defineWord(word);
        }
        return "Cannot find '" + word + "' in the dictionary!";
    }

    public String toString(String word) {
        return word + ": " + defineWord(word);
    }
}
