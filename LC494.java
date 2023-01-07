// 494. Target Sum

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return targetSumPerm(nums , target, 0, 0, new HashMap<String,Integer>());
    }

    public int targetSumPerm(int[] n , int target, int i, int t, HashMap<String,Integer> cache){
        if( i >= n.length ){
            return t == target ? 1 : 0;
        }

        String key = i + "-" + t;

        if(cache.containsKey(key)) return cache.get(key);


        int count = 0;

        count += targetSumPerm(n , target, i+1, t+n[i], cache);
        count += targetSumPerm(n , target, i+1, t-n[i], cache);

        cache.put(key, count);

        return count;


    }
}