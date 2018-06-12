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

    public static int binarySearch(ArrayList<String> glossary, String searchValue) {

        int low = 0;
        int high = glossary.size() - 1;
        int mid = (low + high) / 2;

        while (low <= high && !glossary.get(mid).equalsIgnoreCase(searchValue)) {

            if (glossary.get(mid).compareTo(searchValue) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;

            if (low > high) {
                mid = -1;
            }

        }
        return mid;

    }

    public String defineWord(String word) {
        //int pos = glossary.indexOf(word) + 1;
        int pos = binarySearch(glossary, word) + 1;
        return glossary.get(pos);
    }

    public boolean checkWord(String word) {
        return glossary.contains(word);
    }

    public String toString(String word) {
        return word + ": " + defineWord(word);
    }
}
