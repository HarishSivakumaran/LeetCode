// 377. Combination Sum IV

class Solution {
    int count = 0;
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target+1];
        comb[0] = 1; //only one way to add upto 0
        // Arrays.sort(nums);

        for(int i = 1; i  <= target; i++ ){
            for(int n : nums){
                if(i >= n){ comb[i] = comb[i] + comb[i-n];}
                // else break;
            }
        }

        return comb[target];
        // Arrays.sort(nums);
        // getComb(nums, 0 , target);
        // return this.count;
        
    }

    public void getComb(int[] nums, int sum, int t){
        if(sum == t){
            this.count++;
            return;
        }else if( sum > t){
            return;
        }else{
            for(int i = 0; i < nums.length; i++){
                if(sum+nums[i] > t) return;
                sum += nums[i];
                getComb(nums, sum, t);
                sum -= nums[i];
            }
        }
    }
}