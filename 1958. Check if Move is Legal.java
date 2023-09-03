class Solution {
    int[][] dir = {{0,1}, {1,1}, {1, 0}, {1,-1}, 
                   {0, -1}, {-1,-1}, {-1, 0}, {-1, 1}};

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;

        boolean isPoss = false;

        for(int[] d: dir) {
            isPoss |= check(board, rMove, cMove, 
            color, color == 'W' ? 'B' : 'W', 0, d);
            if(isPoss) return true;
        }

        return false;
    }

    private boolean check(char[][] board, int r, int c,
     char color, char oppCol, int level, int[] d) {
        if(r < 0 || c < 0 || r >= board.length || 
           c >= board[0].length || board[r][c] == '.') return false;
        
        if(level > 1 && board[r][c] == color) return true;
        if(level == 0 || board[r][c] == oppCol) {
            return check(board, r+d[0], c+d[1], color, oppCol, level+1, d);
        }

        return false;
    }
}