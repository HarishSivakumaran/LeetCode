// 2492. Minimum Score of a Path Between Two Cities

class Solution {
    public int minScore(int n, int[][] roads) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        rank[0] = 1000000;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int from = 0, to = 0, res = Integer.MAX_VALUE, root1 = 0, root2 = 0;
        for (int[] curr : roads) {
            from = curr[0] - 1;
            to = curr[1] - 1;

            root1 = findRoot(from, parent);
            root2 = findRoot(to, parent);

            if (root1 == root2)
                continue;

            if (rank[root1] > rank[root2]) {
                rank[root1] += rank[root2];
                parent[root2] = root1;
            } else {
                rank[root2] += rank[root1];
                parent[root1] = root2;
            }
        }

        for (int[] curr : roads) {
            from = curr[0] - 1;
            to = curr[1] - 1;

            root1 = findRoot(from, parent);
            root2 = findRoot(to, parent);

            if (root1 == 0 || root2 == 0) {
                res = Math.min(res, curr[2]);
            }

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