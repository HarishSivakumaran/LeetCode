class Solution {
    
    int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] safeMatrix = new int[grid.size()][grid.get(0).size()];
        Queue<int[]> q = new LinkedList();
        
        for(int r = 0; r < grid.size(); r++) {
            for(int c = 0; c < grid.get(r).size(); c++) {
                if(grid.get(r).get(c) == 1) {
                    q.add(new int[]{r, c});
                }
            }
        }
        
        int level = 0;
        
        while(q.size() > 0) {
            int len = q.size();
            
            for(int i = 0; i < len; i++) {
                int[] curr = q.poll();
                if(grid.get(curr[0]).get(curr[1]) == -1) continue; // already visited
                grid.get(curr[0]).set(curr[1], -1);
                safeMatrix[curr[0]][curr[1]] = level;
                
                for(int[] d : dir) {
                    if(curr[0]+d[0] < 0 || curr[0]+d[0] >= grid.size() ||
                       curr[1]+d[1] < 0 || curr[1]+d[1] >= grid.get(0).size() || 
                       grid.get(curr[0]+d[0]).get(curr[1]+d[1]) != 0) continue;
                    q.add(new int[]{curr[0]+d[0], curr[1]+d[1]});
                }
            }
            
            level++;
        }
        
        // bellmanford (maximum safepath(min point sp in a path))
        int[][] minSafePath = new int[grid.size()][grid.get(0).size()];
        minSafePath[0][0] = safeMatrix[0][0];
        int noOfNodes = safeMatrix.length*safeMatrix[0].length;
        
        for(int i = 0; i < noOfNodes-1; i++) {
            boolean change = false;
            for(int r = 0; r < safeMatrix.length; r++){
                for(int c = 0; c < safeMatrix[0].length; c++) {
                    for(int[] d : dir) {
                        if(r+d[0] < 0 || r+d[0] >= safeMatrix.length || c+d[1] < 0 || c+d[1] >= safeMatrix[0].length) continue;
                        if(minSafePath[r+d[0]][c+d[1]] < Math.min(minSafePath[r][c], safeMatrix[r+d[0]][c+d[1]])) {
                            minSafePath[r+d[0]][c+d[1]] = Math.min(minSafePath[r][c], safeMatrix[r+d[0]][c+d[1]]);
                            change = true;
                        }
                    }
                }
            }
            
            if(!change) break;
        }
        
        return minSafePath[minSafePath.length-1][minSafePath[0].length-1];

    }
}