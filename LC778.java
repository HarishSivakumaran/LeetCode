// 778. Swim in Rising Water

class Solution {
    int[][] dir ={{0,1}, {1,0}, {0,-1},{-1,0}};
    public int swimInWater(int[][] grid) {
        HashSet<String> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});

        while(pq.size()>0){
            int[] curr = pq.poll();
            String key = curr[1] + "-" + curr[2];
            if(visited.contains(key)) continue;
            visited.add(key);

            for(int[] d : dir){
                int[] pNext = new int[]{curr[1]+d[0], curr[2]+d[1]};
                if(pNext[0] < 0 || pNext[0] >= grid.length || pNext[1] < 0 || pNext[1] >= grid[0].length) continue;
                if(pNext[0] == grid.length-1 && pNext[1] == grid[0].length-1) return Math.max(grid[pNext[0]][pNext[1]], curr[0]);
                pq.add(new int[]{Math.max(grid[pNext[0]][pNext[1]], curr[0]), pNext[0], pNext[1]} );
            }

        }

        return 0;
    }
}