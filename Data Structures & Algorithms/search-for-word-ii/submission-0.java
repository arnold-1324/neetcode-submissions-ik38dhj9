class Solution {
    private static final int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        String word = null;
    }
    TrieNode root = new TrieNode();
    private TrieNode buildTrie(String[] words) {
        for (String s : words) {
            TrieNode node = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (node.child[idx] == null)
                    node.child[idx] = new TrieNode();
                node = node.child[idx];
            }
            node.isEnd = true;
            node.word = s;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int row = board.length, col = board[0].length;
        TrieNode root = buildTrie(words);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                dfs(board, r, c, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        char ch = board[r][c];
        TrieNode next = node.child[ch - 'a'];
        if (next == null)
            return;
        if (next.isEnd) {
            res.add(next.word);
            next.isEnd = false;
        }
        board[r][c] = '#';
        for (int[] d : DIR) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
                && board[nr][nc] != '#') {
                dfs(board, nr, nc, next, res);
            }
        }
        board[r][c] = ch;
    }
}
