class Solution {
    public int numSpecial(int[][] mat) {
        int ans = 0;

        HashMap<Integer, Integer> rows = new HashMap(), cols = new HashMap();
        for(int r =0; r < mat.length; r++) {
            for(int c = 0; c < mat[0].length; c++) {
                if(mat[r][c] == 1) {
                    rows.put(r, rows.getOrDefault(r, 0)+1);
                    cols.put(c, cols.getOrDefault(c, 0)+1);
                }
            }
        }

        for(int r = 0; r < mat.length; r++) {
            for(int c = 0; c < mat[0].length; c++) {
                if(mat[r][c] == 1 && rows.get(r) == 1 && cols.get(c) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}