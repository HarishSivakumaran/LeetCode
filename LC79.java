// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// 79. Word Search

class Solution {
    boolean result = false;
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                 DFS(board,i, j, 0, word);
            }
        }

        return this.result;
    }

    public void DFS(char[][] b, int r, int c, int i, String word){
        if(r < 0 || r >= b.length || c < 0 || c >= b[0].length || this.result) return;
        if(b[r][c] == word.charAt(i)){
            if(i == word.length() - 1){
              this.result = true;
              return;
            } 
            b[r][c] +=100;
            for(int[] d : dir){
                DFS(b,r + d[0], c + d[1], i+1, word);
            }
            b[r][c] -=100;
        }
    }
}