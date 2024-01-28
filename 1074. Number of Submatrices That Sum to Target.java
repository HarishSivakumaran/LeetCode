class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sumMatrix = new int[matrix.length][matrix[0].length];
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                sumMatrix[r][c] = (c-1 >= 0 ? sumMatrix[r][c-1] : 0) + 
                               (r-1 >= 0 ? (sumMatrix[r-1][c]-(c-1 >= 0 ? sumMatrix[r-1][c-1] : 0)) : 0) + 
                               matrix[r][c]; 
            }
        }

        int ans = 0;

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++) {
                for(int i = r; i < matrix.length; i++) {
                    for(int j = c; j < matrix[0].length; j++) {
                        if((sumMatrix[i][j] - (r-1 >= 0 ? sumMatrix[r-1][j]:0) - 
                        (c-1 >= 0 ? sumMatrix[i][c-1]:0)
                        +((r-1 >= 0 && c-1 >= 0) ? sumMatrix[r-1][c-1] : 0)) == target) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}