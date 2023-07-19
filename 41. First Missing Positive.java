class Solution {
    public int firstMissingPositive(int[] nums) {

        // key thing: for an array of size N, the answer will be
        // between 1 and n, irrespective of the values in arr
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) nums[i] = n+1;
        }

        for(int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if(val <= n){
                nums[val-1] = nums[val-1] > 0 ? -1*(nums[val-1]) : nums[val-1];
            }
        }

        for(int i = 0; i <n; i++){
            if(nums[i] > 0) return i+1;
        }

        return n+1;

        // Arrays.sort(nums);
        // int ans = 1;
 
        // for(int n : nums) {
        //     if(n == ans) ans++;
        //     if(n > ans) break;
        // }

        // return ans;
    }
}