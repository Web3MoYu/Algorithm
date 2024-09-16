package org.lsh.alg.tree.TrieNode;

public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode node = root;
        node.pass++;
        int index = 0;
        for (char ch : word.toCharArray()) {
            index = ch - 'a'; // 走哪条路
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }
}
