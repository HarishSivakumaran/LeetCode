// 283. Move Zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = 0;
                nums[insertPos] = temp;
                insertPos++;
            }
        }  
    }
}