class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0, r = 0, c = grid[0].length-1, n = grid.length;

        while(r < n && c >= 0){
            if(grid[r][c] < 0){
                count += (n-r);
                c--;
                continue;
            }
            r++;
        }

        return count;
    }
}