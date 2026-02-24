import java.util.*;

class Trie {
    private final Trie[] children = new Trie[26];
    private boolean end;

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new Trie();
            node = node.children[c - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        Trie node = find(word);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Trie find(String s) {
        Trie node = this;
        for (char c : s.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) return null;
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
