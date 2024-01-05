class Solution {
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int[] in = {0, 0, 0}; // r, c, effort
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a,b) -> a[2]-b[2]
        );

        pq.add(in);
        //Dijkstra's algorithm
        while(pq.size() > 0) {
            int[] curr = pq.poll();
            if(heights[curr[0]][curr[1]] == -1) continue; //visited
            int val = heights[curr[0]][curr[1]];
            heights[curr[0]][curr[1]] = -1;
            if(curr[0] == heights.length-1 && curr[1] == heights[0].length-1) return curr[2];

            for(int[] d : dir) {
                int r = curr[0] + d[0], c = curr[1] + d[1];
                if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || heights[r][c] == -1) continue;
                pq.add(new int[] {r, c, Math.max(curr[2], Math.abs(val-heights[r][c]))});
            } 

        }

        return -1;
    }
}