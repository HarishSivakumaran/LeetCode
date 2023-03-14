// 34. Find First and Last Position of Element in Sorted Array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int l = 0, r = nums.length - 1, m = 0;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                res[0] = m;
                res[1] = m;
                getMinMax(nums, target, res, m);
                return res;
            }

            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    public void getMinMax(int[] nums, int target, int[] res, int m) {
        int l = 0, r = m - 1, k = 0;

        while (l <= r) {
            k = l + (r - l) / 2;
            if (nums[k] < target) {
                l = k + 1;
            } else {
                r = k - 1;
            }
        }

        res[0] = l;

        l = m + 1;
        r = nums.length - 1;

        while (l <= r) {
            k = l + (r - l) / 2;
            if (nums[k] > target) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        res[1] = r;
    }
}