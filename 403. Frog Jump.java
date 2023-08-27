class Solution {
    HashMap<String, Boolean> cache = new HashMap();
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        return cross(stones, 1, 1);
    }

    private boolean cross(int[] stones, int index, int lastJump) {
        if(index >= stones.length-1) return true;

        String key = index + "-" + lastJump;
        if(cache.containsKey(key)) return cache.get(key);

        int min = stones[index]+lastJump-1;
        int max = stones[index]+lastJump+1;
        boolean reachable = false;

        for(int next = index+1; next < stones.length; next++) {
            if(stones[next] >= min && stones[next] <= max) {
                reachable |= cross(stones, next, stones[next]-stones[index]);
            }
            if(reachable) break;
        }

        cache.put(key, reachable);

        return reachable;
        
    }
}