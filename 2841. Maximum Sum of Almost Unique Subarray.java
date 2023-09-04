class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        int l = 0, r = 0;
        long sum = 0, ans = 0;
        while(r < nums.size()) {
            count.put(nums.get(r), count.getOrDefault(nums.get(r), 0)+1);
            sum += nums.get(r);
            
            if(r-l+1 > k) {
                if(count.get(nums.get(l)) > 1) {
                    count.put(nums.get(l), count.get(nums.get(l))-1);
                } else {
                    count.remove(nums.get(l));
                }
                sum -= nums.get(l++);
            }
            
            if(r-l+1 == k && count.size() >= m) ans = Math.max(ans, sum);
            r++;
        }
        
        return ans;
    }
}