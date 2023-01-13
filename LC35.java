// 35. Search Insert Position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1, p = 0;

        while(l <= r){
            int m = l + (r-l)/2;

            if(nums[m] == target){
                return m;
            }

            if(nums[m] > target){
                p = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }

        return l > p ? l : p;

    }
}