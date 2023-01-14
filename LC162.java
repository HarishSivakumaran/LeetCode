// 162. Find Peak Element

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 2) return 0;

        int l = 0, r = nums.length-1;

        while(l < r){
            int m = (l+r)/2;

            if(nums[m] > nums[m+1]){ //decreasing slope
                r = m;
            }else{
                l = m+1;
            }
        }

        return l;
        
        // int prev = nums[0];
        // int i = 1;
        // for(; i < nums.length; i++){
        //     if(nums[i] < prev){
        //         return  i - 1;
        //     }else{
        //         prev = nums[i];
        //     }
        // }

        // return i - 1;
    }
}