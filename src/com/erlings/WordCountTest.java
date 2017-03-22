package com.erlings;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by emm on 22/03/2017.
 */
class WordCountTest {
    WordCount counter;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        counter = new WordCount();
    }

    @org.junit.jupiter.api.Test
    void printTopTen() {
    }

    @org.junit.jupiter.api.Test
    void countWord() {
        counter.countWord("a");
        counter.countWord("a");
        counter.countWord("b");
        counter.printTopTen();
    }

}