// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {

//         int n = matrix[0].length-1;

//         int l =0, r = matrix.length-1;

//         while(l < r){
//           int m = (l+r)/2;
//           if(target == matrix[m][0] || target == matrix[m][n] ){
//               return true;
//           }else if (target > matrix[m][n]){
//               l = m+1;
//           }else if (target < matrix[m][0]){
//               r = m-1;
//           }else {
//               l = m;
//               r = m;
//           }
//         }

//         t = matrix[l];
        
//         return binarySearch(t,0, t.length-1, target);
//     }
    
//     public boolean binarySearch(int[]n, int l, int r, int t){
//         int m = (int) (l+r)/2;
        
//         if(l == r){
//             return n[l] == t;
//         }
        
//         if(n[m] == t){
//             return true;
//         }else if(t > n[m]){
//             return this.binarySearch(n,m+1 > r? r : m+1,r,t);
//         }else if(t < n[m]){
//            return this.binarySearch(n,l,m-1 < l ? l : m - 1,t);
//         }
//         return false;
//     }
// }