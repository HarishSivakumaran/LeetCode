// 26. Remove Duplicates from Sorted Array

class Solution {
    public int removeDuplicates(int[] nums) {
        int insertPos = 1;

        for(int i =1; i < nums.length; i++ ){
            if(nums[i-1] != nums[i]){
                nums[insertPos]  = nums[i];
                insertPos++;
            }
        }

        return insertPos;
        
    }
}