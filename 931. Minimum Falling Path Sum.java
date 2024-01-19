class Solution {
    int[][] dir = {{1, -1}, {1,0}, {1, 1}};
    Integer[][] cache = null;
    public int minFallingPathSum(int[][] matrix) {
        int ans = 99990;
        cache = new Integer[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++ ) ans = Math.min(ans, getMin(0, i, matrix));
        return ans;
    }
    private int getMin(int r, int c,  int[][] matrix) {
        if(r >= matrix.length) return 0;
        if(cache[r][c] != null) return cache[r][c];
        int min = 999999;
        for(int[] d : dir) {
            int nR = r + d[0], nC = c + d[1];
            if(nC < 0 || nC >= matrix.length) continue;
            min = Math.min(min, matrix[r][c] + getMin(nR, nC, matrix));
        }
        return cache[r][c] = min;
    }
}
/*
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[2]-b[2]); //r, c, sum
        int n = matrix.length;
        int[][] dir = {{1, 0}, {1,-1}, {1, 1}};
        for(int i = 0; i < matrix[0].length; i++) {
            q.add(new int[]{0, i, matrix[0][i]});
        }
        while(q.size() > 0) {
            int len = q.size();
            int[] curr = q.poll();
            if(curr[0] == n-1) return curr[2];
            for(int[] d : dir) {
                    int r = curr[0]+d[0], c = curr[1]+d[1];
                    if(r >= n || c >= n || c < 0) continue;
                    q.add(new int[]{r, c, curr[2]+matrix[r][c]});
            }
        }

        return -1;
    }
}

 */