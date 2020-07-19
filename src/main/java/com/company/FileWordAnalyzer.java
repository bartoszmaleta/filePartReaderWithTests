package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    public FilePartReader filePartReader;

    public FileWordAnalyzer (FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically () throws IOException {
        List<String> words = stringAsWordsList();
        words.sort(String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    private List<String> stringAsWordsList() throws IOException {
        String content = filePartReader.readLines();
        return Arrays.asList(content.split(" "));
    }

    public List<String> getWordsContainingSubstring (String subString) throws IOException {
        if (subString.isEmpty()) {
            return null;
        }
        List<String> words = stringAsWordsList();
        List<String> wordsContainingSubstring = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                wordsContainingSubstring.add(word);
            }
        }
        return wordsContainingSubstring;

    }

    public List<String> getWordsWhichPalindromes () throws IOException {
        List<String> words = stringAsWordsList();
        List<String> palindromeWords = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                palindromeWords.add(word);
            }
        }
        return palindromeWords;
    }

    private boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int startIndex = 0;
        int endIndex = word.length() - 1;
        while (endIndex > startIndex) {
            if (word.charAt(startIndex) != word.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex++;
        }
        return true;
    }


}
