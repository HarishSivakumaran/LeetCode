// 463. Island Perimeter

class Solution {
    int[][] dir = {{0,1}, {0,-1},{-1,0}, {1,0}};
    public int islandPerimeter(int[][] grid) {
        for(int i =0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;

    }

    public int dfs(int[][] grid, int r, int c){

        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 1;

        if(grid[r][c] == -1) return 0;

        grid[r][c] = -1;

        int s = 0;

        for(int[] d : dir){
            s += dfs(grid, r+d[0], c+d[1]);
        }       

        return s;

    } 
}