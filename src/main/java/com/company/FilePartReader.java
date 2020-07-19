package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader {
    private String filepath;
    private int startLine;
    private int endLine;

    FilePartReader() {
        filepath = "";
        startLine = 0;
        endLine = -1;
    }

    public void init (String filepath, int startLine, int endLine) {
        if ((startLine < endLine) || (startLine < 1)) {
            throw new IllegalArgumentException();
        }
        this.filepath = filepath;
        this.startLine = startLine;
        this.endLine = endLine;
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
            if (i + 1 >= this.startLine && i + 1 <= this.endLine) {
                sb.append(lines[i]);
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }
}
