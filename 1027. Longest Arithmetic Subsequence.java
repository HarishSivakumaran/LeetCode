class Solution {
    HashMap<String, Integer> cache = new HashMap();
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer, List<Integer>> numLocations = new HashMap();
        for(int i = 0; i < nums.length; i++){
            numLocations.computeIfAbsent(nums[i], v->new ArrayList()).add(i);
        }

        int ans = 0, diff = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                diff = nums[j]-nums[i];
                ans = Math.max(ans, 2 + getMaxSeq(numLocations, j, diff, nums));
            }
        }

        return ans;
    }

    private int getMaxSeq(HashMap<Integer, List<Integer>> numLocations, int prevIndex, int diff, int[] nums){
        if(!numLocations.containsKey(nums[prevIndex]+diff)) return 0;
        int minIndex = getNextMinIndex(numLocations.get(nums[prevIndex]+diff), prevIndex);
        if(minIndex == -1) return 0;

        String key = prevIndex + "$" + diff;

        if(cache.containsKey(key)) return cache.get(key);

        cache.put(key, 1 + getMaxSeq(numLocations, minIndex, diff, nums));
        return cache.get(key);
    }

    private int getNextMinIndex(List<Integer> locs, int prevIndex){
        int l = 0, r = locs.size()-1, m = 0;

        while(l <= r){
            m = l + (r-l)/2;
            if(locs.get(m) > prevIndex){
                // you can use this, but better get something smaller
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l == locs.size() ? -1 : locs.get(l);
    }
}