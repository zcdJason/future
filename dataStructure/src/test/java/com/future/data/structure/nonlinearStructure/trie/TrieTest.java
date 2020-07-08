package com.future.data.structure.nonlinearStructure.trie;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: zcd
 */
public class TrieTest {

    @Test
    public void getSize() {
        Trie t = new Trie();
        t.add("world");
        t.add("tiger");
        System.out.println(t);
        System.out.println(t.contains("worl"));
        System.out.println(t.startsWith("tig"));
    }
}