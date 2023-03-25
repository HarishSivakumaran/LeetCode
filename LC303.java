// 303. Range Sum Query - Immutable

class NumArray {
    int[] sum = null;

    public NumArray(int[] nums) {
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += prev;
            prev = nums[i];
        }
        sum = nums;

    }

    public int sumRange(int left, int right) {
        return left == 0 ? sum[right] : sum[right] - sum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */