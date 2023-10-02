class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        int size = (int)(target/sum);
        target %= sum;
        int outertarget = (int)sum-target;
        int maxLen = -1, minLen = 100001;
        HashMap<Integer, Integer> index = new HashMap();
        index.put(0, -1);
        int prefix = 0;

        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if(index.containsKey(prefix-outertarget)) {
                maxLen = Math.max(maxLen, i-index.get(prefix-outertarget));
            }
            if(index.containsKey(prefix-target)) {
                minLen = Math.min(minLen, i-index.get(prefix-target));
            }
            index.put(prefix, i);
        }
        
        return maxLen == -1 && minLen >= 100001 ? -1 : 
        Math.min((size*nums.length) + (nums.length-maxLen), (size*nums.length) + (minLen));
    }
}