// 1498. Number of Subsequences That Satisfy the Given Sum Condition

class Solution {
    // List<Integer> ans = new ArrayList();
    // int count = 0;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int[] pow = new int[nums.length + 1];
        pow[0] = 1;

        for (int i = 1; i < pow.length; i++)
            pow[i] = (pow[i - 1] * 2) % 1000000007;

        int l = 0, r = nums.length - 1, sum = 0;

        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                sum = (sum + pow[r - l]) % 1000000007;
                l++;
            } else {
                r--;
            }
        }

        return sum;
    }

    // public void getSubSeq(int[] nums, int t, int i){

    // if(i == nums.length){
    // if(ans.size() > 0 && ans.get(0) + ans.get(ans.size()-1) <= t) count++;
    // return;
    // }

    // if(ans.size() > 0 && ans.get(0) + ans.get(ans.size()-1) > t) return;

    // ans.add(nums[i]);
    // getSubSeq(nums, t, i+1);
    // ans.remove((int)ans.size()-1);
    // getSubSeq(nums, t, i+1);

    // }
}