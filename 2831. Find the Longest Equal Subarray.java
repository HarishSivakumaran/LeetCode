class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int l = 0, r = 0, maxF = 0, ans = 0;
        HashMap<Integer, Integer> count = new HashMap();
        
        while(r < nums.size()) {
            count.put(nums.get(r), count.getOrDefault(nums.get(r), 0) + 1);
            maxF = Math.max(maxF, count.get(nums.get(r)));
            if(r-l+1-maxF > k) {
                count.put(nums.get(l), count.get(nums.get(l)) - 1);
                l++;                
            }

            ans = Math.max(maxF, ans);
            r++;            
        }
        return ans;
    }
}