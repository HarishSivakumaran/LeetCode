class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0.0;
        double[][] pyramid = new double[100][100];
        pyramid[0][0] = poured;
        for(int r = 1; r <= query_row; r++) {
            for(int c = 0; c <= r; c++) {
                double tl = c-1 >= 0 ? pyramid[r-1][c-1] : 0.0;
                tl = tl > 1 ? tl-1 : 0;
                double t  = c < r ? pyramid[r-1][c] : 0.0;
                t = t > 1 ? t-1 : 0.0;
                pyramid[r][c] = (tl/2.0) + (t/2.0);
            }
        }

        return pyramid[query_row][query_glass] >= 1.0 ? 1.0 : pyramid[query_row][query_glass];
    }
}