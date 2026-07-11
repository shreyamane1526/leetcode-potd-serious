class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] res = dfs(i, g, vis);
                int nodes = res[0], edgesCnt = res[1];
                if (edgesCnt == nodes * (nodes - 1) / 2) ans++;
            }
        }
        return ans;
    }
    int[] dfs(int start, List<List<Integer>> g, boolean[] vis) {
        Stack<Integer> st = new Stack<>();
        st.push(start);
        int nodes = 0, edges = 0;

        while (!st.isEmpty()) {
            int u = st.pop();
            if (vis[u]) continue;
            vis[u] = true;
            nodes++;
            edges += g.get(u).size();
            for (int v : g.get(u)) if (!vis[v]) st.push(v);
        }
        return new int[]{nodes, edges / 2};
    }
}
