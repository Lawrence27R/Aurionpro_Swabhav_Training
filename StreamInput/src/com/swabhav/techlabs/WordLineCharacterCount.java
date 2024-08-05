package com.swabhav.techlabs;

import java.io.FileInputStream;
import java.io.IOException;

public class WordLineCharacterCount {
    public static void main(String[] args) throws IOException {
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        FileInputStream fileInputStream = new FileInputStream("D:\\Aurionpro\\StreamInput\\src\\com\\swabhav\\techlabs\\test");
        int ch;
        boolean isWord = false;

        while ((ch = fileInputStream.read()) != -1) {
            if (Character.isLetter((char) ch)) {
                charCount++;
                isWord = true; 
            } 
            else {

                if (isWord) {
                    wordCount++;
                    isWord = false; 
                }
            }

            if (ch == '\n') {
                lineCount++;
            }
        }

        if (isWord) {
            wordCount++;
        }

        if (charCount > 0 && ch != '\n') {
            lineCount++;
        }

        fileInputStream.close();

        System.out.println("Number of letters: " + charCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of lines: " + lineCount);
    }
}
