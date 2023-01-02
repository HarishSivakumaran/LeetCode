// 130. Surrounded Regions
// 

class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        for(int i= 0; i < board[0].length; i++){
            nonCaptureZeroes(board, 0, i);
            nonCaptureZeroes(board, board.length-1, i);
        }
        for(int i= 0; i < board.length; i++){
            nonCaptureZeroes(board,i, 0);
            nonCaptureZeroes(board,i, board[0].length-1);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }        
    }


    public void nonCaptureZeroes(char[][] board ,int r, int c){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O'){
            return ;
        }

        board[r][c] = 'T';

        for(int[] d : this.dir){
            nonCaptureZeroes(board, r + d[0], c+d[1]);
        }

        
    }
}