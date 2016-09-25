class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] childNode;
    public boolean isEnd;
    public TrieNode() {
        this.childNode = new TrieNode[26];
        this.isEnd = false;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.childNode[word.charAt(i) - 'a'] == null) {
                TrieNode node = new TrieNode();
                cur.childNode[word.charAt(i) - 'a'] = node;
            }
            cur = cur.childNode[word.charAt(i) - 'a'];
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.childNode[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.childNode[word.charAt(i) - 'a'];
        }
        return cur.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.childNode[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.childNode[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");