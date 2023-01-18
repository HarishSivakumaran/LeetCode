// 918. Maximum Sum Circular Subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        Integer max_till_here = 0, maxSum = Integer.MIN_VALUE;
        Integer min_till_here = 0, minSum = Integer.MAX_VALUE;
        int total = 0;

        for(int n : nums){
            max_till_here += n;
            maxSum = Math.max(maxSum, max_till_here);
            if(max_till_here < 0) max_till_here = 0;
            min_till_here += n;
            minSum = Math.min(minSum, min_till_here);
            if(min_till_here > 0) min_till_here = 0;
            total += n;
        }

        return total == minSum ? maxSum : Math.max(maxSum, total-minSum);
        
    }
}