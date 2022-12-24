// 73. Set Matrix Zeroes
class Solution {
    public void setZeroes(int[][] m) {
        boolean fRow = false, fCOl = false;
        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[0].length; c++){
                if(m[r][c] == 0){
                    m[0][c] = 0;
                    if(r == 0 ){
                        fRow = true;  
                    }else{
                        m[r][0] = 0; 
                    }
                }            
            }
        }

        for(int r = 1; r < m.length; r++){
            for(int c = 1; c < m[0].length; c++){
               if(m[r][0] == 0){
                  m[r][c] = 0;
               }
               if(m[0][c] == 0){
                  m[r][c] = 0;
               }
            }
        }

        if(m[0][0] == 0){
             for(int r = 1; r < m.length; r++){
                 m[r][0] = 0;
             }
        }

        if(fRow){
             for(int c = 0; c < m[0].length; c++){
                 m[0][c] = 0;
             }
        }
    }
}