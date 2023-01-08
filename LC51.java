// 51. N-Queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> out = new ArrayList<>();
        int[][] pos = new int[n][n];
        int[] res = new int[n];
         btQueens(pos, 0, out, n, res);
         return out;
    }

    public void btQueens(int[][] pos, int level, List<List<String>> out, int n, int[] res){

        if(level == n){
            List<String> o = new ArrayList();
            for(int i = 0; i < n; i++){
                int p = res[i];
                String r = "";
                for(int j = 0; j < n; j++){
                    String b = (j == p ) ? "Q" : ".";
                    r = r + b;               
                }
                o.add(r);
            }
            out.add(o);         
        }

        if(level >= n) return;


        for(int j = 0; j < n; j++){
            if(pos[level][j] == 0){
                // possible queen position
                res[level] = j; 
               this.markOrUnmarkPaths(pos, level, j, 1, n);
               btQueens(pos,level+1, out, n, res);
               this.markOrUnmarkPaths(pos, level, j, -1, n);
            }
        }        
        
    }

    public void markOrUnmarkPaths(int[][] pos, int r, int c, int i, int n){
        for(int p = 0; p < n; p++){
            pos[r][p] += i;
            pos[p][c] += i;
        }

        int j = r+1, k = c+1;

        while(j < n && k < n){
            pos[j][k] += i;
            j++;
            k++;
        }
        j = r+1;
        k = c-1;

        while(j < n && k >= 0){
            pos[j][k] += i;
            j++;
            k--;
        }


    }
}