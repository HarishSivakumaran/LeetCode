class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, r = 0, currSum = 0, ans = Integer.MAX_VALUE;

        while(r < nums.length) {
            currSum += nums[r];
            while(currSum >= target){
                ans = Math.min(ans, r-l+1);
                currSum -= nums[l++];
            }

            r++;
        }
         
        // int[] preSum = new int[nums.length];
        // preSum[0] = nums[0];
        // for(int i = 1; i < nums.length; i++) preSum[i] = preSum[i-1] + nums[i];
        // int ans = Integer.MAX_VALUE;

        // for(int i = -1; i < preSum.length; i++){
        //     int start = i < 0 ? 0 : preSum[i];
        //     int expVal = start+target;
        //     int end = getNextGreaterOrEqualIndex(preSum, expVal);

        //     if(end < preSum.length){
        //         ans = Math.min(ans, end-i);
        //     }
        // }

        return ans == Integer.MAX_VALUE ? 0 : ans;

    }

    private int getNextGreaterOrEqualIndex(int[] p, int val){
        int l = 0, r = p.length-1, m = 0;

        while(l <= r) {
            m = l + (r-l)/2;
            if(p[m] < val){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l;
    }
}