// 31. Next Permutation


class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 3){
            reverse(nums, 0);
            return;
        }

        int prev = nums[nums.length-1], i = nums.length-2;

        for(; i >= 0; i--){
            if(nums[i] < prev) break;
            prev = nums[i];
        }

        int min = 0;
        if(i != -1){
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    min = j;
                }else{
                    break;
                }
            }
            
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
            reverse(nums, i+1);
            
        }else{
            reverse(nums, 0);
        }
        
    }

    public void reverse(int[] nums, int s){
        int i = s, j = nums.length-1;

        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}