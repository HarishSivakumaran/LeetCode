class Solution {
    public int maxSubarrays(int[] nums) {
        int noOfZeroSubarrays = 0, currAnd = Integer.MAX_VALUE;
        for(int n : nums) {
            currAnd &= n;
            if(currAnd == 0) {
                noOfZeroSubarrays++;
                currAnd = Integer.MAX_VALUE;
            }
        }  

        return  Math.max(1, noOfZeroSubarrays);
    }
}


/*class Solution {
    HashMap<Integer, int[]> cache = new HashMap();
    public int maxSubarrays(int[] nums) {
        int[] ans = getMin(nums, 0, new ArrayList());
        return ans[0];
    }
    
    private int[] getMin(int[] nums, int index, List<Integer> subArray) {
        if(index >= nums.length) {
            int[] ans = {0, 0}; //noOfSub, value
            if(subArray.size() > 0) {
                int v = subArray.get(0);
                for(int i = 1; i < subArray.size(); i++) {
                    v &= subArray.get(i);
                }
                ans[0] = 1;
                ans[1] = v;
            }
            return ans;
        }
        
        if(cache.containsKey(index)) return cache.get(index);
        
        int[] ans = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int v = Integer.MAX_VALUE;
        for(int i = index; i < nums.length; i++) {
            v &= nums[i];
            int[] possSplit = getMin(nums, i+1, new ArrayList());
            if(v+possSplit[1] < ans[1] || (v+possSplit[1] == ans[1] && (possSplit[0]+1 > ans[0]))) {
                ans[0] = possSplit[0]+1;
                ans[1] = v+possSplit[1];
            }   
        }
        
        cache.put(index, ans);
        
        return ans;
    }
} */