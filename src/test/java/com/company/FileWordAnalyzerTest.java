package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    FilePartReader filePartReader = new FilePartReader();
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    @Test
    public void shouldReturnNullWhenSubstringIsEmpty() throws IOException {
        filePartReader.setup("src/test/resources/test_file.txt", 1,1);
        assertNull(fileWordAnalyzer.getWordsContainingSubstring(""));
    }

    @Test
    public void shouldIgnoreCaseWhenComparingStrings() throws IOException {
        filePartReader.setup("src/test/resources/test_file3.txt", 1,5);
        List<String> expectedArray = new ArrayList<>();
        expectedArray.add("Then");
        assertEquals(expectedArray, fileWordAnalyzer.getWordsContainingSubstring("then"));
    }
}