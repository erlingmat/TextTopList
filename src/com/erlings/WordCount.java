package com.erlings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emm on 22/03/2017.
 */
public class WordCount {
    Map<String, Integer> wordCount = null;

    public WordCount(){
        wordCount = new HashMap<>();
    }

    public void printTopTen() {
        wordCount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(10)
                .forEach(System.out::println);
    }

    public void countWord(String word) {
        Integer count = wordCount.get(word);
        if (count == null) {
            count = 1;
        }else {count ++;}
        wordCount.put(word,count);
    }
}
