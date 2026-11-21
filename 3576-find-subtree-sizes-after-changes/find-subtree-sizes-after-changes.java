class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] head = new int[n];
        int[] next = new int[n];
        java.util.Arrays.fill(head, -1);
        for (int i = 1; i < n; i++) {
            next[i] = head[parent[i]];
            head[parent[i]] = i;
        }
        int[] newParent = parent.clone();
        int[] latest = new int[26];
        int[] saved = new int[n];
        java.util.Arrays.fill(latest, -1);
        int[] stack = new int[2 * n + 2];
        int[] order = new int[n];
        int top = 0, orderSize = 0;
        stack[top++] = 0;
        while (top > 0) {
            int u = stack[--top];
            if (u < 0) {
                int node = -u - 1;
                latest[s.charAt(node) - 'a'] = saved[node];
                continue;
            }
            int c = s.charAt(u) - 'a';
            saved[u] = latest[c];
            if (u != 0 && latest[c] != -1) newParent[u] = latest[c];
            latest[c] = u;
            order[orderSize++] = u;
            stack[top++] = -(u + 1);
            for (int e = head[u]; e != -1; e = next[e]) stack[top++] = e;
        }
        int[] ans = new int[n];
        java.util.Arrays.fill(ans, 1);
        for (int i = n - 1; i > 0; i--) ans[newParent[order[i]]] += ans[order[i]];
        return ans;
    }
}