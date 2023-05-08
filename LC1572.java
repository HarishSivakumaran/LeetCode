// 1572. Matrix Diagonal Sum

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int c = mat.length - 1;
        for (int r = 0; r < mat.length; r++) {
            if (mat.length % 2 != 0 && r == mat.length / 2) {
                sum += mat[r][r];
                continue;
            }

            sum += mat[r][r] + mat[r][c - r];
        }
        return sum;
    }
}