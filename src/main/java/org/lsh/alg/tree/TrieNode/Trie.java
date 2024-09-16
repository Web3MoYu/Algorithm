package org.lsh.alg.tree.TrieNode;

public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void delete(String word) {
        // 确定树里面由这个节点
        if (search(word) != 0) {
            TrieNode node = root;
            node.pass--;
            int index = 0;
            for (char ch : word.toCharArray()) {
                index = ch - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null; // gc释放
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
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

    // word这个单词出现了几次
    public int search(String word) {
        if (word == null) {
            return 0;
        }
        TrieNode node = root;
        int index = 0;
        for (char ch : word.toCharArray()) {
            index = ch - 'a';
            // 代表不存在，返回0
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    // 查找以pre作为前缀的数量
    public int prefixNumber(String word) {
        if (word == null) {
            return 0;
        }
        TrieNode node = root;
        int index = 0;
        for (char ch : word.toCharArray()) {
            index = ch - 'a';
            // 代表不存在，返回0
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }
}
