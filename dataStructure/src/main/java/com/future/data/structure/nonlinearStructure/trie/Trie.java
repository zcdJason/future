package com.future.data.structure.nonlinearStructure.trie;

import java.util.TreeMap;

/**
 * @author: zcd
 */
public class Trie {
    private class Node{
        private boolean isWorld;
        private TreeMap<Character, Node> next;
        public  Node(boolean isWorld){
            this.isWorld = isWorld;
            this.next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "isWorld=" + isWorld +
                    ", next=" + next +
                    '}';
        }
    }

    private Node root;
    //trie save world number;
    private int size;
    public Trie(){
        this.root = new Node();
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * world
     *          root
     *         |
     *        w
     *        |
     *        O
     *        |
     *        r
     *        |
     *        d
     * @param world
     */
    public void add(String world){
        Node cur = root;
        int wLen = world.length();
        for(int i= 0 ; i< wLen; i++){
            char c = world.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWorld){
            cur.isWorld = true;
            size ++;
        }
    }

    public boolean startsWith(String prefix){
        Node cur = root;
        int wLen = prefix.length();
        for(int i = 0; i< wLen; i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * check contains world
     * @param world
     * @return
     */
    public boolean contains(String world){
        Node cur = root;
        int wLen = world.length();
        for(int i = 0; i< wLen; i++){
            char c = world.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWorld;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
