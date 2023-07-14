class Solution {
    int ans = 1;
    HashMap<Integer, Integer> cache = new HashMap();
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
        }

        for(int i = 0; i < arr.length; i++){
            ans = Math.max(ans, getLongSeq(arr[i], difference, i, map));
        }

        return ans;
    }

    private int getLongSeq(int val, int diff, int minIndex, HashMap<Integer, List<Integer>> map) {
        if(!map.containsKey(val)) return 0; // curr num is not present
        if(cache.containsKey(minIndex)) return cache.get(minIndex);

        int len = 1;
        // find the next num
        if(map.containsKey(val+diff)){
            int next = getNextGreaterIndex(map.get(val+diff), minIndex);
            if(next < Integer.MAX_VALUE)
                len += getLongSeq(val+diff, diff, next, map);
        }

        cache.put(minIndex, len);

        return len;
    }

    private int getNextGreaterIndex(List<Integer> list, int index){
        int l = 0, r = list.size()-1, m = 0;

        while(l <= r) {
            m = l + (r-l)/2;
            if(list.get(m) > index){
                r = m-1;
            }else{
                l = m+1;
            }
        }

        return l == list.size() ? Integer.MAX_VALUE : list.get(l);
    }
}