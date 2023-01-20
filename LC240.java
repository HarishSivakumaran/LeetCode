// 240. Search a 2D Matrix II

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1;

        while(col >= 0 && row < matrix.length){
            if(matrix[row][col] == target){
                return true;
            }else if(target > matrix[row][col]){
                row++;
            }else{
                col--;
            }
        }

        return false;
      
    }
}