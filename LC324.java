// 324. Wiggle Sort II

class Solution {
    public void wiggleSort(int[] nums) {
        int median =  this.findKthLargest(nums, 0, nums.length-1);
        int l = 0, i = 0, r = nums.length-1;

        while(i <= r){
            int newIn = newIndex(i,nums.length);
            if(nums[newIn] > median){
                int temp = nums[newIn];
                nums[newIn] = nums[newIndex(l,nums.length)];
                nums[newIndex(l,nums.length)] = temp;
                i++;
                l++;
            }else if(nums[newIn] < median){
                int temp = nums[newIn];
                nums[newIn] = nums[newIndex(r,nums.length)];
                nums[newIndex(r,nums.length)] = temp;
                r--;

            }else{
                i++;
            }
        }
                
    }

    public int newIndex(int i, int n){
        return (1+(2*i)) % (n | 1);
    }

    public int findKthLargest(int[] nums, int l, int p){
        int insertPos = l, temp = 0;
        for(int i = l; i < p; i++){
            if(nums[i] <= nums[p]){
                temp = nums[i];
                nums[i] = nums[insertPos];                
                nums[insertPos] = temp;               
                insertPos++;
            }
        }
        temp = nums[p];
        nums[p] = nums[insertPos];              
        nums[insertPos] = temp; 

        if(insertPos == (nums.length)/2) return nums[insertPos];

        if(insertPos < (nums.length)/2) {
            return findKthLargest(nums, insertPos+1, p);
        }else{
            return findKthLargest(nums, l, insertPos-1);
        }


    }
}