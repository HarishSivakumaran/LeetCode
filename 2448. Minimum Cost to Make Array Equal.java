class Solution {

    public long minCost(int[] nums, int[] cost) {
        long total = 0, ans = Long.MAX_VALUE;
        long[] prefixSum = new long[nums.length];
        int[][] numsAndCost = new int[nums.length][2];
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
            min = Math.min(min, nums[i]);
        }

        Arrays.sort(numsAndCost, (a, b)->a[0]-b[0]);

        long pre = 0;

        for(int i = 0; i < nums.length; i++){
            prefixSum[i] = pre + numsAndCost[i][1];
            pre = prefixSum[i];
            total += ((long)(numsAndCost[i][0] - min) * (long)numsAndCost[i][1]);
        }

        ans = total;
        long newTotal = 0;

        for(int i = 1; i < nums.length; i++){
            int newBase = numsAndCost[i][0];
            newTotal = total + (prefixSum[i-1]*(newBase-min)) - ((prefixSum[nums.length-1]-prefixSum[i-1])*(newBase-min));
            ans = Math.min(ans, newTotal);
            total = newTotal;
            min = newBase;
        }

        return ans;
    }

    // public long checkIfMinCost(int[] nums, int[] cost, int toVal){
    //     if(toVal < min || toVal > max) return Long.MAX_VALUE;

    //     long currcost = 0, next = 0, prev = 0;

    //     if(cache.containsKey(toVal)) return cache.get(toVal);

    //     for(int i = 0; i < nums.length; i++){
    //         currcost += ((long)Math.abs(nums[i]-toVal)*cost[i]);
    //         next += ((long)Math.abs(nums[i]-toVal+1)*cost[i]);
    //         prev += ((long)Math.abs(nums[i]-toVal-1)*cost[i]);
    //     }

    //     cache.put(toVal, currcost);
    //     cache.put(toVal+1, next);
    //     cache.put(toVal-1, prev);

    //     System.out.println(cache);

    //     if(currcost == 0){return currcost;}

    //     if(Long.compare(currcost, prev) <= 0 && Long.compare(currcost, next) <= 0){
    //         return currcost;
    //     }
    //     if(Long.compare(prev, next) <= 0){
    //         return checkIfMinCost(nums, cost, toVal-1);
    //     }else{
    //         return checkIfMinCost(nums, cost, toVal+1);
    //     }
    // }

    
}