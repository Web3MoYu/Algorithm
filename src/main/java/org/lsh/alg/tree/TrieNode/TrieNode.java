package org.lsh.alg.tree.TrieNode;

public class TrieNode {
    public int pass;
    public int end;
    public TrieNode[] nexts;

    public TrieNode() {
        this.pass = 0;
        this.end = 0;
        this.nexts = new TrieNode[26];
    }
}
