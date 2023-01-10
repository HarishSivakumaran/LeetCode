// 329. Longest Increasing Path in a Matrix

class Solution {
    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int longestIncreasingPath(int[][] matrix) {

        int[][] maxIncPath = new int[matrix.length][matrix[0].length];
        int res = -1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                res = Math.max(res,dfs(matrix, maxIncPath, i, j, -1) );
            }
        }

        return res;
        
    }
    public int dfs(int[][] matrix, int[][] maxIncPath, int r, int c, int prev){
        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length ||  matrix[r][c] <= prev) return 0;

        if(maxIncPath[r][c] > 0) return maxIncPath[r][c];

        int max = 0;
        for(int[] d : dir){
            max = Math.max(max, dfs(matrix, maxIncPath, r + d[0], c + d[1],  matrix[r][c]));
        }

        maxIncPath[r][c]  = max + 1;

        return maxIncPath[r][c];

    }
}