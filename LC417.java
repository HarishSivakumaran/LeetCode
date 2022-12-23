// 417. Pacific Atlantic Water Flow

class Solution {
    int r,c;
    boolean[][] p,a;
    int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1,0}}; // RLBT
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.r = heights.length;
        this.c = heights[0].length;
        this.p = new boolean[this.r][this.c];
        this.a = new boolean[this.r][this.c];
        List<List<Integer>> out = new ArrayList<>();

        for(int i = 0; i < this.r; i++){
            DFS(heights,i , 0, Integer.MIN_VALUE, p);
            DFS(heights,i , this.c-1,Integer.MIN_VALUE, a);

        }
        
        for(int i = 0; i < this.c; i++){
            DFS(heights, 0 ,i ,  Integer.MIN_VALUE, p);
            DFS(heights, this.r-1, i , Integer.MIN_VALUE, a);
        }

        for(int i = 0; i<this.r; i++){
            for(int j = 0; j < this.c; j++){
                if(a[i][j] && p[i][j]){
                    out.add(Arrays.asList(i,j));
                }
            }
        }
        return out;


    }

    public void DFS( int[][] h, int r, int c, int prev, boolean[][]a){
        if(r < 0 || r >= this.r || c < 0 || c >= this.c) return; //border check
        if(h[r][c] < prev || a[r][c]) return; // Lower altitude or Already true(reachable) 

        a[r][c] = true;

        for(int[]d : dir){
            DFS(h, r + d[0], c+ d[1], h[r][c], a);
        }



        
    }
}