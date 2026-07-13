class WordDictionary {
    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.child[idx] == null)
                node.child[idx] = new TrieNode();
            node = node.child[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (node == null)
            return false;

        if (i == word.length())
            return node.isEnd;

        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode next : node.child) {
                if (dfs(word, i + 1, next))
                    return true;
            }
            return false;
        } else {
            return dfs(word, i + 1, node.child[c - 'a']);
        }
    }
}
