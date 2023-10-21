class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a, b) -> b[0]-a[0] // maxSumSubSeq, index
        );

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            while(pq.size() > 0 && i-pq.peek()[1] > k) pq.poll();
            dp[i] = nums[i]+(pq.size() > 0 && pq.peek()[0] > 0 ? pq.peek()[0] : 0);
            pq.add(new int[]{dp[i], i});
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

/* 
class Solution {
    HashMap<String, Integer> cache = new HashMap();
    public int constrainedSubsetSum(int[] nums, int k) {
        return getMaxSum(nums, 0, nums.length+1, k);
    }

    private int getMaxSum(int[] nums, int index, int lastIndex, int k) {
        if(index >= nums.length || index-lastIndex > k) return lastIndex == nums.length+1 ? -999999 : 0;

        String key = lastIndex + "-" + index;
        if(cache.containsKey(key)) return cache.get(key);
 
        // add
        int sumWith = nums[index] + getMaxSum(nums, index+1, index, k); 

        int sumWithout = Integer.MIN_VALUE;

        //remove
        sumWithout = getMaxSum(nums, index+1, lastIndex, k);

        cache.put(key, Math.max(sumWith, sumWithout));

        return cache.get(key);
    }
}
*/