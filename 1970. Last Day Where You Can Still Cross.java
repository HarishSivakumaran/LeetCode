class Solution {

    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 0, r = cells.length-1;

        while(l <= r){
            int m = l + (r-l)/2;
            int[][] arr = new int[row][col];
            for(int i = 0; i <= m; i++){
                arr[cells[i][0]-1][cells[i][1]-1] = 1;
            }

            if(canCross(arr)){
                l = m+1;
            }else{
                r = m-1;
            }
        }

        return r+1;
    }

    private boolean canCross(int[][] arr){
        for(int i = 0; i < arr[0].length; i++){
            if((i == 0 || arr[0][i-1] != 0 ) && arr[0][i] == 0){
                if(crossable(arr, 0, i)) return true;
            }
        }

        return false;
    }

    private boolean crossable(int[][] arr, int r, int c) {
        if(r < 0 || c < 0 || c >= arr[0].length || r >= arr.length || arr[r][c] != 0 ) return false;
        if(r >= arr.length-1) return true;

        boolean canCross = false;
        arr[r][c] = -1;
        for(int[] d : dir){
            canCross = canCross | crossable(arr, r+d[0], c+d[1]);
        }

        return canCross;
    }
}