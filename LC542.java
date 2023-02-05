// 542. 01 Matrix

class Solution {
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList();

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) {
                    q.add(new int[] { r, c });
                }
            }
        }

        HashSet<String> visited = new HashSet();

        int dist = 0;
        while (q.size() > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                String key = curr[0] + "-" + curr[1];
                if (visited.contains(key))
                    continue;
                visited.add(key);
                res[curr[0]][curr[1]] = dist;
                for (int[] d : dir) {
                    String newKey = (curr[0] + d[0]) + "-" + (curr[1] + d[1]);
                    if (curr[0] + d[0] < 0 || curr[0] + d[0] >= mat.length || curr[1] + d[1] < 0
                            || curr[1] + d[1] >= mat[0].length || mat[curr[0] + d[0]][curr[1] + d[1]] == 0
                            || visited.contains(newKey))
                        continue;
                    q.add(new int[] { curr[0] + d[0], curr[1] + d[1] });
                }
            }
            dist++;
        }

        return res;

    }

}