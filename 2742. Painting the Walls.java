class Solution {
    Long[][] cache = null;
    public int paintWalls(int[] cost, int[] time) {
        cache = new Long[cost.length][30000];
        return (int) getMinCost(cost, time, 0 , 0);
    }

    private long getMinCost(int[] cost, int[] time, int index, int skipTime) {
        if(index >= cost.length) {
            return skipTime >= 0 ? 0 : Integer.MAX_VALUE;
        }

        if(cache[index][(skipTime+30000)%30000] != null) 
            return cache[index][(skipTime+30000)%30000];

        // paid worker
        long min = cost[index] + getMinCost(cost, time, index+1, skipTime+time[index]);

        // unpaid worker
        min = Math.min(min, getMinCost(cost, time, index+1, skipTime-1));

        return cache[index][(skipTime+30000)%30000] = min;
    }
}