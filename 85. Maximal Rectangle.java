
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                if(matrix[r][c] == '0'){
                    heights[c] = 0;
                } else {
                    heights[c]++;
                }
            }

            ans = Math.max(ans, largestHistogram(heights));
        }

        return ans;
    }

    private int largestHistogram(int[] h) {
        Stack<int[]> stack = new Stack(); //height,from
        int ans = 0;
        for(int i = 0; i <= h.length; i++) {
            int currH = i < h.length ? h[i] : 0;
            int from = i;
            while(!stack.isEmpty() && (currH <= stack.peek()[0])) {
                int[] curr = stack.pop();
                ans = Math.max(ans, (i-curr[1])*curr[0]);
                from = curr[1];
            }
            stack.push(new int[]{currH, from});
        }
        return ans;
    }
}