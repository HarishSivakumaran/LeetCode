class Solution {
    public int minOperations(List<Integer> nums, int target) {
        long sum = 0;
        int[] count = new int[32];
        for(int n : nums) {
            sum += n;
            count[(int)(Math.log(n)/Math.log(2))]++;
        }
        if(sum < target) return -1;
        int missedBit = 32, ans = 0;

        for(int i = 0; i < 32; i++) {
            int bit = (1 << i);
            if((target&bit) != 0) {
                // target bit exists
                if(count[i] > 0){
                    count[i]--;
                } else {
                    missedBit = Math.min(missedBit, i);
                }
            }

            if(count[i] > 0 && missedBit < i) {
                ans += i-missedBit;
                count[i]--;
                missedBit = 32;
            }
            if(i < 31)
                count[i+1] += count[i]/2; 
        }

        return ans;

    }
    
    // private int getMinOp(List<Integer> nums, int target, int i) {
    //     if(subSeqPresent(nums, target)) return 0;
    //     if(i >= nums.size()) return 9999;
    //     int min = Integer.MAX_VALUE;
    //     // do the op
    //     if(nums.get(i) > 1) {
    //         int temp = nums.get(i);
    //         nums.set(i, 0);
    //         nums.add(temp/2);
    //         nums.add(temp/2);
    //         min = 1 + getMinOp(nums, target, i+1);
    //         nums.remove(nums.size()-1);
    //         nums.remove(nums.size()-1);
    //         nums.set(i, temp);
    //     }
        
    //     // do nothing
    //     min = Math.min(min, getMinOp(nums, target, i+1));
        
    //     return min;
    // }
    
    // private boolean subSeqPresent(List<Integer> nums, int target) {
    //     HashSet<Integer> set = new HashSet();  
    //     set.add(0);
    //     for(int n : nums){
    //         HashSet<Integer> temp = new HashSet();
    //         for(int v : set) {
    //             temp.add(v);
    //             temp.add(v+n);
    //         }      
    //         if(temp.contains(target)) return true;
    //         set = temp;
    //     }
        
    //     return false;
    // }
    
}