// 1091. Shortest Path in Binary Matrix

class Solution {
    int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
    boolean found = false;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;
        Queue<int[]> q = new LinkedList();
        q.add(new int[] { 0, 0 });
        int count = 1;
        HashSet<String> visited = new HashSet();

        while (q.size() > 0) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                String key = curr[0] + "-" + curr[1];
                int r = 0, c = 0;
                if (r == grid.length - 1 && r == c)
                    return count;
                if (visited.contains(key))
                    continue;
                visited.add(key);
                for (int[] d : dir) {
                    r = curr[0] + d[0];
                    c = curr[1] + d[1];
                    if (r == grid.length - 1 && r == c)
                        return count + 1;
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid.length || grid[r][c] != 0
                            || visited.contains(r + "-" + c))
                        continue;
                    q.add(new int[] { r, c });
                }
            }
            count++;

        }
        return -1;

    }

    public int dfs(int[][] grid, int r, int c, HashMap<String, Integer> cache) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid.length || grid[r][c] != 0)
            return 999999;

        if (r == grid.length - 1 && c == r) {
            found = true;
            return 1;
        }

        String key = r + "-" + c;

        if (cache.containsKey(key))
            return cache.get(key);

        int dist = Integer.MAX_VALUE;

        grid[r][c] = 1;

        for (int[] d : dir) {
            dist = Math.min(dist, dfs(grid, r + d[0], c + d[1], cache));
        }

        dist++;

        grid[r][c] = 0;

        cache.put(key, dist);

        return dist;
    }
}