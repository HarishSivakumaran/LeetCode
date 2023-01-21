// 289. Game of Life

class Solution {
    int[][] dir = {{0,1}, {1,1}, {1,0}, {1,-1},{0,-1},{-1,-1}, {-1,0}, {-1,1} };
    public void gameOfLife(int[][] board) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean isDOA = isDeadOrAlive(i,j, board);
                
                if(board[i][j] == 0 && isDOA){
                    // D -> A
                    board[i][j] = -2;
                }

                if(board[i][j] == 1 && !isDOA){
                    // A -> D
                    board[i][j] = 2;
                }
            }
        }

           for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 2){      board[i][j] = 0;          }
                if(board[i][j] == -2){     board[i][j] = 1;          }
            }
        }

    }

    public boolean isDeadOrAlive(int r, int c, int[][] b){
        int ones = 0;

        for(int[] d : dir){
            int i = r + d[0], j = c + d[1];
            if(i < 0 || i >= b.length || j < 0 || j >= b[0].length) continue;
            
            if(b[i][j] > 0 ) ones++;
        }

        if(b[r][c] == 1){
            return ones == 2 || ones == 3;
        }

        if(b[r][c] == 0){
            return ones == 3;
        }

        return false;
    }
}
