package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader {
    private String filepath;
    private int fromLine;
    private int toLine;

    FilePartReader() {
        filepath = "";
        fromLine = 0;
        toLine = -1;
    }

    public void setup(String filepath, int fromLine, int toLine) {
        if ((toLine < fromLine) || (fromLine < 1)) {
            throw new IllegalArgumentException();
        }
        this.filepath = filepath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read () throws IOException {
        File file = new File(this.filepath);
        Scanner fileToRead = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (fileToRead.hasNext()) {
            String line = fileToRead.nextLine();
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    public String readLines() throws IOException {
        String fileContent = read();
        String[] lines = fileContent.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            if (i + 1 >= this.fromLine && i + 1 <= this.toLine) {
                sb.append(lines[i]);
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }
}
