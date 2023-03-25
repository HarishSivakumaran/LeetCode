// 2316. Count Unreachable Pairs of Nodes in an Undirected Graph

class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int r1 = 0, r2 = 0, t = n;

        for (int[] edge : edges) {
            r1 = findRoot(edge[0], parent);
            r2 = findRoot(edge[1], parent);

            if (r1 == r2)
                continue;

            t--;

            if (rank[r1] > rank[r2]) {
                rank[r1] += rank[r2];
                rank[r2] = 0;
                parent[r2] = r1;
            } else {
                rank[r2] += rank[r1];
                rank[r1] = 0;
                parent[r1] = r2;
            }
        }

        if (t == 1)
            return 0;

        long prev = 0;
        long res = 0;

        for (int i = 0; i < rank.length; i++) {
            if (rank[i] > 0) {
                res += ((long) prev * rank[i]);
            }
            prev += rank[i];
        }

        return res;

    }

    public int findRoot(int i, int[] parent) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }
}
