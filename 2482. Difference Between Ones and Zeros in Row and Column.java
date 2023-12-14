class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        HashMap<Integer, Integer> rows = new HashMap(), cols = new HashMap();
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    rows.put(r, rows.getOrDefault(r, 0)+1);
                    cols.put(c, cols.getOrDefault(c, 0)+1);
                }
            }
        }

        int t = grid.length + grid[0].length;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                grid[r][c] = rows.getOrDefault(r, 0) + cols.getOrDefault(c, 0);
                grid[r][c] -= (t-grid[r][c]);
            }
        }

        return grid;

    }
}