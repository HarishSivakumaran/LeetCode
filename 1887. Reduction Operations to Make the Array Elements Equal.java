class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        int ans = 0;
        while(map.size() > 1) {
            int max = map.lastKey();
            int curr =  map.get(max);
            ans += curr;
            map.remove(max);
            int nextMax = map.lastKey();
            map.put(nextMax, map.get(nextMax)+curr);
        }

        return ans;
    }
}