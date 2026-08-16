class Solution {
    public String foreignDictionary(String[] words) {
        int K = 26, N = words.length;
        boolean[][] adj = new boolean[K][K];
        int[] indegree = new int[K];
        boolean[] present = new boolean[K];
        for (String w : words) {
            for (char c : w.toCharArray()) {
                present[c - 'a'] = true;
            }
        }
        int totalchar = 0;
        for (boolean exist : present) {
            if (exist)
                totalchar++;
        }
        for (int i = 0; i < N - 1; i++) {
            String d1 = words[i], d2 = words[i + 1];
            int len = Math.min(d1.length(), d2.length());
            boolean found = false;
            for (int j = 0; j < len; j++) {
                int c1 = d1.charAt(j) - 'a', c2 = d2.charAt(j) - 'a';
                if (c1 != c2) {
                    if (!adj[c1][c2]) {
                        adj[c1][c2] = true;
                        indegree[c2]++;
                    }
                    found = true;
                    break;
                }
            }
            if (!found && d1.length() > d2.length()) {
                return "";
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            if (present[i] && indegree[i] == 0)
                q.offer(i);
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.append((char) ('a' + node));
            for (int nei = 0; nei < K; nei++) {
                if (adj[node][nei] && --indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        if (res.length() != totalchar) {
            return "";
        }
        return res.toString();
    }
}
