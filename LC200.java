// 200. Number of Islands

class Solution {
    char[][] grid;
    public int numIslands(char[][] g) {
        int m = g.length;
        int n = g[0].length;
        int count = 0;
        this.grid = g;

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(this.grid[r][c] == '1'){
                    dfs(r,c);
                    count++;
                }
            }
        }      

        return count; 
    }

    public void dfs(int r, int c){
        if(this.grid[r][c] == '0'){
            return;
        }else{
            this.grid[r][c] = '0';

            //check top
            if(r > 0){
                dfs(r-1, c);
            }

            //check left
            if(c > 0){
                dfs(r, c-1);
            }

            //check right
            if(c < this.grid[0].length-1)
                 dfs(r,c+1);

            //check bottom
            if(r < this.grid.length-1){
                dfs(r+1,c);
            }     
        }
    }
}