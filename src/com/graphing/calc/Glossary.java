package com.graphing.calc;

import java.util.*;

public class Glossary {

    private ArrayList<String> glossary;

    public Glossary() {
        glossary = new ArrayList<>();
        glossary.add("polynomial");
        glossary.add("A polynomial function has the form, where are real numbers and n is a non negative integer.\nIn other words, a polynomial is the sum of one or more monomials with real coefficients and non negative integer exponents.\nThe degree of the polynomial function is the highest value for n where an is not equal to 0.");

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
