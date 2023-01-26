// 378. Kth Smallest Element in a Sorted Matrix

class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        //Binary Search Solution - Range based (not index based)
        int lo = matrix[0][0], hi = matrix[matrix.length-1][matrix[0].length-1];

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int count = 0, maxVal = lo, col = matrix.length-1;
            for(int row = 0; row < matrix.length; row++){
                while(col >=0 && matrix[row][col] > mid) col--;
                if(col >= 0){
                    count += col+1;
                    maxVal = Math.max(maxVal, matrix[row][col]);
                }
            }

            if(count == k) return maxVal;
            if(count < k){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }

        return lo;

        // int[] index = new int[matrix.length];
        // int ans = Integer.MAX_VALUE;

        // while(k > 0){
        //     int min = Integer.MAX_VALUE, minIndex = -1;
        //     for(int row = 0; row < matrix.length; row++){
        //         if(index[row] < matrix.length && min > matrix[row][index[row]]){
        //             min = matrix[row][index[row]];
        //             minIndex = row;
        //         }
        //     }
        //     ans = matrix[minIndex][index[minIndex]];
        //     index[minIndex]++;
        //     k--;
        // }

        // return ans;

        
    }
}