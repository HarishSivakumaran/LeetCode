// 560. Subarray Sum Equals K

class Solution {
    public int subarraySum(int[] nums, int k) {
        // no of subarrays that'll add up to sum'
        HashMap<Integer, Integer> sumSub = new HashMap();
        int sum = 0, res = 0;

        for (int n : nums) {
            sum += n;
            if (sum == k)
                res++;
            if (sumSub.containsKey(sum - k))
                res += sumSub.get(sum - k);
            sumSub.put(sum, sumSub.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}