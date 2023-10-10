class Solution {
    public int minOperations(int[] nums) {
        int len = nums.length;

        TreeSet<Integer> set = new TreeSet();
        for(int n : nums) set.add(n);
        int[] uniqNums = new int[set.size()];

        int i = 0;
        for(int n : set) uniqNums[i++] = n;

        int ans = len;

        for(i = 0; i < uniqNums.length; i++) {
            int left = uniqNums[i];
            int right = left+len-1;
            int pos = getNextMinIndex(uniqNums, right);
            ans = Math.min(ans, len-(pos-i+1));
        }
        
        return ans;

    }

    private int getNextMinIndex(int[] nums, int target) {
        int l = 0, r = nums.length-1, m = 0;
        while(l <= r) {
            m = l + (r-l)/2;
            if(nums[m] > target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return r >= 0 ? r : -1;
    }
}