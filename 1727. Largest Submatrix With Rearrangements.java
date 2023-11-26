class Solution {
    public int largestSubmatrix(int[][] matrix) {
        //largest histogram and then sort
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        for(int r = 0; r < matrix.length; r++) {
            int[] copy = new int[heights.length];
            for(int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == 0) {
                    heights[c] = 0;
                } else {
                    heights[c]++;
                }
                copy[c] = heights[c];
            }

            Arrays.sort(copy);

            for(int i = copy.length-1; i >= 0; i--){
                if((copy.length-(i))*copy[i] > ans) ans = (copy.length-(i))*copy[i];
            }
        }

        return ans;
    }
}