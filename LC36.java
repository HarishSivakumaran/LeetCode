// 36. Valid Sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] isRepeatingRow = new boolean[10][10];
        boolean[][] isRepeatingCol = new boolean[10][10];
        int[][] startingpoints = {  {0,0}, {0,3}, {0,6},
                                    {3,0}, {3,3}, {3,6},
                                    {6,0}, {6,3}, {6,6}};
       
    for(int s = 0; s < 9; s++){
        int[] i1 = startingpoints[s];
         HashSet<Character> h = new HashSet();
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){                
                char a1 = board[i1[0]+r][i1[1]+c];
                if(a1 == '.') continue;
                int pos = a1-'0';
                //check for row
                if(isRepeatingRow[i1[0]+r][pos]) return false;
                   isRepeatingRow[i1[0]+r][pos] = true;
                
                // //check for col
                if(isRepeatingCol[pos][i1[1]+c]) return false;
                   isRepeatingCol[pos][i1[1]+c] = true;

                // check for box
                if(h.contains(a1)) return false;
                    h.add(a1);

                 
            }


            }
        }

        return true;
        
    }
}