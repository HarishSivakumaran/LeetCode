// 304. Range Sum Query 2D - Immutable

class NumMatrix {
    int[][] sum = null;

    public NumMatrix(int[][] matrix) {

        sum = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum[i][j] = matrix[i][j];
                if (j - 1 >= 0) {
                    matrix[i][j] += matrix[i][j - 1];
                    sum[i][j] = matrix[i][j];
                }
                if (i - 1 >= 0)
                    sum[i][j] += sum[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumRes = sum[row2][col2];
        // top
        if (row1 > 0)
            sumRes -= sum[row1 - 1][col2];
        // left
        if (col1 > 0)
            sumRes -= sum[row2][col1 - 1];

        if (row1 > 0 && col1 > 0)
            sumRes += sum[row1 - 1][col1 - 1];

        return sumRes;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */