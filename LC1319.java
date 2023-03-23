// 1319. Number of Operations to Make Network Connected

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int excess = 0, total = n - 1, r1 = 0, r2 = 0;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        for (int[] con : connections) {
            r1 = getRoot(con[0], parent);
            r2 = getRoot(con[1], parent);

            if (r1 == r2) {
                excess++;
                continue;
            }

            total--;

            if (rank[r1] > rank[r2]) {
                rank[r1] += rank[r2];
                parent[r2] = r1;
            } else {
                rank[r2] += rank[r1];
                parent[r1] = r2;
            }
        }

        return excess >= total ? total : -1;
    }

    public int getRoot(int i, int[] parent) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }
}