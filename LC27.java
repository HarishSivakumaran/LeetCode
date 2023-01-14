// 27. Remove Element

class Solution {
    public int removeElement(int[] nums, int val) {
       
        int valIndex = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[valIndex] = nums[i];
                valIndex++;
            }
        }
        return valIndex;
        
    }
}