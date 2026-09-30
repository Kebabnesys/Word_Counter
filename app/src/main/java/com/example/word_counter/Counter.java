package com.example.word_counter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
    public int countChars(String input)
    {
        if (input == null || input.isEmpty()) return 0;
        return input.length();
    }
    public static int countWords(String input) {
        if (input == null || input.isEmpty()) return 0;
        String[] words = input.trim().split("\\s+");
        return words.length;
    }
    public int countSentences(String input)
    {
        if (input == null || input.isEmpty()) return 0;
        int sentenceCount = 0;
        Pattern pattern = Pattern.compile("[.!?]+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            sentenceCount++;
        }
        return sentenceCount;
    }

}
