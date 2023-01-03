// 994. Rotting Oranges

class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int[][] minT = new int[grid.length][grid[0].length];
         for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                minT[i][j] = Integer.MAX_VALUE;
                if(grid[i][j] == 0){
                    minT[i][j] = 0;
                }
            }
        }  

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    traverseRot(grid,i,j,minT);
                }else if(grid[i][j] == 0){
                    minT[i][j] = 0;
                }
            }
        }  

        int max = -1;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && minT[i][j] == Integer.MAX_VALUE){
                    return -1;
                }
                max = Math.max(max, minT[i][j]);
            }
        }  

        return max;

    }

    public void traverseRot(int[][] grid, int r, int c, int[][] minT){
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair(r,c));
        int t = -1;
        while(q.size() > 0){
            int l = q.size();
            t++;
            for(int i = 0; i < l; i++){
                Pair<Integer,Integer> curr = q.poll();
                int row = curr.getKey();
                int col = curr.getValue();

                if(t > minT[row][col]) continue;

                minT[row][col] = Math.min(t, minT[row][col]);
                
                for( int[] d : this.dir ){
                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] != 1) continue;

                    q.add(new Pair(newRow, newCol));
                }
                
            }
            
        }
    }
}