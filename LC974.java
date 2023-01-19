// 974. Subarray Sums Divisible by K

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;

        int[] mods = new int[k];
        mods[0] = 1;
        int sum = 0;

        for(int n : nums){
            sum += n;
            int mod = (sum%k +k)%k;

            count += mods[mod];
            mods[mod]++;
        }

        // for(int i = 0; i < nums.length; i++){
        //     int s = 0;
        //     for(int j = i; j < nums.length; j++){
        //         s +=nums[j];
        //         if(s % k == 0) count++;
        //     }
        // }

        return count;
        
    }
}