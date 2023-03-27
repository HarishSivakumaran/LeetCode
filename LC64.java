// 64. Minimum Path Sum

class Solution {
    int[][] dir = {{0,1} , {1, 0}};

    HashMap<String, Integer> map = new HashMap();
    public int minPathSum(int[][] grid) {
        return dfs(0, 0 , grid);
    }

    public int dfs(int r, int c, int[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return 10000;

        if(r == grid.length-1 && c == grid[0].length-1 ) return grid[r][c];

        String key = r + "-" + c;

        if(map.containsKey(key)) return map.get(key);

        int len = Integer.MAX_VALUE;

        for(int[] d : dir){
            len = Math.min(len, dfs(r+d[0], c+d[1], grid));
        }
        len += grid[r][c];

        map.put(key, len);

        return len;

    }
}