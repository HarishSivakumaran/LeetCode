class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
       int[][] out = new int[grid.length][grid[0].length];
        k = k%(grid.length*grid[0].length);
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                int nextR = (((r*grid[0].length)+c+k)/(grid[0].length));
                if(nextR >= grid.length) nextR %= grid.length;
                int nextC = ((r*grid[0].length)+c+k)%(grid[0].length);
                out[nextR][nextC] = grid[r][c];
            }
        }
        return (List)Arrays.asList(out);
    }
}