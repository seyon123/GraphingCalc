package com.graphing.calc;

import java.util.*;
import java.io.*;

public class Glossary {

    private Scanner inputFile;
    private ArrayList<String> glossary;

    public Glossary() throws IOException {
        inputFile = new Scanner(new File("dictionary.txt"));
        glossary = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            glossary.add(inputFile.nextLine());
        }
        inputFile.close();
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
