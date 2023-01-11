// 724. Find Pivot Index

class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 1) return 0;

        int s = 0;

        for(int i : nums){
            s +=i;
        }
        int t = 0;
        for(int i = 0; i < nums.length; i++){
            int j = nums[i];
            if((s-j)%2 == 0 && (t == (s-j)/2)) return i;
            t += j;
        }
    return -1;       
    }
}