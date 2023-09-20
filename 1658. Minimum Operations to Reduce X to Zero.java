class Solution {
    public int minOperations(int[] nums, int x) {
        // largest subarray with sum totalsum-x
        int res = -1, total = 0;
        for(int n : nums) total += n;
        if(total == x) return nums.length;
        HashMap<Integer, Integer> subArrSum = new HashMap();
        subArrSum.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(subArrSum.containsKey(sum-(total-x))) {
                res = Math.max(res, i-subArrSum.get(sum-(total-x)));
            }
            subArrSum.put(sum, i);
        }

        return res == -1 ? -1 : nums.length-res;


    }
}


// class Solution {
//     HashMap<String, Integer> cache = new HashMap();
//     public int minOperations(int[] nums, int x) {
//         int val = getMin(nums, 0, nums.length-1, x);
//         return val > 99999 ? -1 : val;
//     }

//     private int getMin(int[] nums, int l, int r, int x) {
//         if(x == 0) return 0;
//         if(l > r || x < 0) return 99999;

//         String key = l+"-"+r+"-"+x;

//         if(cache.containsKey(key)) return cache.get(key);

//         // take left
//         int min = 1 + getMin(nums, l+1, r, x-nums[l]);

//         //take right
//         int rMin = 1 + getMin(nums, l, r-1, x-nums[r]);

//         cache.put(key, Math.min(min, rMin));

//         return Math.min(min, rMin);
//     }
// }