// 62. Unique Paths
// // 

class Solution {
    int[][] dir = {{0,1}, {1,0}}; //RB
    public int uniquePaths(int m, int n) {
        int[][] uP = new int[m][n];
        uP[m-1][n-1] = 1;
        dfs(uP, 0, 0);
        return uP[0][0];
    }

    public int dfs(int[][] a, int r, int c){
        if(r < 0 || r >= a.length || c < 0 || c >= a[0].length ) return 0;

        if(a[r][c] > 0) return a[r][c];

        int count = 0;

        for(int[] d : this.dir){
             count += dfs(a, r+d[0], c+d[1]);
        }
        
        a[r][c] = count;

        return count;

    }
}