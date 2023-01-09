// 416. Partition Equal Subset Sum

class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;    

        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        int t = sum/2;

        HashSet<Integer> sums = new HashSet();
        sums.add(0);

        for(int i = nums.length-1; i >= 0; i--){
            HashSet<Integer> s = new HashSet();
             if(nums[i] == t) return true;
                for(int j : sums){
                    s.add(j+nums[i]);
                    s.add(j);
                    if(j+nums[i] == t) return true;
                }
            sums = s;

        }

        return false;

        // Arrays.sort(nums);

        // return checkPartSum(nums,  t, 0, 0);
    }
