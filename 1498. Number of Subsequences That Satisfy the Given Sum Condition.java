class Solution {
    int mod = 1000000007;
    int[] pow;
    public int numSubseq(int[] nums, int target) {
        long sum = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        pow = new int[nums.length+1];
        pow[0] = 1;

        for(int i = 1; i < nums.length; i++){
            pow[i] = (2*(pow[i-1]))%mod;
        }

        while(l <= r) {
            while(l <= r && nums[l]+nums[r] > target) r--;  
            if(r-l >= 0){         
                sum += (pow[r-l]);
                sum %= mod;
                // check if l can be a standalone possible subSeq
                if(2*nums[l] > target) sum--;
            }
            l++;
        }

        return (int)sum;
    }

    private long getPow(long base, int pow){
        if(pow == 1) return base;
        if(pow == 0) return 1;
        long nextBase = (base*base)%mod;
        if(pow%2 == 0){
            return getPow(nextBase, pow/2)%mod;
        }else{
            return (base * (getPow(nextBase, (pow-1)/2)))%mod;
        }
    }
}