package com.graphing.calc;

import java.util.*;
import java.io.*;

public class Glossary {

    private ArrayList<String> glossary;

    public Glossary() throws IOException {
        Scanner inputFile = new Scanner(new File("dictionary.txt"));
        glossary = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            glossary.add(inputFile.nextLine());
        }
        inputFile.close();
    }

    private int binarySearch(ArrayList<String> glossary, String searchValue) {

        int low = 0;
        int high = glossary.size() - 1;
        int mid = (low + high) / 2;

        while (low <= high && !glossary.get(mid).startsWith(searchValue)) {
            if (glossary.get(mid).compareTo(searchValue) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;

            if (low > high) {
                // NO RESULT
                mid = -1;
            }
        }
        return mid;

    }

    public String defineWord(String word) {
        int pos = binarySearch(glossary, word);
        return glossary.get(pos);
    }

    public boolean checkWord(String word) {
        for (String term: glossary) {
            if (term.startsWith(word))
                return true;
        }
        return false;
    }

    public String toString(String word) {
        return word + ": " + defineWord(word);
    }
}
