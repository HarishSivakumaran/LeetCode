class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        HashSet<Integer> uniq = new HashSet();
        for(int n : nums) uniq.add(n);

        int l = 0, r = 0, ans = 0;
        while(r < nums.length) {
            count.put(nums[r], count.getOrDefault(nums[r], 0)+1);
            while(count.size() == uniq.size()) {
                ans += nums.length-r;
                if(count.get(nums[l]) > 1) {
                    count.put(nums[l], count.getOrDefault(nums[l], 0)-1);
                } else {
                    count.remove(nums[l]);
                }
                l++;
            }
            r++;
        }

        return ans;
    }
}