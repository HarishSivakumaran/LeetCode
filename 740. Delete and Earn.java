class Solution {
    Integer[] cache = null;
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        int maxVal = 0;
        for(int n : nums) {count.put(n, count.getOrDefault(n, 0)+1); maxVal = Math.max(maxVal, n);}
        int[] dp = new int[maxVal+1];
        dp[1] = count.getOrDefault(1,0);
        
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-2]+(i*count.getOrDefault(i,0)), dp[i-1]);;
        }

        return dp[maxVal];
    }

    public int getMaxValue(int index, List<Integer> nums, HashMap<Integer, Integer> count, HashSet<Integer> removed){
        if(index >= nums.size()) return 0;
        int val = 0;


        // add the curren number
        int curr = nums.get(index);
        if(!removed.contains(curr)){
            removed.add(curr+1);
            removed.add(curr-1);
            val = curr*count.get(curr) + getMaxValue(index+1, nums, count, removed);
            removed.remove(curr+1);
            removed.remove(curr-1);
        }   

        // don't add the curr num'

        val = Math.max(val, getMaxValue(index+1, nums, count, removed));

        return val;
    }
}