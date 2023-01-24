// 75. Sort Colors

class Solution {
    public void sortColors(int[] nums) {        
        int l = 0, i = 0, r = nums.length-1, temp = 0;

        while(i <= r){
            if(nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
                i++;
            }else if(nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
            }else{
                i++;
            }
        }        
    }
}