// 1162. As Far from Land as Possible

class Solution {
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    HashSet<String> visited = new HashSet();

    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1)
                    q.add(new int[] { i, j });
            }
        }

        if (q.size() == (grid.length * grid.length) || q.size() == 0)
            return -1;

        int len = -1, max = -1;
        while (q.size() > 0) {
            int l = q.size();
            boolean newPos = false;
            for (int i = 0; i < l; i++) {
                int[] curr = q.poll();
                String key = curr[0] + "-" + curr[1];
                if (visited.contains(key))
                    continue;
                newPos = true;
                visited.add(key);
                for (int[] d : dir) {
                    int[] next = new int[] { curr[0] + d[0], curr[1] + d[1] };
                    String newKey = next[0] + "-" + next[1];
                    if (next[0] < 0 || next[0] >= grid.length || next[1] < 0 || next[1] >= grid[0].length
                            || visited.contains(newKey))
                        continue;
                    q.add(next);
                }
            }

            if (newPos)
                len++;
        }

        return len;
    }
}