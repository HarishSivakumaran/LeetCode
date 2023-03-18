// 523. Continuous Subarray Sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sum = new HashMap();
        int s = 0, mod = 0;
        sum.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            mod = s % k;
            if (sum.containsKey(mod)) {
                if (i - sum.get(mod) >= 2)
                    return true;
                continue;
            }
            sum.put(mod, i);
        }

        return false;

    }
}