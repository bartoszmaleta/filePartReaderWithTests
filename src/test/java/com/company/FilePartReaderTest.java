package com.company;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest {
    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void should_returnFileContentAsString() throws IOException {
        filePartReader.setup("src/test/resources/test_file.txt", 1, 1); // src/test/resources/test_file.txt
        String fileContent = "Growing old, wathing silver turn to gold\n" +
                "Snowing cold, why aren't you here for me to hold?\n" +
                "In a dream somewhere finding my way home\n" +
                "Then a change of scene\n" +
                "The rest took place in Ancient Rome";
        assertEquals(fileContent, filePartReader.read());
    }

    @Test
    public void should_returnOneRow_when_fromLineAndToLineEqualOne() throws IOException {
        filePartReader.setup("src/test/resources/test_file2.txt", 1, 1);
        assertEquals("Growing old, wathing silver turn to gold", filePartReader.readLines());
    }

    @Test
    public void should_throwIllegalArgumentException_when_fromLineIsBelow1() {
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup("no_file_name.txt", 0, 1);
        });
    }

    @Test
    public void should_throwIllegalArgumentException_when_toLineIsSmallerThanFromLine() {
        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("no_file_name.txt", 3, 1);
        });
    }

}