package com.erlings;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.regex.Pattern;


public class Main {
    private static WordCount counter;
    public static boolean doesFileExist(String filename) {
        File file = new File(filename);
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }

    public static void readFile(String filename) {
        Instant starts = Instant.now();
        File file = new File(filename);
        try(FileInputStream stream = new FileInputStream(file)) {
            BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(stream));
            int c = 0;
            String word = "";

            while ((c = buffer.read()) != -1) {
                char character = (char) c;
                String str = "";
                str += character;
                if (Pattern.matches("\\w", str)) word += character;
                if (Pattern.matches("\\W", str) && !word.isEmpty()) {
                    counter.countWord(word);
                    word = "";
                }

            }
        }catch(IOException e){
            System.out.println("IOEx caught " + e.getMessage());
        }
        Instant ends = Instant.now();
        System.out.println("Time elapsed was: " + Duration.between(starts, ends));
    }


    public static void main(String[] args) {
        counter = new WordCount();
        if (args.length > 0) {
            System.out.println("Input file named '" + args[0] + "'. ");
            if (doesFileExist(args[0])) {
                readFile(args[0]);
                counter.printTopTen();
            }
        }
    }
}
