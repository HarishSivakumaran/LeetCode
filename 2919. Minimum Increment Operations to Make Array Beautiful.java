class Solution {
    Long[] cache = null;
    public long minIncrementOperations(int[] nums, int k) {
        cache = new Long[nums.length];
        return getMin(nums, 0, k);
    }
    
    private long getMin(int[] nums, int index, int k) {
        if(index > nums.length-3) return 0;
        
        if(cache[index] != null) return cache[index];
        
        // level up
        long ans1 = Math.max(0, k-nums[index]) + getMin(nums, index+1, k);
        long ans2 = Math.max(0, k-nums[index+1]) + getMin(nums, index+2, k);
        long ans3 = Math.max(0, k-nums[index+2]) + getMin(nums, index+3, k);
        
        return cache[index] = Math.min(ans1, Math.min(ans2, ans3));
    }
}