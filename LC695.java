// 695. Max Area of Island

class Solution {
    int max = 0, count = 0;
    int[][] dir = { {0, 1}, {1,0}, {0,-1}, {-1,0}}; //RBLT
    public int maxAreaOfIsland(int[][] grid) {
        for(int r = 0; r < grid.length; r++){        
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1){
                    //found land
                    findArea(grid, r, c);
                    this.max = Math.max(this.max, this.count);
                    this.count = 0;


                }
                
            }
        }      
        return this.max; 
    }

    public void findArea(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 ) return;

        this.count++;
        grid[r][c] = 0;


        for(int[] d : this.dir){
            findArea(grid, r+d[0], c+d[1]);
        }


    }
}