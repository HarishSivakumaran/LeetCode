// 219. Contains Duplicate II

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;
        HashSet<Integer> set = new HashSet();
        int l = 0, r = 0;
        while (r < nums.length && r <= k) {
            if (set.contains(nums[r])) {
                return true;
            }
            set.add(nums[r++]);
        }
        r--;

        while (r < nums.length - 1) {
            set.remove(nums[l++]);
            if (set.contains(nums[++r]))
                return true;
            set.add(nums[r]);
        }

        return false;

    }
}