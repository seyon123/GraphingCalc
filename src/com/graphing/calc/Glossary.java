package com.graphing.calc;

import java.util.*;

public class Glossary {

    private ArrayList<String> glossary;

    public Glossary() {
        glossary = new ArrayList<>();
    }

    private String defineWord(String word) {
        int pos = glossary.indexOf(word) + 1;
        return glossary.get(pos);
    }

    public boolean checkWord(String word) {
        if (glossary.contains(word)) {
            defineWord(word);
        }
        return false;
    }

    public String toString(String word) {
        return defineWord(word);
    }
}
