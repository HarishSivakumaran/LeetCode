// 54. Spiral Matrix


class Solution {
    int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1,0}}; //RBLT
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out = new ArrayList<>();    
        traverseSpiral(matrix , 0, 0, out ,0);  
        return out;
    }

    public void traverseSpiral(int[][] m, int r, int c,  List<Integer> out ,int dir){
        if(r < 0 || r >= m.length || c < 0 || c >= m[0].length || m[r][c] < -101 ) return;
        out.add(m[r][c]);
        m[r][c] = -200;
        int[] d = this.dir[dir];
         if(r + d[0] < 0 || r + d[0] >= m.length || c + d[1] < 0 || c + d[1] >= m[0].length || m[r + d[0]][c + d[1]] < -101 ){
             //change direction
             dir = (dir+1)%4;
             d = this.dir[dir];
         }
        traverseSpiral(m , r + d[0], c + d[1], out, dir);
    }
}