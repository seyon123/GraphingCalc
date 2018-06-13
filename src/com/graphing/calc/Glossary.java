package com.graphing.calc;

import java.util.*;
import java.io.*;

public class Glossary {

    private ArrayList<String> glossary;

    // constructor - imports dictionary text file
    public Glossary() throws IOException {
        Scanner inputFile = new Scanner(new File("dictionary.txt"));
        glossary = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            glossary.add(inputFile.nextLine());
        }
        inputFile.close();
    }

    // performs a binary search on the array list
    private int binarySearch(ArrayList<String> glossary, String searchValue) {

        int low = 0;
        int high = glossary.size() - 1;
        int mid = (low + high) / 2;

        // go up or down the array list depending if the value is lower or higher than the search term
        while (low <= high && !glossary.get(mid).startsWith(searchValue)) {
            if (glossary.get(mid).compareTo(searchValue) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;

            if (low > high) {
                // no position if word can't be found
                mid = -1;
            }
        }
        // return position of word
        return mid;

    }

    // run binary search and return the value at the found position
    public String defineWord(String word) {
        int pos = binarySearch(glossary, word);
        return glossary.get(pos);
    }

    // check if the word is in the dictionary
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
