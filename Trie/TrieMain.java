package com.ssafy.Trie;

public class TrieMain {
    public static void main(String[] args) {
        Trie trie = Trie.getInstance();
        trie.insert("apek");
        trie.insert("apck");
        trie.insert("bpck");
        trie.insert("beck");
        trie.insert("becka");

        System.out.println(trie.search("apek"));
        System.out.println(trie.search("noWord"));


        System.out.println(trie);
    }
}
