// 378. Kth Smallest Element in a Sorted Matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] index = new int[matrix.length];
        int ans = Integer.MAX_VALUE;

        while(k > 0){
            int min = Integer.MAX_VALUE, minIndex = -1;
            for(int row = 0; row < matrix.length; row++){
                if(index[row] < matrix.length && min > matrix[row][index[row]]){
                    min = matrix[row][index[row]];
                    minIndex = row;
                }
            }
            ans = matrix[minIndex][index[minIndex]];
            index[minIndex]++;
            k--;
        }

        return ans;

        
    }
}